package tdd.logic.map;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HashMapTest {

	private Map<String, Integer> map;

	@BeforeEach
	void setup() {

		map = new HashMap<>();
		map.put("key1", 1);
	}

	@Test
	void get() {

		assertEquals(1, map.get("key1"));
	}

	@Test
	void putShallReplace() {

		map.put("key1", 2);

		assertEquals(2, map.get("key1"));
		assertTrue(map.get("key1") != 1);
	}

	@Test
	void clear() {

		map.clear();

		assertTrue(map.isEmpty());
	}

	@Test
	void nullIsValidKey() {

		map.put(null, 10);

		assertEquals(10, map.get(null));
	}
}
