/**
 * SheetMusicList
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates a list to store all Sheet Music
 */

//Importing ArrayLists
import java.util.ArrayList;

public class SheetMusicList {
	ArrayList<SheetMusic> sheetMusicList = new ArrayList<SheetMusic>();// Initializing list
	
	//Constructor
	SheetMusicList() {
	}// end of constructor
	
	/**
	 * addSheetMusic
	 * Method that adds sheet music to list
	 * Returns nothing
	 * @param s - Sheet Music to be added
	 * @return void
	 */
	void addSheetMusic(SheetMusic s) {
		sheetMusicList.add(s);
	}// end of addSheetMusic
	
	/**
	 * removeSheetMusic
	 * Method that removes sheet music from list
	 * Returns nothing
	 * @param s - Sheet music to be removed
	 * @return void
	 */
	void removeSheetMusic(SheetMusic s) {
		sheetMusicList.remove(s);
	}// end of removeSheetMusic
	
	/**
	 * returned
	 * Method that sets status of sheet music as returned
	 * Returns nothing
	 * @param s - Sheet Music to be returned
	 * @return void
	 */
	void returned(SheetMusic s) {
		s.setStatus("Available");
	}// end of returned
	
	/**
	 * signOut
	 * Method that sets status of sheet music as signed out
	 * Returns nothing
	 * @param s - Sheet Music to be signed out
	 * @return void
	 */
	void signOut(SheetMusic s) {
		s.setStatus("Signed out");
		s.setOverdueDays(-1);
	}// end of signOut
	
	/**
	 * setLastStudent
	 * Method that sets name of student who last signed it out to sheet music
	 * Returns nothing
	 * @param s - Sheet music in question
	 * @param lastStudent - String name of student who signed out object
	 */
	void setLastStudent(SheetMusic s, String lastStudent) {
		s.setLastStudent(lastStudent);
	}// end of setLastStudent
	
	/**
	 * repair
	 * Method that sets status of sheet music as repaired
	 * Returns nothing
	 * @param s - Sheet Music to be repaired
	 * @return void
	 */
	void repair(SheetMusic s) {
		s.setCondition("Available");
	}// end of repair
	
	/**
	 * getSize
	 * Method that returns size of list
	 * Returns list size
	 * @param nothing
	 * @return Integer of list size
	 */
	int getSize() {
		return sheetMusicList.size();
	}// end of getSize
	
	/**
	 * get
	 * Method that gets sheet music based on its name
	 * Returns sheet music with same name
	 * @param name - String to find sheet music with
	 * @return Sheet Music with same name
	 */
	SheetMusic get(String name) {
		for (int s = 0; s < sheetMusicList.size(); s++) {
		String newName = sheetMusicList.get(s).getName() + " " + sheetMusicList.get(s).getNumber();
			if (newName.equals(name)) {
				return sheetMusicList.get(s);
			}// end of if
		}// end of s for
		return null;
	}// end of get
}// end of class
