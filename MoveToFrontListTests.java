import static org.junit.Assert.*;

import org.junit.Test;
//import wsuv.autolab.Score;

public class MoveToFrontListTests {

	@Test
//	@Score(1)
	public void testFindOnEmptyList() {
		MoveToFrontList l = new MoveToFrontList();
		assertNull("I should't find anything in an empty list!", l.find(""));
	}
	@Test
//	@Score(1)
	public void testSizeOnEmptyList() {
		MoveToFrontList l = new MoveToFrontList();
		assertEquals("Size of empty list should be 0", 0, l.size());
	}
	@Test
//	@Score(1)
	public void testRankWithNoItems() {
		MoveToFrontList l = new MoveToFrontList();
		assertEquals("Size of empty list should be 0", 0, l.size());
		assertEquals("Check the rank for an empty list...", 
			     0, l.rank("Hi"));
	}
	@Test
//	@Score(1)
	public void testAddOneItem() {
		MoveToFrontList l = new MoveToFrontList();
		l.incrementCount("Hi");
		assertEquals("Adding to the list with incrementCount is broken, or size() returns a bad value", 
			     1, l.size());
	}
	@Test
//	@Score(1)
	public void testRankWithOneItem() {
		MoveToFrontList l = new MoveToFrontList();
		l.incrementCount("Hi");
		assertEquals("Adding to the list with incrementCount is broken, or size() returns a bad value", 
			     1, l.size());
		assertEquals("The rank of a your first item should be 0", 
			     0, l.rank("Hi"));
		assertEquals("The rank of an item not in the list should be 1 here.",
			     1, l.rank("Hip"));
	
	}
}
