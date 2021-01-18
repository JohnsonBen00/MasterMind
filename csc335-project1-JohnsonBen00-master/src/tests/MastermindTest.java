package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MastermindController;
import model.MastermindModel;

/**
 * This class collects all of the test methods for our controller.
 * 
 * In eclipse, running it should run it under JUnit. Running the Mastermind class (since
 * it is our main class) will actually run the program. If you're not using eclipse,
 * you'll need to run this under JUnit 5. 
 * 
 * @author Benhur J. Tadiparti
 *
 */
class MastermindTest {

	/**
	 * Test method for {@link MastermindController#isCorrect(java.lang.String)}.
	 */
	@Test
	void testIsCorrect() {
		//Build a model with a known answer, using our special testing constructor
		MastermindModel answer = new MastermindModel("rrrr");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return true
		assertTrue(controllerUnderTest.isCorrect("rrrr"));
		//For a properly working controller, this should be false
		assertFalse(controllerUnderTest.isCorrect("oooo"));
		
		//Make as many more assertions as you feel you need to test the MastermindController.isCorrect method
	}

	/**
	 * Test method for {@link MastermindController#getRightColorRightPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorRightPlace() {
		//Build a model with a known answer, using our special testing constructor
		MastermindModel answer = new MastermindModel("rrrr");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrrr"), 4);
		
		//For a properly working controller, this should return 3
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrro"), 3);
		
		//For a properly working controller, this should return 2
		assertEquals(controllerUnderTest.getRightColorRightPlace("rroo"), 2);
		
		//For a properly working controller, this should return 1
		assertEquals(controllerUnderTest.getRightColorRightPlace("rooo"), 1);
		
		//For a properly working controller, this should return 0
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo"), 0);
		
	}

	/**
	 * Test method for {@link MastermindController#getRightColorWrongPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorWrongPlace() {
		//Build a model with a known answer, using our special testing constructor
		MastermindModel answer = new MastermindModel("roor");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorWrongPlace("orro"), 4);
		
		//For a properly working controller, this should return 3
		assertEquals(controllerUnderTest.getRightColorWrongPlace("orgo"), 3);
		
		//For a properly working controller, this should return 2
		assertEquals(controllerUnderTest.getRightColorWrongPlace("rrro"), 2);
		
		//For a properly working controller, this should return 1
		assertEquals(controllerUnderTest.getRightColorWrongPlace("grgg"), 1);
		
		//For a properly working controller, this should return 0
		assertEquals(controllerUnderTest.getRightColorWrongPlace("ooor"), 0);
	}

}
