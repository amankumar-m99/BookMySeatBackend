package m99.bookmyseat.serializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.collection.spi.PersistentBag;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.entity.Theater;

public class MovieBackReferenceSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object object, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if(object instanceof Movie) {
			serializeMovie((Movie) object, gen);
			return;
		}
		PersistentBag<?> bag = (PersistentBag<?>) object;
		if (bag.size() == 0) {
			gen.writeStartArray();
			gen.writeEndArray();
			return;
		}
		Object testObj = bag.get(0);
		gen.writeStartArray();
		if (testObj instanceof Movie) {
			Iterator<?> iterator = bag.iterator();
			while (iterator.hasNext()) {
				Movie movie = (Movie) iterator.next();
				serializeMovie(movie, gen); 
			}
		}
		gen.writeEndArray();
	}

	private void serializeMovie(Movie movie, JsonGenerator gen) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("id", movie.getId());
		gen.writeStringField("title", movie.getTitle());
		gen.writeStringField("description", movie.getDescription());
		gen.writeStringField("genre", movie.getGenre());
		gen.writeNumberField("duration", movie.getDuration());
		gen.writeStringField("language", movie.getLanguage());
		gen.writeNumberField("rating", movie.getRating());
		gen.writeStringField("posterUrl", movie.getPosterUrl());
		writeTheaters(movie.getTheaters(), gen);
		gen.writeStringField("releaseDate", movie.getReleaseDate().toString());
		gen.writeEndObject();
	}

	private void writeTheaters(List<Theater> theaters, JsonGenerator gen) throws IOException {
		gen.writeFieldName("theaters");
		gen.writeStartArray();
		if(theaters != null) {
			for (Theater theater : theaters) {
				gen.writeNumber(theater.getId());
			}
		}
		gen.writeEndArray();
	}
}
