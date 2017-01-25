package freecell.util;


import java.util.HashMap;
import java.util.Map;

/**
 * Maps a pair of coordinates to an object.
 *
 * @param <K1>
 *            the first coordinate
 * @param <K2>
 *            the second coordinate
 * @param <V>
 *            the treasure
 */
public class DoubleKeyedMap<K1, K2, V> {

	private Map<K1, Map<K2, V>> map = new HashMap<>();

	public boolean contains(K1 firstKey, K2 secondKey) {
		return map.containsKey(firstKey) && map.get(firstKey).containsKey(secondKey);
	}

	public V get(K1 firstKey, K2 secondKey) {
		return map.get(firstKey).get(secondKey);
	}

	/**
	 * Returns the old value if it exists, or null.
	 */
	public V put(K1 firstKey, K2 secondKey, V newValue) {
		if (!map.containsKey(firstKey)) {
			map.put(firstKey, new HashMap<>());
		}
		return map.get(firstKey).put(secondKey, newValue);
	}
}