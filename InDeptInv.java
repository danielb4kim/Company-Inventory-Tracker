/**
 * InDeptInv
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store objects the department currently possesses
 */

//Importing ArrayList
import java.util.ArrayList;

public class InDeptInv {
	ArrayList<Object> inDeptInv = new ArrayList<Object>();// Initializing list
	
	//Constructor
	InDeptInv() {
	}// end of constructor
	
	/**
	 * add
	 * Method that adds object to list
	 * Returns nothing
	 * @param o - Object to be added
	 * @return void
	 */
	void add(Object o) {
		inDeptInv.add(o);
	}// end of add
	
	/**
	 * remove
	 * Method that removes object from list
	 * Returns nothing
	 * @param o - Object to be removed
	 * @return void
	 */
	void remove(Object o) {
		inDeptInv.remove(o);
	}// end of remove
	
	/**
	 * get
	 * Method that returns an object in list
	 * Returns object
	 * @param index - Integer used for locating object
	 * @return Object
	 */
	Object get(int index) {
		return inDeptInv.get(index);
	}// end of get
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return void
	 */
	int getSize() {
		return inDeptInv.size();
	}// end of getSize
	
	/**
	 * sort
	 * Method that sorts contents of list in alphabetical order
	 * Returns nothing
	 * @param none
	 * @return void
	 */
	void sort() {
		for (int i = 1; i < inDeptInv.size(); i++) {
			int index = i-1;
			Object item = inDeptInv.get(i);
			
			//Comparing strings and swapping items
			while ((index >= 0 && (inDeptInv.get(index).getName().compareTo(item.getName()) > 0))) {
				if (inDeptInv.get(index).getNumber().length() == item.getNumber().length()) {
					inDeptInv.set(index+1, inDeptInv.get(index));
					index--;
				}// end of if
				
				else {
					index--;
				}// end of else
			}// end of while
			inDeptInv.set(index+1, item);
		}// end of i for
	}// end of sort
}// end of class
