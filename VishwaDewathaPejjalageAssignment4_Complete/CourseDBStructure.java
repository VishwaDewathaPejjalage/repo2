package Assignment4;

import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * @author Vishwa Dewatha Pejjalage
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	ArrayList<LinkedList<CourseDBElement>> hashTable;

	/**
	 * Constructs an array of linkedLists of given size to create a hashTable
	 * 
	 * @param size the size of the constructed data structure
	 */
	public CourseDBStructure(int n) {

		int str = (int) (n / 1.5) + 1;

		int num = str + (3 - (str % 4));

		boolean primenum = false;
		while (!primenum) {

			primenum = true;
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					primenum = false;
					break;
				}
			}
			if (!primenum)
				num += 4;
		}

		hashTable = new ArrayList<LinkedList<CourseDBElement>>();
		for (int i = 0; i < num; i++) {
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}

	/**
	 * Constructs an array of linkedLists of given size to create a hashTable
	 * Specifically for testing only
	 * 
	 * @param testing specifies that this data structure is created only for testing
	 * @param size    the size of the constructed data structure
	 */
	public CourseDBStructure(String Testing, int size) {

		hashTable = new ArrayList<LinkedList<CourseDBElement>>();
		for (int i = 0; i < size; i++) {
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}

	/**
	 * Adds an element to the hashTable based on its hashCode index
	 * 
	 * @param element the element to be added
	 */
	@Override
	public void add(CourseDBElement element) {

		LinkedList<CourseDBElement> data;
		for (int i = 0; i < hashTable.size(); i++) {
			data = hashTable.get(i);
			for (int j = 0; j < data.size(); j++) {
				if (data.get(j).getCRN() == element.getCRN()) {
					data.set(j, element);
					return;
				}
			}
		}

		int index = element.hashCode() % hashTable.size();
		hashTable.get(index).add(element);
	}

	/**
	 * Returns the database element based on the given CRN course code
	 * 
	 * @param crn the CRN course code to be returned
	 * @return the course from the database based on the CRN
	 * @throws IOException thrown if requested course code is not part of database
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		LinkedList<CourseDBElement> data;
		for (int i = 0; i < hashTable.size(); i++) {
			data = hashTable.get(i);
			for (int j = 0; j < data.size(); j++) {
				if (data.get(j).getCRN() == crn)
					return data.get(j);
			}
		}
		throw new IOException();
	}

	/**
	 * Collects all elements in hash table and returns as ArrayList
	 * 
	 * @return ArrayList<String> containing all hash table elements
	 */
	@Override
	public ArrayList<String> showAll() {

		ArrayList<String> struc = new ArrayList<String>();
		LinkedList<CourseDBElement> data;
		CourseDBElement e;

		for (int i = 0; i < hashTable.size(); i++) {
			data = hashTable.get(i);
			for (int j = 0; j < data.size(); j++) {
				e = data.get(j);
				if (e != null) {
					struc.add("\nCourse:" + e.getID() + " CRN:" + e.getCRN() + " Credits:" + e.getCredits()
							+ " Instructor:" + e.getInstructorName() + " Room:" + e.getRoomNum());
				}
			}
		}
		return struc;
	}

	/**
	 * Returns the number of indexes in the data structure
	 * 
	 * @return the length of the array of linkedLists
	 */
	@Override
	public int getTableSize() {
		return hashTable.size();
	}
}