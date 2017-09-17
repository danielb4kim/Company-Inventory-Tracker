/**
 * InstrumentNames
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store instruments available for sign-out
 */

//Importing ArrayList
import java.util.ArrayList;

public class InstrumentNames {
	ArrayList<Instrument> instrumentNames = new ArrayList<Instrument>();// Initializing list

	//Constructor
	InstrumentNames() {
	}// end of constructor
	
	/**
	 * add
	 * Method that adds instrument to list
	 * Returns nothing
	 * @param i - Instrument to be added
	 * @return void
	 */
	void add(Instrument i) {
		instrumentNames.add(i);
	}// end of add
	
	/**
	 * getName
	 * Method that returns the name and number of an instrument
	 * Returns instrument's name + number
	 * @param index - Integer used for locating instrument
	 * @return String containing instrument name + number
	 */
	String getName(int index) {
		return instrumentNames.get(index).getName() + " " + instrumentNames.get(index).getNumber();
	}// end of getName
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return Integer of list size
	 */
	int getSize() {
		return instrumentNames.size();
	}// end of getSize
	
	/**
	 * sort
	 * Method that sorts contents of list in alphabetical order
	 * Returns nothing
	 * @param none
	 * @return void
	 */
	void sort() {
		for (int i = 1; i < instrumentNames.size(); i++) {
			int index = i-1;
			Instrument item = instrumentNames.get(i);
			
			//Comparing strings and swapping items
			while ((index >= 0 && (instrumentNames.get(index).getName() + " " + instrumentNames.get(index).getNumber()).compareTo(item.getName() + " " + item.getNumber()) > 0) && (instrumentNames.get(index).getNumber().length() == item.getNumber().length())) {
				instrumentNames.set(index+1, instrumentNames.get(index));
				index--;
			}// end of while
			instrumentNames.set(index+1, item);
		}// end of i for
	}// end of sort
	
	/**
	 * remove
	 * Method that removes instrument from list
	 * Returns nothing
	 * @param i - Instrument to be removed
	 * @return void
	 */
	void remove(Instrument i) {
		instrumentNames.remove(i);
	}// end of remove
}// end of class
