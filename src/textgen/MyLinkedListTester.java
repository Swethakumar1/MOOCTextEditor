/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC SanDiego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 
	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		//short list removal
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.head.data); 
		
		
		//longer list removal 
		int b=list1.remove(list1.size()-1); 
		assertEquals("Remove: check b is correct", 42, b); 
		assertEquals("Remove: check element last - 1 is correct ", (Integer)21, list1.get(list1.size() - 1)); 
		
		
			try {
				longerList.remove(-1);
				fail("Check out of bounds");
			} catch (IndexOutOfBoundsException e) {
			}

			
			try {
				shortList.remove(2);
				fail("Check out of bounds");
			} catch (IndexOutOfBoundsException e) {

			}
		
	}
	
	
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element) 
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test 
	try{
		list1.add(null); 
		fail("Attempted to add a null element"); 
	}
		catch(NullPointerException e){
		}
	
	boolean result = emptyList.add(55);
	assertEquals("Add @ End Failed ", true, result);
	assertEquals("Incorrect value added", (Integer) 55, emptyList.get(0));
	assertEquals("Add @ End size incorrect ", 1, emptyList.size());

	boolean result1 = emptyList.add(22);
	assertEquals("Add @ End Failed ", true, result1);
	assertEquals("Incorrect value added", (Integer) 22, emptyList.get(1));
	assertEquals("Add @ End size incorrect ", 2, emptyList.size());
		}
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		//TODO: implement this test 
		list1.add(86);
		assertEquals("Add: check size is correct ", 4, list1.size());  
		assertEquals("Add: check size is correct ", 10, longerList.size()); 
		assertEquals("Add: check size is correct ", 2, shortList.size()); 
		
	}
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test 
		try{
				shortList.add(1,null); 
				fail("Attempted to add a null element"); 
		      
		}
		catch (NullPointerException e){
		}
		
		try{
			 	shortList.add(3,"X"); 
			 	fail("Check out of Bounds"); 
			
		}
		catch(IndexOutOfBoundsException e){
			
		}
		try{
			longerList.add(-3,55); 
			fail("Check out of Bounds"); 
		}
		catch(IndexOutOfBoundsException e){
			
		}
		longerList.add(4,99); 
		//assertEquals("Add @ Index Element Check ", (Integer) 99, longerList.get(4));
		assertEquals("Add @ size:",11,longerList.size()); 
	}
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			shortList.set(0, null);
			fail("Null element set failed");
		} catch (NullPointerException e) {

		}

		try {
			shortList.set(3, "X");
			fail("Out of Bounds failed");
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			longerList.set(-3, 8);
			fail("Out of Bounds Failed ");
		} catch (IndexOutOfBoundsException e) {
		}

		shortList.set(1, "X");
		assertEquals("Value Check", (String) "X", shortList.get(1));
		assertEquals("Size Check", 2, shortList.size());
		longerList.set(2, 99);
		assertEquals("Value Check", (Integer) 99, longerList.get(2));
		assertEquals("Size Check", 10, longerList.size());
	}


	    
	}
	
	
	// TODO: Optionally add more test methods.
	

