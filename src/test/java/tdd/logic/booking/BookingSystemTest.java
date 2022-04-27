package tdd.logic.booking;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookingSystemTest {

	private BookingSystem bookingSystem;

	@Test
	void getBookedHours() {

		bookingSystem = new BookingSystem("Hotel");
		List<Integer> bookedHours = bookingSystem.getBookedHours("Hotel");

		assertThat(bookedHours, empty());

		bookingSystem = new BookingSystem("Circus", 13, 14, 15, 20, 9, 8);
		List<Integer> bookedHours2 = bookingSystem.getBookedHours("Circus");

		assertThat(bookedHours2, notNullValue());
		assertThat(bookedHours2, is(not(empty())));
		assertThat(bookedHours2, hasSize(6));

		bookingSystem = new BookingSystem("Dancing", 8, 9, 10);
		bookingSystem.addBookings("Jumping", 8, 9, 10);

		List<Integer> dancing = bookingSystem.getBookedHours("Dancing");
		List<Integer> jumping = bookingSystem.getBookedHours("Jumping");
		assertThat(dancing, equalTo(jumping));
		assertThat(dancing, hasSize(3));
		assertThat(jumping, hasSize(3));
	}

	@Test
	void failAddingRepeatedBooking() {

		assertThrows(
				IllegalArgumentException.class,
				() -> new BookingSystem("Opera", 13, 14, 15, 13));

		bookingSystem = new BookingSystem();

		bookingSystem.addBooking("Ice skating", 13);
		bookingSystem.addBooking("Ice skating", 14);
		bookingSystem.addBooking("Ice skating", 15);
		assertThrows(IllegalArgumentException.class, () -> bookingSystem.addBooking("Ice skating", 14));

		bookingSystem = new BookingSystem();

		assertThrows(IllegalArgumentException.class, () -> bookingSystem.addBookings("Car wash", 13, 14, 15, 15));
	}

	@Test
	void passWrongDataToBooking() {

		assertThrows(NullPointerException.class, () -> new BookingSystem("Library", 1, 2, 3, null));
		assertThrows(NullPointerException.class, () -> new BookingSystem().addBooking("Cooking", null));
		assertThrows(NullPointerException.class, () -> new BookingSystem().addBookings("Cleaning", 1, 2, null));

		assertThrows(IllegalArgumentException.class, () ->
				new BookingSystem("Reading", -1, -20, 1012, 200, Integer.MAX_VALUE));
		assertThrows(IllegalArgumentException.class, () -> new BookingSystem().addBooking("Coding", Integer.MIN_VALUE));
		assertThrows(IllegalArgumentException.class, () -> new BookingSystem().addBookings("Movies", 30, 32, -30));

		new BookingSystem("Drifting", 0, 24);
	}
}