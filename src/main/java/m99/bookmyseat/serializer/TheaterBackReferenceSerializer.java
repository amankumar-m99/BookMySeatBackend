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
		writeOwner(gen, theater.getOwner());
		writeTimeslots(gen, theater.getTimeslots());
		writeMovies(gen, theater.getMovies());
		writeShowtimes(gen, theater.getShowtimes());
		writeScreens(gen, theater.getScreens());
		gen.writeStringField("createdAt", theater.getCreatedAt().toString());
		gen.writeEndObject();
	}

	private void writeOwner(JsonGenerator gen, User owner) throws IOException {
		gen.writeFieldName("owner");
		gen.writeStartObject();
		if(owner != null) {
			gen.writeNumberField("id", owner.getId());
		}
		gen.writeEndObject();
	}

	private void writeTimeslots(JsonGenerator gen, List<Timeslot> timeslots) throws IOException {
		gen.writeFieldName("timeslots");
		gen.writeStartArray();
		if(timeslots != null) {
			for (Timeslot timeslot : timeslots) {
				gen.writeStartObject();
				gen.writeNumberField("id", timeslot.getId());
				gen.writeNumberField("startHH", timeslot.getStartHH());
				gen.writeNumberField("startMM", timeslot.getStartMM());
				gen.writeEndObject();
			}
		}
		gen.writeEndArray();
	}

	private void writeMovies(JsonGenerator gen, List<Movie> movies) throws IOException {
		gen.writeFieldName("movies");
		gen.writeStartArray();
		if(movies != null) {
			for (Movie movie : movies) {
				gen.writeNumber(movie.getId());
			}
		}
		gen.writeEndArray();
	}

	private void writeShowtimes(JsonGenerator gen, List<Showtime> showtimes) throws IOException {
		gen.writeFieldName("showtimes");
		gen.writeStartArray();
		if(showtimes != null) {
			for (Showtime showtime : showtimes) {
				gen.writeStartObject();
				gen.writeNumberField("id", showtime.getId());
				gen.writeNumberField("startHH", showtime.getStartHH());
				gen.writeNumberField("startMM", showtime.getStartMM());
				gen.writeStringField("startTime", showtime.getStartTime().toString());
				gen.writeFieldName("movie");
				gen.writeStartObject();
				if(showtime.getMovie() != null) {
					gen.writeNumberField("id", showtime.getMovie().getId());
				}
				gen.writeEndObject();
				gen.writeEndObject();
			}
		}
		gen.writeEndArray();
	}

	private void writeScreens(JsonGenerator gen, List<Screen> screens) throws IOException {
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
