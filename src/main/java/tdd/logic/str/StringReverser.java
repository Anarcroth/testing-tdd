package tdd.logic.str;

import java.util.ArrayList;
import java.util.List;

public class StringReverser {

	public static String reverse(String s) {

		List<String> tempArr = new ArrayList<>(s.length());
		for (int i = 0; i < s.length(); i++) {

			tempArr.add(s.substring(i, i + 1));
		}

		StringBuilder reversedString = new StringBuilder(s.length());
		for (int i = tempArr.size() - 1; i >= 0; i--) {

			reversedString.append(tempArr.get(i));
		}

		return reversedString.toString();
	}
}
