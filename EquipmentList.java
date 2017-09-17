/**
 * EquipmentList
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store all equipment
 */

//Importing ArrayList
import java.util.ArrayList;

public class EquipmentList {
	ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();// Initializing list
	
	//Constructor
	EquipmentList() {
	}// end of constructor
	
	/**
	 * addEquipment
	 * Method that adds equipment to list
	 * Returns nothing
	 * @param e - Equipment to be added
	 * @return void
	 */
	void addEquipment(Equipment e) {
		equipmentList.add(e);
	}// end of addEquipment
	
	/**
	 * removeEquipment
	 * Method that removes equipment from list
	 * Returns nothing
	 * @param e - Equipment to be removed
	 * @return void
	 */
	void removeEquipment(Equipment e) {
		equipmentList.remove(e);
	}// end of removeEquipment
	
	/**
	 * returned
	 * Method that sets status of equipment as returned
	 * Returns nothing
	 * @param e - Equipment to be removed
	 * @return void
	 */
	void returned(Equipment e) {
		e.setStatus("Available");
	}// end of returned
	
	/**
	 * signOut
	 * Method that sets status of equipment as signed out
	 * Returns nothing
	 * @param e - Equipment to be signed out
	 * @return void
	 */
	void signOut(Equipment e) {
		e.setStatus("Signed out");
		e.setOverdueDays(-1);
	}// end of signOut
	
	/**
	 * setLastStudent
	 * Method that sets name of student who last signed it out to equipment
	 * Returns nothing
	 * @param e - Equipment in question
	 * @param lastStudent - String name of student who signed out object
	 */
	void setLastStudent(Equipment e, String lastStudent) {
		e.setLastStudent(lastStudent);
	}// end of setLastStudent
	
	/**
	 * repair
	 * Method that sets status of equipment as repairing
	 * Returns nothing
	 * @param e - Equipment to be repaired
	 * @return void
	 */
	void repair(Equipment e) {
		e.setCondition("Repairing");
	}// end of repair
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return Integer of list size
	 */
	int getSize() {
		return equipmentList.size();
	}// end of getSize

	/**
	 * get
	 * Method that gets equipment based on its name
	 * Returns equipment with same name
	 * @param name - String to find equipment with
	 * @return Equipment with same name
	 */
	Equipment get(String name) {
		for (int e = 0; e < equipmentList.size(); e++) {
			String newName = equipmentList.get(e).getName() + " " + equipmentList.get(e).getNumber();
			if (newName.equals(name)) {
				return equipmentList.get(e);
			}// end of if
		}// end of e for
		return null;
	}// end of get
}// end of class
