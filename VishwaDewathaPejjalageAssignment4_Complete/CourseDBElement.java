package Assignment4;

/**
 * @author Vishwa Dewatha Pejjalage
 */
public class CourseDBElement implements Comparable<CourseDBElement> {

	private String id, roomNum, instructor;;
	private int crn, credits;

	/**
	 * Parameterized constructor
	 * 
	 * @param id
	 * @param crn
	 * @param credits
	 * @param roomNum
	 * @param instructorName
	 */
	public CourseDBElement(String id, int crn, int credits, String roomNum, String instructorName) {
		this.id = id;
		this.crn = crn;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructor = instructorName;
	}

	public CourseDBElement() {
		this.id = this.roomNum = this.instructor = "null";
		this.crn = this.credits = -1;
	}

	/**
	 * Returns the hashcode of the element
	 * @return the hashcode of the data element
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + crn;
		return result;
	}

	// Getters and Setters
	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	/**
	 * Return the CRN code of the class
	 * 
	 * @return the CRN code
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * sets the CRN code of the class to the given code number
	 * 
	 * @param input the CRN code that the class should be set to
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/**
	 * Return the credits
	 * 
	 * @return credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * sets the credits
	 * 
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getRoomNum() {
		return roomNum;
	}

	/**
	 * sets the roomNum
	 * 
	 * @param roomNum
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getInstructorName() {
		return instructor;
	}

	public void setInstructorName(String instructorName) {
		this.instructor = instructorName;
	}

	/**
	 * Compares two course database elements and returns an int
	 * 
	 * @param element the element to be compared with
	 * @return an integer representing the comparison
	 */

	@Override
	public int compareTo(CourseDBElement o) {
		if (this.crn < o.getCRN())
			return -1;
		else if (this.crn > o.getCRN())
			return 1;
		else
			return 0;
	}
}
