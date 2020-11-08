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
	
	@Test
	public void givenThreeNumbers_WhenAddedToLinkedList_ShouldBeAddedToTop() {
		Node<Integer> firstNode = new Node<Integer>(70);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(56);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.add(secondNode);
		linkedList.add(thirdNode);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(thirdNode) &&
						 linkedList.head.getNext().equals(secondNode) &&
						 linkedList.tail.equals(firstNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenThreeNumbers_WhenAppendToLinkedList_ShouldBeAddedToLast() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) &&
						 linkedList.head.getNext().equals(secondNode) &&
						 linkedList.tail.equals(thirdNode);
		Assert.assertTrue(result);
	}

	@Test
	public void givenNumber_WhenInsertedBetweenTwoNumberInLinkedList_ShouldBeInsertedInBetween() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(70);
		Node<Integer> insertedNode = new Node<Integer>(30);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.printNodes();
		linkedList.insert(firstNode, insertedNode);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) &&
				 linkedList.head.getNext().equals(insertedNode) &&
				 linkedList.tail.equals(secondNode);
		Assert.assertTrue(result);
	}

	@Test
	public void whenPopOperationInLinkedList_ShouldRemoveElementFromFirst() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		int removedElement = linkedList.pop().getValue();
		System.out.println("Removed Element: " + removedElement);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(secondNode) && 
				linkedList.tail.equals(thirdNode);
		Assert.assertTrue(result);
	}

	@Test
	public void whenPopLastOperationInLinkedList_ShouldRemoveElementFromLast() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		int removedElement = linkedList.popLast().getValue();
		System.out.println("Removed Element: " + removedElement);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) && 
				linkedList.tail.equals(secondNode);
		Assert.assertTrue(result);
	}

	@Test
	public void whenSearchValue_IsPresentInLinkedList_ShouldReturnTrue() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		Node<Integer> searchNode = linkedList.search(70);
		Assert.assertEquals(thirdNode, searchNode);
	}
	
	@Test
	public void whenSearchValue_IsNotPresentInLinkedList_ShouldReturnFalse() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		Node<Integer> searchNode = linkedList.search(90);
		Assert.assertEquals(null, searchNode);
	}
}
