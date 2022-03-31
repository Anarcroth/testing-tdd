package tdd.logic.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class PasswordValidatorTest {

	@Test
	void passwordIsValid() {

		assertTrue(PasswordValidator.validatePassword("haha"));
	}

	@Test
	void throwOnNullInput() {

		NullPointerException npe = assertThrows(
				NullPointerException.class, () -> PasswordValidator.validatePassword(null));

		assertEquals("Password cannot be null!", npe.getMessage());
	}

	@Test
	void passwordIsTooShort() {

		assertFalse(PasswordValidator.validatePassword("123456"));
		assertTrue(PasswordValidator.validatePassword("12345678"));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sb.append("a");
		}
		assertTrue(PasswordValidator.validatePassword(sb.toString()));
	}

	@Test
	void passwordDoesNotContainDigits() {

		fail();
	}

	@Test
	void passwordDoesNotContainSpecialCharacters() {

		fail();
	}

	@Test
	void passwordDoesNotContainChars() {

		fail();
	}

	@Test
	void passwordDoesNotHaveAMixOfCharsAndSymbols() {

		fail();
	}
}
