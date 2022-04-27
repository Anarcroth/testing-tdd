package tdd.logic.booking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.Validate;

public class BookingSystem {

	private final Set<Integer> bookedHours;

	public BookingSystem(Integer... hoursToBook) {

		bookedHours = new HashSet<>();
		addBookings(hoursToBook);
	}

	public List<Integer> getBookedHours() {

		return bookedHours.stream().collect(Collectors.toList());
	}

	public void addBooking(Integer toBook) {

		Validate.notNull(toBook, "Booking hour cannot be null!");
		Validate.isTrue(toBook >= 0 && toBook <= 24, "Booking cannot be for an illegal hour");

		if (!bookedHours.add(toBook)) {

			throw new IllegalArgumentException(String.format("Cannot add a booking to the same hour [%d]!", toBook));
		}
	}

	public void addBookings(Integer... hoursToBook) {

		for (Integer hour : hoursToBook) {

			addBooking(hour);
		}
	}
}
