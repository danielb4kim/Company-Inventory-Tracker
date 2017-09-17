/**
 * EquipmentNames
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store equipment available for sign-out
 */

//Importing ArrayList
import java.util.ArrayList;

public class EquipmentNames {
	ArrayList<Equipment> equipmentNames = new ArrayList<Equipment>();// Initializing list
	
	//Constructor
	EquipmentNames() {
	}// end of constructor
	
	/**
	 * add
	 * Method that adds equipment to list
	 * Returns nothing
	 * @param e - Equipment to be added
	 * @return void
	 */
	void add(Equipment e) {
		equipmentNames.add(e);
	}// end of add
	
	/**
	 * getName
	 * Method that returns the name and number of equipment
	 * Returns equipment's name + number
	 * @param index - Integer used for locating equipment
	 * @return String containing equipment name + number
	 */
	String getName(int index) {
		return equipmentNames.get(index).getName() + " " + equipmentNames.get(index).getNumber();
	}// end of getName
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return Integer of list size
	 */
	int getSize() {
		return equipmentNames.size();
	}// end of getSize
	
	/**
	 * sort
	 * Method that sorts contents of list in alphabetical order
	 * Returns nothing
	 * @param none
	 * @return void
	 */
	void sort() {
		for (int i = 1; i < equipmentNames.size(); i++) {
			int index = i-1;
			Equipment item = equipmentNames.get(i);
			
			//Comparing strings and swapping items
			while ((index >= 0 && (equipmentNames.get(index).getName() + " " + equipmentNames.get(index).getNumber()).compareTo(item.getName() + " " + item.getNumber()) > 0) && (equipmentNames.get(index).getNumber().length() == item.getNumber().length())) {
				equipmentNames.set(index+1, equipmentNames.get(index));
				index--;
			}// end of while
			equipmentNames.set(index+1, item);
		}// end of i for
	}// end of sort
	
	/**
	 * remove
	 * Method that removes equipment from list
	 * Returns nothing
	 * @param e - Equipment to be removed
	 * @return void
	 */
	void remove(Equipment e) {
		equipmentNames.remove(e);
	}// end of remove
}// end of class
