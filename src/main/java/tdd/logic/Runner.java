package tdd.logic;

import tdd.logic.str.StringReverser;

public class Runner {

	public static void main(String[] args) {

		Runner r = new Runner();

		System.out.println(r.getBasicString());

		System.out.println(StringReverser.reverse("reverse this string"));
	}

	public String getBasicString() {

		return "basicTest";
	}
}
