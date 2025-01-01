package m99.bookmyseat.serializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.collection.spi.PersistentBag;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import m99.bookmyseat.entity.Movie;
import m99.bookmyseat.entity.Screen;
import m99.bookmyseat.entity.Showtime;
import m99.bookmyseat.entity.Theater;
import m99.bookmyseat.entity.Timeslot;
import m99.bookmyseat.entity.User;

public class TheaterBackReferenceSerializer extends JsonSerializer<Object> {

	@Override
	public void serialize(Object object, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if(object instanceof Theater) {
			serializeTheater((Theater) object, gen);
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
		if (testObj instanceof Theater) {
			Iterator<?> iterator = bag.iterator();
			while (iterator.hasNext()) {
				Theater theater = (Theater) iterator.next();
				serializeTheater(theater, gen);
			}
		}
		gen.writeEndArray();
	}

	private void serializeTheater(Theater theater, JsonGenerator gen) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("id", theater.getId());
		gen.writeStringField("name", theater.getName());
		gen.writeStringField("location", theater.getLocation());
		gen.writeStringField("phoneNumber", theater.getPhoneNumber());
		writeOwner(theater.getOwner(), gen);
		writeTimeslots(theater.getTimeslots(), gen);
		writeMovies(theater.getMovies(), gen);
		writeShowtimes(theater.getShowtimes(), gen);
		writeScreens(theater.getScreens(), gen);
		gen.writeStringField("createdAt", theater.getCreatedAt().toString());
		gen.writeEndObject();
	}

	private void writeOwner(User owner, JsonGenerator gen) throws IOException {
		gen.writeFieldName("owner");
		gen.writeStartObject();
		if(owner != null) {
			gen.writeNumberField("id", owner.getId());
		}
		gen.writeEndObject();
	}

	private void writeTimeslots(List<Timeslot> timeslots, JsonGenerator gen) throws IOException {
		gen.writeFieldName("timeslots");
		gen.writeStartArray();
		if(timeslots != null) {
			for (Timeslot timeslot : timeslots) {
				writeTimeslot(timeslot, gen);
			}
		}
		gen.writeEndArray();
	}

	private void writeTimeslot(Timeslot timeslot, JsonGenerator gen) throws IOException {
		gen.writeStartObject();
		gen.writeNumberField("id", timeslot.getId());
		gen.writeNumberField("startHH", timeslot.getStartHH());
		gen.writeNumberField("startMM", timeslot.getStartMM());
		gen.writeEndObject();
	}

	private void writeMovies(List<Movie> movies, JsonGenerator gen) throws IOException {
		gen.writeFieldName("movies");
		gen.writeStartArray();
		if(movies != null) {
			for (Movie movie : movies) {
				writeMovie(movie, gen);
			}
		}
		gen.writeEndArray();
	}

	private void writeShowtimes(List<Showtime> showtimes, JsonGenerator gen) throws IOException {
		gen.writeFieldName("showtimes");
		gen.writeStartArray();
		if(showtimes != null) {
			for (Showtime showtime : showtimes) {
				gen.writeStartObject();
				gen.writeNumberField("id", showtime.getId());
				if(showtime.getTimeslot() != null) {
					gen.writeFieldName("timeslot");
					writeTimeslot(showtime.getTimeslot(), gen);
				}
				gen.writeFieldName("movie");
				writeMovie(showtime.getMovie(), gen);
				gen.writeEndObject();
			}
		}
		gen.writeEndArray();
	}

	private void writeMovie(Movie movie, JsonGenerator gen) throws IOException {
		gen.writeStartObject();
		if(movie != null) {
			gen.writeNumberField("id", movie.getId());
			gen.writeStringField("title", movie.getTitle());
			gen.writeStringField("description", movie.getDescription());
			gen.writeStringField("genre", movie.getGenre());
			gen.writeNumberField("duration", movie.getDuration());
			gen.writeStringField("language", movie.getLanguage());
			gen.writeNumberField("rating", movie.getRating());
			gen.writeStringField("posterUrl", movie.getPosterUrl());
			gen.writeStringField("releaseDate", movie.getReleaseDate().toString());
		}
		gen.writeEndObject();
	}

	private void writeScreens(List<Screen> screens, JsonGenerator gen) throws IOException {
		gen.writeFieldName("screens");
		gen.writeStartArray();
		if(screens != null) {
			for (Screen screen : screens) {
				gen.writeStartObject();
				gen.writeNumberField("id", screen.getId());
				gen.writeStringField("name", screen.getName());
				gen.writeEndObject();
			}
		}
		gen.writeEndArray();
	}
}
