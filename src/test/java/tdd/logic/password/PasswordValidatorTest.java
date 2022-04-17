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

		assertTrue(PasswordValidator.validatePassword("X8zS0kayAs3tze1rI*jSrlRV0a7UQtL"));
		assertTrue(PasswordValidator.validatePassword(">^U-~b2`!G=UyM5VGl('&x<1\"mBA\",w"));
		assertTrue(PasswordValidator.validatePassword("tçÀ¾÷ÍµsØ7¦OXª8\\=TÃG}:P«jiòUæ!"));
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
		assertFalse(PasswordValidator.validatePassword("12345678910"));
		assertTrue(PasswordValidator.validatePassword("123456789102aoeuaoeu!@#$!@#$"));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
			sb.append("a");
		}
		sb.append(1234);
		sb.append("1@#$!@#$");
		assertTrue(PasswordValidator.validatePassword(sb.toString()));
	}

	@Test
	void passwordDoesNotContainDigits() {

		assertFalse(PasswordValidator.validatePassword("E@_HHeAVUE%_[C-bXdpl`?YUoIo;Po"));
		assertFalse(PasswordValidator.validatePassword("±ûÝ?yÑßXÔ`ö¤äñyå'ùñÔî§KA£b{H¤"));
		assertTrue(PasswordValidator.validatePassword("tçÀ¾÷ÍµsØ7¦OXª8\\=TÃG}:P«jiòUæ!e"));
	}

	@Test
	void passwordDoesNotContainSpecialCharacters() {

		assertTrue(PasswordValidator.validatePassword("E@1_HHeAVUE%_[C-bXdpl`?YU3oIo;Po"));
		assertFalse(PasswordValidator.validatePassword("oocFyKZHWurrLwPDwChLnClAKPlFSa"));
	}

	@Test
	void passwordDoesNotContainChars() {

		assertFalse(PasswordValidator.validatePassword("1234123412341234**"));
		assertFalse(PasswordValidator.validatePassword(",:*)@}'/)@_)-<:,:[123=^??(_\\!*~&*"));
	}

	@Test
	void passwordDoesNotHaveAMixOfCharsAndSymbols() {

		assertFalse(PasswordValidator.validatePassword("12341234123412{}]['234][][21]1234][**"));
		assertFalse(PasswordValidator.validatePassword(",:*)@}'/)@_)-<:,:[123=^??(_\\!*~&1234!@#$1234*"));
		assertTrue(PasswordValidator.validatePassword("123412!@#$!@#$aouikao41234EOUI12341AOUI',341234"));
	}
}
