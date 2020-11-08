
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
		Node<K> tempNode = this.head;
		while(!tempNode.getValue().equals(node.getValue())) {
			tempNode = tempNode.getNext();
		}
		newNode.setNext(tempNode.getNext());
		tempNode.setNext(newNode);
	}
	
	public K pop() {
		Node<K> tempNode = this.head;
		if(tempNode.equals(tail)) {
			this.tail = null;
			this.head = null;
			return tempNode.getValue();
		}
		this.head = head.getNext();
		return tempNode.getValue();
	}

	public K popLast() {
		Node<K> tempNode = this.head;
		Node<K> removedNode = this.tail;
		if(tempNode.equals(tail)) {
			this.tail = null;
			this.head = null;
			return removedNode.getValue();
		}
		while(tempNode.getNext() != this.tail)
		{
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(null);
		this.tail = tempNode;
		return removedNode.getValue();
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
