import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ChainedTable<K, V> {
	LinkedList<Entry<K, V>>[] bucketArray;
	static int collisions;


	@SuppressWarnings("unchecked")
	/**
	 * Create a ChainedTableSolution instance with the specified
	 * number of buckets.
	 * 
	 * @param buckets the number of buckets to make in this table
	 */
	public ChainedTable(int buckets) {
		bucketArray = (LinkedList<Entry<K, V>>[]) new LinkedList[buckets];
		collisions = 0;
		for (int i = 0; i < bucketArray.length; i++) {
			bucketArray[i] = new LinkedList<Entry<K, V>>();

		}
	}




	/**
	 * _Part 1: Implement this method._
	 *
	 * Puts an entry into the table. If the key already exists,
	 * it's value is updated with the new value and the previous
	 * value is returned.
	 * 
	 * @param key
	 *            the object used as a key to retrieve the value
	 * @param value
	 *            the object stored in association with the key
	 * 
	 * @throws IllegalArgumentException
	 *            if the value parameter is null
	 *
	 * @return the previously stored value or null if the key is new
	 */
	public V put(K key, V value) {
		// This will create the absolute value of a hashcode and checks to see if the value is null
		// Checks every bucket for the passed key and if it was not added, then a new bucket Entry is added

		int indexKey = Math.abs(key.hashCode() % bucketArray.length);
		boolean added = false;

		if (value == null){
			throw new IllegalArgumentException("Value can not be Null");
		}

		for (Entry<K, V> entryNode : bucketArray[indexKey]){
			if (entryNode.key.equals(key)){
				V prevValue = entryNode.value;
				entryNode.value = value;
				added = true;
				return prevValue;
			}
		}

		if (!added){
			bucketArray[indexKey].add(new Entry<>(key, value));
		}
		return null;
	}

	/**
	 * _Part 2: Implement this method._
	 *
	 * Retrieves the value associated with the specified key. If
	 * it exists, the value stored with the key is returned, if no
	 * value has been associated with the key, null is returned.
	 * 
	 * @param key
	 *            the key object whose value we wish to retrieve
	 * @return the associated value, or null
	 */
	public V get(K key) {
		// Iterates over each bucket in the Array checking for matching keys, returns if found
		// otherwise returns null

		int getIndex = Math.abs(key.hashCode() % bucketArray.length);

		for(Entry<K, V> entryNode: bucketArray[getIndex]){
			if (entryNode.key.equals(key)){
				return entryNode.value;
			}
		}
		return null;
	}

	/**
	 * _Part 3: Implement this method._
	 *
	 * Looks through the entire bucket where the specified key
	 * would be found and counts the number of keys in this bucket
	 * that are not equal to the current key, yet still have the
	 * same hashcode. Be efficient! (i.e., recall that calling .get()
	 * on a linked list is O(n) where n is the size of the list)
	 *
	 *
	 * @param key
	 * @return a count of collisions
	 */
	public int countTrueCollisions(K key) {
		// Checks every bucket for non-matching keys, then checks if the hashcode matches the key's
		// if conditions are met, then collision counter will increment

		int countIndex = Math.abs(key.hashCode() % bucketArray.length);
		int collCount = 0;

		for (Entry<K, V> entryNode : bucketArray[countIndex]){
			if(entryNode.key.equals(key) != true){
				if(entryNode.key.hashCode() == key.hashCode()){
					collCount++;

				}
			}
		}

		return collCount;
	}


	/**
	 * _Part 4: Implement this method._
	 *
	 * Returns the number of entries (i.e., Entry instances) in
	 * this table
	 * 
	 * @return the number of entries.
	 */
	public int size() {
		// Iterates through every bucket and increments the count for every Entry that present
		// returns the count

		int countEntry = 0;

		for(LinkedList<Entry<K, V>> entryNode : bucketArray){
			countEntry += entryNode.size();
		}
		return countEntry;
	}


	public static class Entry<K, V> {
		K key;
		V value;

		public Entry(K k, V v) {
			key = k;
			value = v;
		}
	}


	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("./bigtext.txt"));

		ChainedTable<String, Integer> map = new ChainedTable<String, Integer>(
				1000);

		String watch = "The!!!;";
		String str;
		Integer value;
		System.out.println("Reading");
		int i = 0;
		long start = System.nanoTime();
		while (s.hasNext()) {
			str = s.next();
			if (str.equals(watch)) System.out.println(watch);
			value = map.get(str);
			// System.out.println("Got "+str);
			if (value == null) {
				map.put(str, 1);

			} else {
				map.put(str, value + 1);

			}
			i++;
			if (i % 5000 == 0)
				System.out.println("Read " + i + " words");

		}
		System.out.println("Hashed!");
		System.out.println(watch + " " + watch.hashCode() + " was seen " + map.get(watch) + " times");
		System.out.println("It took " + (System.nanoTime() - start) / 1.0E9 + " seconds");
		System.out.println(map.size());


		/*   ----------------------------Tests------------------------------     */

		/**
		 * These test the individual methods designed in the above section
		 * Check the get, size before and after 'put', and also checks for collisions
		 * */

		System.out.println("Chicken was seen " + map.get("chicken") + " times");
		System.out.println("My Hashtable is " + map.size() + " units large");
		map.put("Superdog", 22);
		System.out.println("My Hashtable is now " + map.size() + " units large");
		System.out.println(map.get("Superdog") + " was added successfully");
		System.out.println(map.countTrueCollisions("Superdog") + " other 'Superdog' were found");
		System.out.println(collisions + " collisions");
	}

}
