package tdd.logic.booking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.Validate;

public class BookingSystem {

	private final Map<String, BookedHours> bookingSystem;

	public BookingSystem() {

		bookingSystem = new HashMap<>();
	}

	public BookingSystem(String thing, Integer... hoursToBook) {

		bookingSystem = new HashMap<>();
		addBookings(thing, hoursToBook);
	}

	public List<Integer> getBookedHours(String thing) {

		return bookingSystem.get(thing).getBookedHours();
	}

	public void addBooking(String thing, Integer hourToBook) {

		bookingSystem.computeIfAbsent(thing, k -> new BookedHours()).addBooking(hourToBook);
	}

	public void addBookings(String thing, Integer... hoursToBook) {

		bookingSystem.computeIfAbsent(thing, k -> new BookedHours()).addBookings(hoursToBook);
	}

	private static class BookedHours {

		private final Set<Integer> bookedHours;

		BookedHours() {

			bookedHours = new HashSet<>();
		}

		public List<Integer> getBookedHours() {

			return bookedHours.stream().collect(Collectors.toList());
		}

		private void addBooking(Integer toBook) {

			Validate.notNull(toBook, "Booking hour cannot be null!");
			Validate.isTrue(toBook >= 0 && toBook <= 24, "Booking cannot be for an illegal hour");

			if (!bookedHours.add(toBook)) {

				throw new IllegalArgumentException(
						String.format("Cannot add a booking to the same hour [%d]!", toBook));
			}
		}

		public void addBookings(Integer... hoursToBook) {

			for (Integer hour : hoursToBook) {

				addBooking(hour);
			}
		}
	}
}
