package Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Vishwa Dewatha Pejjalage
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure structure;

	/**
	 * No-Arg constructor
	 */
	public CourseDBManager() {
		structure = new CourseDBStructure(20);
	}

	/**
	 * Adds element to structure
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		structure.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	/**
	 * Returns the course from the database according to the given CRN code
	 * 
	 * @param crn the CRN code of the course to be returned
	 * @return the class specified by the parameter
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return structure.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Reads an input file of courses and adds them to the database
	 * 
	 * @param input the text file of courses to be added
	 * @throws FileNotFoundException thrown if input file does not exist
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {

		Scanner fileIn = new Scanner(input);
		String line;
		String[] data;
		CourseDBElement e;
		String name;

		while (fileIn.hasNextLine()) {

			name = "";

			line = fileIn.nextLine();

			data = line.split(" ");

			e = new CourseDBElement(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], null);

			for (int i = 4; i < data.length; i++) {
				name += data[i] + " ";
			}
			e.setInstructorName(name.trim()); // .trim() to cut trailing whitespace

			structure.add(e);
		}
	}

	/**
	 * Displays all the courses in the database
	 * 
	 * @return the courses in an ArrayList of Strings
	 */
	@Override
	public ArrayList<String> showAll() {
		return structure.showAll();
	}
}