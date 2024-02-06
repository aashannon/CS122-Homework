public class MoveToFrontList {

	private StringCountElement head; // the head reference
	private StringCountElement tail; // the tail reference
	private int size; // the size of the list (number of valid items)

	/**
	 * _Part 1: Implement this constructor._
	 * 
	 * Creates a new, initially empty MoveToFontList. This list should be a
	 * linked data structure.
	 */
	public MoveToFrontList() {
		// Creates head and tail sentinels and sets keys to unused Strings
		// Presets next and prev to each other respectively
		head = new StringCountElement();
		tail = new StringCountElement();
		head.key = "^^^";
		tail.key = "***";
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * This method increments the count associated with the specified string
	 * key. If no corresponding key currently exists in the list, a new list
	 * element is created for that key with the count of 1. When this method
	 * returns, the key will have rank 0 (i.e., the list element associated with
	 * the key will be at the front of the list)
	 * 
	 * @param key
	 *            the string whose count should be incremented
	 * @return the new count associated with the key
	 */
	public int incrementCount(String key) {
		StringCountElement s = find(key);
		if (s != null) {
			// found the key, splice it out and increment the count
			spliceOut(s);
			s.count++;
		} else {
			// need to create a new element
			s = new StringCountElement();
			s.key = key;
			s.count = 1;
		}
		// move it to the front
		spliceIn(s, 0);
		return s.count;
	}

	/**
	 * 
	 * @return the number of items in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * _Part 2: Implement this method._
	 * 
	 * Find the list element associated with the specified string. That is, find
	 * the StringCountElement that a key equal to the one specified
	 * 
	 * @param key
	 *            the key to look for
	 * @return a StringCountElement in the list with the specified key or null
	 *         if no such element exists.
	 */
	public StringCountElement find(String key) {
		// Searches through the DLL for matching key
		// returns object or null if not found
		StringCountElement curSore = head;
		while (!curSore.key.equals("***")){
			if(curSore.key.equals(key)){
				return curSore;
			}
			curSore = curSore.next;
		}
		return null;
	}

	/**
	 * _Part 3: Implement this method._
	 * 
	 * Compute the rank of the specified key. Rank is similar to position, so
	 * the first element in the list will have rank 0, the second element will
	 * have rank 1 and so on. However, an item that does not exist in the list
	 * also has a well defined rank, which is equal to the size of the list. So,
	 * the rank of any item in an empty list is 0.
	 * 
	 * @param key
	 *            the key to look for
	 * @return the rank of that item in the rank 0...size() inclusive.
	 */
	public int rank(String key) {
		// Searches through DLL for matching key and returns its rank
		int curRank = 0;
		StringCountElement curseOr = head.next;
		while (!curseOr.key.equals("***")){
			if (curseOr.key.equals(key)){
				return curRank;
			}
			curseOr = curseOr.next;
			curRank++;
		}
		return size;
	}

	/**
	 * _Part 4: Implement this method._
	 * 
	 * Splice an element into the list at a position such that it will obtain
	 * the desired rank. The element should either be new, or have been spliced
	 * out of the list prior to being spliced in. That is, it should be the case
	 * that: s.next == null && s.prev == null
	 * 
	 * @param s
	 *            the element to be spliced in to the list
	 * @param desiredRank
	 *            the desired rank of the element
	 */
	public void spliceIn(StringCountElement s, int desiredRank) {
		// Searches for desired rank and inserts new object by altering
		// the adjacent objects next and previous containers to point to the new
		// element and the elements to the previous ones respectively
		int rankCur = 0;
		StringCountElement curs = head.next;
		while(rankCur < desiredRank){
			rankCur++;
			curs = curs.next;
		}

		s.next = curs;
		s.prev = curs.prev;
		curs.prev.next = s;
		curs.prev = s;


		size++;

		return;
	}

	/**
	 * _Part 5: Implement this method._
	 * 
	 * Splice an element out of the list. When the element is spliced out, its
	 * next and prev references should be set to null so that it can safely be
	 * splicedIn later. Splicing an element out of the list should simply remove
	 * that element while maintaining the integrity of the list.
	 * 
	 * @param s
	 *            the element to be spliced out of the list
	 */
	public void spliceOut(StringCountElement s) {
		// Connects the adjacent elements to each other and leaves the
		// spliced out element null and deleted later by the trash collector
		s.prev.next = s.next;
		s.next.prev = s.prev;

		s.prev = null;
		s.next = null;
		size--;
		return;
	}

}
