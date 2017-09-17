/**
 * InstrumentList
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store all instruments
 */

//Importing ArrayList
import java.util.ArrayList;

public class InstrumentList {
	ArrayList<Instrument> instrumentList = new ArrayList<Instrument>();// Initializing list
	
	//Constructor
	InstrumentList() {
	}// end of constructor
	
	/**
	 * addInstrument
	 * Method that adds instrument to list
	 * Returns nothing
	 * @param i - Instrument to be added
	 * @return void
	 */
	void addInstrument(Instrument i) {
		instrumentList.add(i);
	}// end of addInstrument
	
	/**
	 * removeInstrument
	 * Method that removes instrument from list
	 * Returns nothing
	 * @param i - Instrument to be removed
	 * @return void
	 */
	void removeInstrument(Instrument i) {
		instrumentList.remove(i);
	}// end of removeInstrument
	
	/**
	 * returned
	 * Method that sets status of instrument as returned
	 * Returns nothing
	 * @param i - Instrument to be returned
	 * @return void
	 */
	void returned(Instrument i) {
		i.setStatus("Available");
	}// end of returned
	
	/**
	 * signOut
	 * Method that sets status of instrument as signed out
	 * Returns nothing
	 * @param i - Instrument to be signed out
	 * @return void
	 */
	void signOut(Instrument i) { 
		i.setStatus("Signed out");
		i.setOverdueDays(-1);
	}// end of signOut
	
	/**
	 * setLastStudent
	 * Method that sets name of student who last signed it out to instrument
	 * Returns nothing
	 * @param i - Instrument in question
	 * @param lastStudent - String name of student who signed out object
	 * @return void
	 */
	void setLastStudent(Instrument i, String lastStudent) {
		i.setLastStudent(lastStudent);
	}// end of setLastStudent
	
	/**
	 * repair
	 * Method that sets status of instrument as repairing
	 * Returns nothing
	 * @param i - Instrument to be repaired
	 * @return void
	 */
	void repair(Instrument i) {
		i.setCondition("Repairing");
	}// end of repair
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return Integer of list size
	 */
	int getSize() {
		return instrumentList.size();
	}// end of getSize
	
	/**
	 * get
	 * Method that gets an instrument based on its name
	 * Returns instrument with same name
	 * @param name - String to find instrument with
	 * @return Instrument with same name
	 */
	Instrument get(String name) {
		for (int i = 0; i < instrumentList.size(); i++) {
			String newName = instrumentList.get(i).getName() + " " + instrumentList.get(i).getNumber();
			if (newName.equals(name)) {
				return instrumentList.get(i);
			}// end of if
		}// end of i for
		return null;
	}// end of get
}// end of class
