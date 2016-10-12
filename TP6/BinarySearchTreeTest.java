import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {
	
	BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();

	@Test
	public void testSize(){
		tree.put(3, "Zeus");
		assertEquals(1,tree.size());
		tree.put(2, "Athena");
		tree.put(6, "Ares");
		assertEquals(3,tree.size());
	}
	
	@Test
	public void testPut(){
		assertEquals("Athena",tree.put(2, "Athena"));
		assertEquals("Ares",tree.put(3, "Ares"));
	}
	
	
	
}
