/**
 * AllInv
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store all objects
 */

//Importing ArrayList
import java.util.ArrayList;

public class AllInv {
	ArrayList<Object> allInv = new ArrayList<Object>();// Initializing list
	
	//Constructor
	AllInv() {
	}// end of constructor
	
	/**
	 * add
	 * Method that adds object to list
	 * Returns nothing
	 * @param o - Object to be added
	 * @return void
	 */
	void add(Object o) {
		allInv.add(o);
	}// end of add
	
	/**
	 * get
	 * Method that returns an object in list
	 * Returns object
	 * @param index - Integer used for locating object
	 * @return Object
	 */
	Object get(int index) {
		return allInv.get(index);
	}// end of get
	
	/**
	 * set
	 * Method that sets object at index
	 * Returns nothing
	 * @param index - Integer to set object at
	 * @param o - Object to be set
	 * @return void
	 */
	void set(int index, Object o) {
		allInv.set(index, o);
	}
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return void
	 */
	int getSize() {
		return allInv.size();
	}// end of getSize
	
	/**
	 * remove
	 * Method that removes object from list
	 * Returns nothing
	 * @param o - Object to be removed
	 * @return void
	 */
	void remove(Object o) {
		allInv.remove(o);
	}// end of remove
	
	/**
	 * sortAlpha
	 * Method that sorts contents of list in alphabetical order
	 * Returns nothing
	 * @param nothing
	 * @return void
	 */
	void sortAlpha() {
		for (int i = 1; i < allInv.size(); i++) {
			int index = i-1;
			Object item = allInv.get(i);
			
			//Comparing strings and swapping items
			while ((index >= 0 && (allInv.get(index).getName().compareTo(item.getName()) > 0))) {
				if (allInv.get(index).getNumber().length() == item.getNumber().length()) {
					allInv.set(index+1, allInv.get(index));
					index--;
				}// end of if
				
				else {
					index--;
				}// end of else
			}// end of while
			allInv.set(index+1, item);
		}// end of i for
	}// end of sortAlpha
	
	/**
	 * sortDDate
	 * Method that sorts contents of list by due date
	 * Returns nothing
	 * @param nothing
	 * @return void
	 */
	void sortDDate() {
		for (int i = 1; i < allInv.size(); i++) {
			int index = i-1;
			int item = allInv.get(i).getOverdueDays();
			
			//Comparing ints and swapping items
			while ((index >= 0 && (allInv.get(index).getOverdueDays() < item))) {
				allInv.set(index+1, allInv.get(index));
				index--;
			}// end of while
			allInv.set(index+1, allInv.get(i));
		}// end of i for
	}// end of sortDDate
}// end of class
