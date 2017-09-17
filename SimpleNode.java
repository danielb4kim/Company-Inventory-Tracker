/**
 * SimpleNode
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a simple node
 * @param <T> - Objects
 */
public class SimpleNode<T> {
	//Variable declaration
	private T item;
	private SimpleNode<T> next;
	
	//Constructor
	public SimpleNode (T item) {
		this.next = null;
	}// end of constructor
	
	//Constructor
	public SimpleNode (SimpleNode<T> next, T item) {
		this.item = item;
		this.next = next;
	}// end of constructor
	
	/**
	 * getNext
	 * Method that gets next
	 * Returns next in node
	 * @param nothing
	 * @return SimpleNode next
	 */
	public SimpleNode<T> getNext() {
		return next;
	}// end of getNext
	
	/**
	 * setNext
	 * Method that sets next
	 * Returns nothing
	 * @param next - Node to be set
	 * @return void
	 */
	public void setNext(SimpleNode<T> next) {
		this.next = next;
	}// end of setNext
	
	/**
	 * getItem
	 * Method that gets an item
	 * Returns item
	 * @param nothing
	 * @return Object item
	 */
	public T getItem() {
		return item;
	}// end of getItem
	
	/**
	 * setItem
	 * Method that sets an item
	 * Returns nothing
	 * @param item - Item to be set
	 * @return void
	 */
	public void setItem(T item) {
		this.item = item;
	}// end of setItem
}// end of class
