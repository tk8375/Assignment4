package assignment4;

import junit.framework.TestCase;
import java.util.List;
import java.util.Iterator;

public class LadderTest extends TestCase {
	public void test1(){
		Assignment4Interface wordLadderSolver = new WordLadderSolver();
       try {
            List<String> result = wordLadderSolver.computeLadder("HELLO", "Hello");
            boolean correct = wordLadderSolver.validateResult("hello", "hello", result);
            assertEquals(correct, true);
        } 
        catch(NoSuchLadderException e) {
            e.printStackTrace();
        }
	}
	public void test2(){
		Assignment4Interface wordLadderSolver = new WordLadderSolver();
	       try {
	            List<String> result = wordLadderSolver.computeLadder("stone", "money");
	            List<String> result2 = wordLadderSolver.computeLadder("alone", "money");
	            assertEquals(true, result.containsAll(result2));
	        } 
	        catch(NoSuchLadderException e) {
	            e.printStackTrace();
	        }
	}
}
