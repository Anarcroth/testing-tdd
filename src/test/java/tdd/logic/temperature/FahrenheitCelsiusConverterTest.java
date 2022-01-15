package tdd.logic.temperature;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FahrenheitCelsiusConverterTest {

	@Test
	void shouldConvertToF() {

		assertEquals(32, FahrenheitCelsiusConverter.toFahrenheit(0));
		assertEquals(96, FahrenheitCelsiusConverter.toFahrenheit(36));
		assertEquals(212, FahrenheitCelsiusConverter.toFahrenheit(100));
	}

	@Test
	void shouldConvertToC() {

		assertEquals(0, FahrenheitCelsiusConverter.toCelsius(32));
		assertEquals(35, FahrenheitCelsiusConverter.toCelsius(96));
		assertEquals(100, FahrenheitCelsiusConverter.toCelsius(212));
	}

	@ParameterizedTest
	@MethodSource("getTempValues")
	void shouldConvertToFahrParam(int res, int c) {

		assertEquals(res, FahrenheitCelsiusConverter.toFahrenheit(c));
	}

	private static Stream<Arguments> getTempValues() {

		return Stream.of(
				Arguments.of(32, 0),
				Arguments.of(96, 36),
				Arguments.of(212, 100));
	}

	@ParameterizedTest
	@CsvSource({ "0,32", "35,96", "100,212" })
	void shouldConvertToCelParam(int res, int f) {

		assertEquals(res, FahrenheitCelsiusConverter.toCelsius(f));
	}
}
