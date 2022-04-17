package tdd.logic.password;

import org.apache.commons.lang3.Validate;

public class PasswordValidator {

	public static boolean validatePassword(String password) throws NullPointerException {

		Validate.notNull(password, "Password cannot be null!");

		if (password.length() <= 11) {

			return false;
		}
		boolean hasNum = false;
		boolean hasSpecialChars = false;
		boolean hasChars = false;
		for (char c : password.toCharArray()) {

			if (c >= 48 && c <= 57) {

				hasNum = true;
			}
			if ((c >= 33 && c <= 47) ||
					(c >= 58 && c <= 64) ||
					(c >= 91 && c <= 96) ||
					(c >= 123 && c <= 126)) {

				hasSpecialChars = true;
			}
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {

				hasChars = true;
			}
		}
		if (!hasNum) {

			return false;
		}
		if (!hasSpecialChars) {

			return false;
		}
		if (!hasChars) {

			return false;
		}
		return true;
	}
}
