/**
 * SimpleLinkedList
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a single linked list
 * @param <T> - Objects
 */
public class SimpleLinkedList<T> {
	private SimpleNode<T> head;
	
	//Constructor
	SimpleLinkedList() {
		head = null;
	}// end of constructor
	
	/**
	 * add
	 * Method that adds item to list
	 * Returns nothing
	 * @param item - Object to be added
	 * @return void
	 */
	void add(T item) {
		SimpleNode<T> tempNode = head;
		
		if (head == null) {
			head = new SimpleNode<T>(null, item);
		}// end of if
		
		while (tempNode.getNext() != null) {
			tempNode = tempNode.getNext();
		}// end of while
		
		tempNode.setNext(new SimpleNode<T>(null, item));
	}// end of add
	
	/**
	 * get
	 * Method that gets an object from list
	 * Returns object
	 * @param index - Integer used to find object
	 * @return Object at index
	 */
	T get(int index) {
		SimpleNode<T> tempNode = head;
		int counter = 0;
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}// end of if
		
		while (tempNode.getNext() != null) {
			tempNode = tempNode.getNext();
			counter++;
			
			if (counter == index) {
				return tempNode.getItem();
			}// end of if
		}// end of while
		
		return null;
	}// end of get
	
	/**
	 * remove
	 * Method that removes an object from list
	 * Returns object
	 * @param index - Integer used to find object
	 * @return Object
	 */
	T remove(int index) {
		SimpleNode<T> tempNode = head;
		int counter = 0;
		
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}// end of if
		
		while (tempNode.getNext() != null) {
			tempNode = tempNode.getNext();
			counter++;
			
			if (counter == index) {
				SimpleNode<T> tempNodeReturn = tempNode;
				tempNode = null;
				return tempNodeReturn.getItem();
			}// end of if
		}// end of while
		return null;
	}// end of remove
	
	/**
	 * size
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing 
	 * @return Integer of list size
	 */
	int size() {
		SimpleNode<T> tempNode = head;
		int counter = 0;
		
		while (tempNode.getNext() != null) {
			tempNode = tempNode.getNext();
			counter++;
		}// end of while
		return counter;
	}// end of size
}// end of class
