/**
 * MusicInputData
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store info from SheetMusic.txt
 */

//Importing ArrayList
import java.util.ArrayList;

public class MusicInputData {
	ArrayList<String> musicInputData = new ArrayList<String>();// Initializing list
	
	//Constructor
	MusicInputData() {
	}// end of constructor
	
	/**
	 * add
	 * Method that adds info to list
	 * Returns nothing
	 * @param s - String info to be added
	 * @return void
	 */
	void add(String s) {
		musicInputData.add(s);
	}// end of add
	
	/**
	 * get
	 * Method that gets info from list
	 * Returns info
	 * @param index - Integer used for locating string
	 * @return String info
	 */
	String get(int index) {
		return musicInputData.get(index);
	}// end of get
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return Integer of list size
	 */
	int getSize() {
		return musicInputData.size();
	}// end of getSize
}// end of class
