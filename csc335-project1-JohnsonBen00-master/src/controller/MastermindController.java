package controller;
import model.MastermindModel;

/**
 * 
 * @author Benhur J. Tadiparti
 *
 */
public class MastermindController {

	private MastermindModel model;
	
	public MastermindController(MastermindModel model) {
		this.model = model;
	}
	
	//Checks to see if the guess if correct
    public boolean isCorrect(String guess) {
    	char[] ans = guess.toCharArray(); //Converts out string "guess" to a char array
    	for (int i = 0; i < guess.length(); i++) {
    		//Checks to see if our guess and the computer generated answer are different
    		if (model.getColorAt(i) != ans[i]) { 
    			return false;                    
    		}
    	}
    	return true; //Else everything is the same and return true
    }
    
    //Checks to see if the guess at certain indexes are the same
    public int getRightColorRightPlace(String guess) {
    	//Counter variable
    	int correct = 0; //Counts the number of colors that are in the right place
    	char[] ans = guess.toCharArray(); //Converts out string "guess" to a char array
    	for (int i = 0; i < guess.length(); i++) {
    		//Checks to see if our guess[i] and the computer generated answer[i] are the same
    		//Increments our counter variable
    		if (model.getColorAt(i) == ans[i]) {
    			correct++;
    		}
    	}
    	return correct;
    }
    
    //Checks to see if the guess the correct color, but in different places
    public int getRightColorWrongPlace(String guess) {
    	//Counter variable
    	int correct = 0; //Counts the number of colors that are in the wrong place
    	char[] my_guess = guess.toCharArray(); //Converts out string "guess" to a char array
    	int[] rcrp = new int[] {0, 0, 0, 0}; //Right color right place array
    	
    	//Basically the 'Right color right place' function
    	for (int i = 0; i < my_guess.length; i++) {
    		//Checks to see if our guess[i] and the computer generated answer[i] are the same
    		//Changes our guess[i] to something else so we don't have duplicates
    		//Turns on the appropriate rcrp[i] so we don't have duplicates
    		if (model.getColorAt(i) == my_guess[i]) {
				my_guess[i] = '0';
				rcrp[i] = 1;
				}
    	}
    	
    	//Checks the other colors in guess to see if they are in the wrong place 
    	//compared to the computer generated answer
    	for (int j = 0; j < my_guess.length; j++) { // computer generated answer[j]
    		for (int k = 0; k < my_guess.length; k++) { // our guess[k]
    			//Checks to see if our guess[k] and the computer generated answer[j] are the same
    			//while k != j
    			//Increments our counter variable
        		//Changes our guess[i] to something else so we don't have duplicates
    			if ((model.getColorAt(j) == my_guess[k]) && (rcrp[j] != 1)) {
    				correct++;
    				my_guess[k] = '0';
    				break;
	    			}
    		}
    	}
    	return correct;
    }

}
