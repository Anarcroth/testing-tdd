package tdd.logic.booking;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingSystemTest {

	private BookingSystem bookingSystem;

	@Test
	void getBookedHours() {

		bookingSystem = new BookingSystem();
		List<Integer> bookedHours = bookingSystem.getBookedHours();

		assertTrue(bookedHours.isEmpty());

		bookingSystem = new BookingSystem(13, 14, 15, 20, 9, 8);
		List<Integer> bookedHours2 = bookingSystem.getBookedHours();

		assertNotNull(bookedHours2);
		assertFalse(bookedHours2.isEmpty());
		assertEquals(6, bookedHours2.size());
	}

	@Test
	void failAddingRepeatedBooking() {

		assertThrows(
				IllegalArgumentException.class,
				() -> new BookingSystem(13, 14, 15, 13));

		bookingSystem = new BookingSystem();

		bookingSystem.addBooking(13);
		bookingSystem.addBooking(14);
		bookingSystem.addBooking(15);
		assertThrows(IllegalArgumentException.class, () -> bookingSystem.addBooking(14));

		bookingSystem = new BookingSystem();

		assertThrows(IllegalArgumentException.class, () -> bookingSystem.addBookings(13, 14, 15, 15));
	}

	@Test
	void passWrongDataToBooking() {

		assertThrows(NullPointerException.class, () -> new BookingSystem(1, 2, 3, null));
		assertThrows(NullPointerException.class, () -> new BookingSystem().addBooking(null));
		assertThrows(NullPointerException.class, () -> new BookingSystem().addBookings(1, 2, null));

		assertThrows(IllegalArgumentException.class, () -> new BookingSystem(-1, -20, 200, 1012, Integer.MAX_VALUE));
		assertThrows(IllegalArgumentException.class, () -> new BookingSystem().addBooking(Integer.MIN_VALUE));
		assertThrows(IllegalArgumentException.class, () -> new BookingSystem().addBookings(30, 32, -30));

		new BookingSystem(0, 24);
	}
}