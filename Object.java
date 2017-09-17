/**
 * Object
 * The Best Version
 * @author Daniel Kim
 * May 15 2017
 * Class that creates objects
 */
public class Object {
	//Initializing/Declaring variables
	private String name;
	private String number;
	private String desc1;
	private String desc2;
	private String condition;
	private String status = "Available";
	private int overdueDays = -10;
	private int repairingDays = -1;
	private String dueDate;
	private String lastStudent;
	
	/**
	 * getName
	 * Method that gets object's name
	 * Returns object's name
	 * @param nothing
	 * @return String object name
	 */
	public String getName() {
		return name;
	}// end of getName
	
	/**
	 * setName
	 * Method that sets object's name
	 * Returns nothing
	 * @param name - String name to be set
	 * @return void
	 */
	public void setName(String name) {
		this.name = name;
	}// end of setName
	
	/**
	 * getNumber
	 * Method that gets object's number
	 * Returns object's number
	 * @param nothing
	 * @return String object number
	 */
	public String getNumber() {
		return number;
	}// end of getNumber
	
	/**
	 * setNumber
	 * Method that sets object's number
	 * Returns nothing
	 * @param number - String number to be set
	 * @return void
	 */
	public void setNumber(String number) {
		this.number = number;
	}// end of setNumber
	
	/**
	 * getCondition
	 * Method that gets object's condition
	 * Returns object's condition
	 * @param nothing
	 * @return String object condition
	 */
	public String getCondition() {
		return condition;
	}// end of getCondition

	/**
	 * setCondition
	 * Method that sets object's condition
	 * Returns nothing
	 * @param condition - String condition to be set
	 * @return void
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}// end of setCondition
	
	/**
	 * getDueDate
	 * Method that gets due date of signed out object
	 * Returns object's due date
	 * @param nothing
	 * @return String object's due date
	 */
	public String getDueDate() {
		return dueDate;
	}// end of getDueDate
	
	/**
	 * setDueDate
	 * Method that sets due date of signed out object
	 * Returns nothing
	 * @param dueDate - String date to be set
	 * @return void
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}// end of setDueDate
	
	/**
	 * getDesc1
	 * Method that gets description 1 of object
	 * Returns object's description 1
	 * @param nothing
	 * @return String description 1
	 */
	public String getDesc1() {
		return desc1;
	}// end of getDesc1
	
	/**
	 * setDesc1
	 * Method that sets description 1 of object
	 * Returns nothing
	 * @param desc1 - String description to be set
	 * @return void
	 */
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}// end of setDesc1
	
	/**
	 * getDesc2
	 * Method that gets description 2 of object
	 * Returns object's description 2
	 * @param nothing
	 * @return String description 2
	 */
	public String getDesc2() {
		return desc2;
	}// end of getDesc2
	
	/**
	 * setDesc2
	 * Method that sets description 2 of object
	 * Returns nothing
	 * @param desc2 - String description to be set
	 * @return void
	 */
	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}// end of setDesc2

	/**
	 * getStatus
	 * Method that gets status of object
	 * Returns object's status
	 * @param nothing
	 * @return String object's status
	 */
	public String getStatus() {
		return status;
	}// end of getStatus
	
	/**
	 * setStatus
	 * Method that sets status of object
	 * Returns nothing
	 * @param status - String status to be set
	 * @return void
	 */
	public void setStatus(String status) {
		this.status = status;
	}// end of setStatus
	
	/**
	 * getLastStudent
	 * Method that gets name of student who last signed out object
	 * Returns student's name
	 * @param nothing
	 * @return String student name
	 */
	public String getLastStudent() {
		return lastStudent;
	}// end of getLastStudent
	
	/**
	 * setLastStudent
	 * Method that sets name of student who last signed out object
	 * Returns nothing
	 * @param lastStudent - String student name to be set
	 * @return void
	 */
	public void setLastStudent(String lastStudent) {
		this.lastStudent = lastStudent;
	}// end of setLastStudent
	
	/**
	 * getOverdueDays
	 * Method that returns number of days an object is overdue
	 * Returns number of days overdue
	 * @param nothing
	 * @return Integer number of days overdue
	 */
	public int getOverdueDays() {
		return overdueDays;
	}// end of getOverdueDays
	
	/**
	 * setOverdueDays
	 * Method that sets number of days an object is overdue
	 * Returns nothing
	 * @param overdueDays - Integer days to be set
	 * @return void
	 */
	public void setOverdueDays(int overdueDays) {
		this.overdueDays = overdueDays;
	}// end of setOverdueDays
	
	/**
	 * getRepairingDays
	 * Method that returns number of days object needs to repair
	 * Returns number of days needed for repair
	 * @param nothing
	 * @return Integer number of days needed for repair
	 */
	public int getRepairingDays() {
		return repairingDays;
	}// end of getRepairingDays
	
	/**
	 * setRepairingDays
	 * Method that sets number of days object needs to repair
	 * Returns nothing
	 * @param repairingDays - Integer days to be set
	 * @return void
	 */
	public void setRepairingDays(int repairingDays) {
		this.repairingDays = repairingDays;
	}// end of setRepairingDays
	
	/**
	 * getFullName
	 * Method that gets object's name + number
	 * Returns object's name + number
	 * @param nothing
	 * @return object's name + number
	 */
	public String getFullName() {
		return this.getName() + " " + this.getNumber();
	}// end of getFullName

	//Constructor
	Object(String name, String number, String desc1, String desc2, String condition) {
		this.name = name;
		this.number = number;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.condition = condition;
	}// end of constructor
}// end of class
