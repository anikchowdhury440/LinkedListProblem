import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
	@Test
	public void givenThreeNumbers_WhenLinked_ShouldPassesLinkedListTest() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		firstNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		boolean result = firstNode.getNext().equals(secondNode) &&
						 firstNode.getNext().getNext().equals(thirdNode);
		Assert.assertTrue(result);
	}
}
