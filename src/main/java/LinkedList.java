
public class LinkedList<K> {
	public Node<K> head;
	public Node<K> tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		if(this.tail == null && this.head == null) {
			return true;
		}
		return false;
	}
	
	public void add(Node<K> newNode) {
		if(isEmpty()) {
			this.tail = newNode;
			this.head = newNode;
		}
		else {
			Node<K> tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}
	
	public void append(Node<K> newNode) {
		if(isEmpty()) {
			this.tail = newNode;
			this.head = newNode;
		}
		else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	
	public void insert(Node<K> node, Node<K> newNode) {
		
		Node<K> tempNode = search(node.getValue());
		if(tempNode != null) {
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
		}
		else {
			System.out.println("Node can't inserted");
		}
	}
	
	public Node<K> pop() {
		Node<K> tempNode = this.head;
		if(head.equals(tail)) {
			this.tail = null;
			this.head = null;
			return tempNode;
		}
		this.head = head.getNext();
		return tempNode;
	}

	public Node<K> popLast() {
		Node<K> tempNode = this.head;
		if(head.equals(tail)) {
			this.tail = null;
			this.head = null;
			return tempNode;
		}
		Node<K> removedNode = this.tail;
		while(tempNode.getNext() != this.tail)
		{
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(null);
		this.tail = tempNode;
		return removedNode;
	}
	
	public Node<K> search(K value) {
		Node<K> tempNode = this.head;
		while(tempNode != null && tempNode.getNext() != null) {
			if(tempNode.getValue().equals(value)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		if(tempNode.getValue().equals(value)) {
			return tempNode;
		}
		return null;
	}
	
	public void delete(Node<K> node) {
		
		Node<K> removedNode = search(node.getValue());
		if(removedNode != null) {
			Node<K> tempNode = this.head;
			while(tempNode.getNext() !=  removedNode) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(removedNode.getNext());
			System.out.println("After Deleting Size = " + size());
		}
		else {
			System.out.println("Node can't deleted");
		}
	}

	public int size() {
		int count = 0;
		Node<K> tempNode = this.head;
		if(tempNode == null) {
			return count;
		}
		count++;
		while(tempNode.getNext() != this.tail) {
			tempNode = tempNode.getNext();
			count++;
		}
		tempNode = tempNode.getNext();
		count++;
		return count;
	}
	
	public void printNodes() {
		StringBuffer myNodes = new StringBuffer();
		if(isEmpty()) {
			return;
		}
		Node<K> tempNode = this.head;
		while(tempNode.getNext() != null) {
			myNodes.append(tempNode.getValue());
			if(!tempNode.equals(this.tail)) {
				myNodes.append("->");
			}
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getValue());
		System.out.println(myNodes);
	}
	
}
