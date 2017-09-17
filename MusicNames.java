/**
 * MusicNames
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store sheet music available for sign-out
 */

//Importing ArrayList
import java.util.ArrayList;

public class MusicNames {
	ArrayList<SheetMusic> musicNames = new ArrayList<SheetMusic>();// Initializing list
	
	//Constructor
	MusicNames() {
	}// end of constructor
	
	/**
	 * add
	 * Method that adds sheet music to list
	 * Returns nothing
	 * @param s - Sheet Music to be added
	 * @return void
	 */
	void add(SheetMusic s) {
		musicNames.add(s);
	}// end of add
	
	/**
	 * getName
	 * Method that returns the name and number of sheet music
	 * Returns sheet music's name + number
	 * @param index - Integer used for locating sheet music
	 * @return String containing sheet music name + number
	 */
	String getName(int index) {
		return musicNames.get(index).getName() + " " + musicNames.get(index).getNumber();
	}// end of getName
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return Integer of list size
	 */
	int getSize() {
		return musicNames.size();
	}// end of getSize
	
	/**
	 * sort
	 * Method that sorts contents of list in alphabetical order
	 * Returns nothing
	 * @param nothing
	 * @return void
	 */
	void sort() {
		for (int i = 1; i < musicNames.size(); i++) {
			int index = i-1;
			SheetMusic item = musicNames.get(i);
			
			//Comparing strings and swapping items
			while ((index >= 0 && (musicNames.get(index).getName() + " " + musicNames.get(index).getNumber()).compareTo(item.getName() + " " + item.getNumber()) > 0) && (musicNames.get(index).getNumber().length() == item.getNumber().length())) {
				musicNames.set(index+1, musicNames.get(index));
				index--;
			}// end of while
			musicNames.set(index+1, item);
		}// end of i for
	}// end of sort
	
	/**
	 * remove
	 * Method that removes sheet music from list
	 * Returns nothing
	 * @param s - Sheet Music to be removed
	 * @return void
	 */
	void remove(SheetMusic s) {
		musicNames.remove(s);
	}// end of remove
}// end of class
