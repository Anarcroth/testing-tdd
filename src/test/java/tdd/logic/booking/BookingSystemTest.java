package tdd.logic.booking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class BookingSystemTest {

	private BookingSystem bookingSystem;

	@Test
	void getBookedHours() {

		bookingSystem = new BookingSystem();
		bookingSystem.getBookedHours();
	}

	@Test
	void failAddingRepeatedBooking() {

		fail();
	}

	@Test
	void passWrongDataToBooking() {

		fail();
	}
}