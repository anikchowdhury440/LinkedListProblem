
public class LinkedList<K> {
	public Node<K> head;
	public Node<K> tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void add(Node<K> newNode) {
		if(this.tail == null) {
			this.tail = newNode;
		}
		if(this.head == null) {
			this.head = newNode;
		}
		else {
			Node<K> tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}
	
	public void append(Node<K> newNode) {
		if(this.tail == null) {
			this.tail = newNode;
		}
		if(this.head == null) {
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
	
	public void printNodes() {
		StringBuffer myNodes = new StringBuffer();
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
