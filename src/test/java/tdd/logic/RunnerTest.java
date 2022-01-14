package tdd.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RunnerTest {

	private Runner runner;

	@BeforeEach
	void setup() {

		runner = new Runner();
	}

	@Test
	void checkString() {

		assertEquals("basicTest", runner.getBasicString());
	}
}
