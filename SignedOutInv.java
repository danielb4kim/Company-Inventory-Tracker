/**
 * SignedOutInv
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store signed out items
 */

//Importing ArrayList
import java.util.ArrayList;

public class SignedOutInv {
	ArrayList<Object> signOutNames = new ArrayList<Object>();// Initializing list
	
	//Constructor
	SignedOutInv() {
	}// end of constructor
	
	/**
	 * add
	 * Method that adds object to list
	 * Returns nothing
	 * @param o - Object to be added
	 * @return void
	 */
	void add(Object o) {
		signOutNames.add(o);
	}// end of add
	
	/**
	 * remove
	 * Method that removes object from list
	 * Returns nothing
	 * @param o - Object to be removed
	 * @return void
	 */
	void remove (Object o) {
		signOutNames.remove(o);
	}// end of remove
	
	/**
	 * get
	 * Method that returns an object in list
	 * Returns object
	 * @param index - Integer used for locating object
	 * @return Object
	 */
	Object get(int index) {
		return signOutNames.get(index);
	}// end of get
	
	/**
	 * getName
	 * Method that gets object's name and number
	 * Returns object's name + number
	 * @param index - Integer used for locating object
	 * @return String object name + number
	 */
	String getName(int index) {
		return signOutNames.get(index).getName() + " " + signOutNames.get(index).getNumber();
	}// end of getName
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return void
	 */
	int getSize() {
		return signOutNames.size();
	}// end of getSize
	
	/**
	 * sort
	 * Method that sorts contents of list in alphabetical order
	 * Returns nothing
	 * @param none
	 * @return void
	 */
	void sort() {
		for (int i = 1; i < signOutNames.size(); i++) {
			int index = i-1;
			Object item = signOutNames.get(i);
			
			while (index >= 0 && signOutNames.get(index).getName().compareTo(item.getName()) > 0) {
				signOutNames.set(index+1, signOutNames.get(index));
				index--;
			}// end of while
			signOutNames.set(index+1, item);
		}// end of i for
	}// end of sort
}// end of class
