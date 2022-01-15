package tdd.logic.temperature;

public class FahrenheitCelsiusConverter {

	public static int toFahrenheit(int c) {

		return (c * 9 / 5) + 32;
	}

	public static int toCelsius(int f) {

		return (f - 32) * 5 / 9;
	}
}
