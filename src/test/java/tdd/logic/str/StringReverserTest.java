package tdd.logic.str;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringReverserTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "reverse this string", "1234"})
	void reverse(String s) {

		StringBuilder revB = new StringBuilder(s);
		assertEquals(revB.reverse().toString(), StringReverser.reverse(s));
	}

	@Test
	void reverseRand() {

		StringBuilder sb = new StringBuilder(UUID.randomUUID().toString());
		String uuid = sb.toString();
		assertEquals(sb.reverse().toString(), StringReverser.reverse(uuid));
	}

	@Test
	void failReverseOnNull() {

		assertThrows(NullPointerException.class, () -> StringReverser.reverse(null));
	}
}
