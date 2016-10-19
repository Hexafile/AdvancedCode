import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {
	
	BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>(10,"Chronos");

	@Test
	public void testSize(){
		tree.put(13, "Zeus");
		assertEquals(2,tree.size());
		tree.put(2, "Athena");
		tree.put(6, "Ares");
		assertEquals(4,tree.size());
	}
	
	@Test
	public void testPut(){
		assertEquals(null,tree.put(7, "Truc"));
		assertEquals("Chronos", tree.put(10, "qqchose"));
		assertEquals(null,tree.put(3, "Hades"));
		assertEquals(null,tree.put(13, "plus"));
	}
	
	@Test
	public void testContains(){
		tree.put(7, "Truc");
		tree.put(10, "qqchose");
		tree.put(3, "Hades");
		assertEquals(true, tree.containsKey(10));
		assertEquals(true, tree.containsKey(3));
		assertEquals(true, tree.containsKey(7));
	}
	
	@Test
	public void testToString(){
		assertEquals("(10-Chronos(null-null)(null-null))", tree.toString());
	}
	
	@Test
	public void testRemove(){
		tree.put(7, "Truc");
		tree.put(10, "qqchose");
		tree.put(3, "Hades");
		tree.put(2, "Athena");
		tree.put(6, "Ares");
		tree.remove(7);
		System.out.println(tree);
	}
	
}
