package Assignment5;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Test;

public class MorseCodeConverterTestStudent {

	@Test
	public void testConvertToEnglishString() {
		String converter1 = MorseCodeConverter.convertToEnglish("- .... . -.- / .. ... / - . ... .. -. --.");
		assertEquals("thek is tesing", converter1);
	}

	/**
	 * Testing for correct implementation of tree and traversal
	 */

	@Test
	public void testPrintTree() {
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}

	/**
	 * Testing for correct conversion of all characters using key phrase to hit all
	 * letters
	 */
	@Test
	public void testConvertMorseStringToEnglishString() {

		String c2 = MorseCodeConverter.convertToEnglish(
				"... .-.. . . .--. .. -. --. / .. ... / .... . .- .-.. - .... -.-- / .- -. -.. / .. / -. . . -.. / -- --- .-. . / ... .-.. . . .--. ...");
		assertEquals("sleeping is healthy and i need more sleeps", c2);

	}

	@Test
	public void testConvertMorseFileToEnglishString() {

		/*
		 * Make sure howDoILoveThee.txt is in the src directory for this test to pass
		 */
		File file = new File("src/ThekTest.txt");
		try {
			assertEquals("this is just an ordinary test file for testing", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

}