/*
    ADD YOUR HEADER HERE
 */

package assignment4;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // declare class members here.
	private List<String> wordLadder;
	private ArrayList<String> wordArray;
	private int wordLength = 5;
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there

    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
        // implement this method
    	wordLadder = new ArrayList<String>();
    	wordArray = new ArrayList<String>();
        //throw new UnsupportedOperationException("Not implemented yet!");
    	MakeLadder(startWord, endWord, 0, 0);
    	Iterator<String> i =wordLadder.iterator();
    	while(i.hasNext()){
    		System.out.println(i.next());
    	}
    	return wordLadder;
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    // add additional methods here
    
    private boolean MakeLadder (String startWord, String endWord, int positionChanged, int initialPosition){
    	wordLadder.add(startWord);
    	wordArray.add(startWord);
    	System.out.println(startWord);
    	if(startWord.equals(endWord)){return true;}
    	StringBuilder word = new StringBuilder(startWord);
    	char originalLetter = word.charAt(positionChanged%wordLength);
    	char newLetter = originalLetter;
	    if((positionChanged+1)% wordLength == initialPosition){
	    	boolean flag = true;
	    	while(flag){
	    		while(combinationCheck(word.toString()) || !Dictionary.checkValid(word.toString())){
		    		newLetter = Dictionary.nextLetter(newLetter);
			    	word = word.deleteCharAt(positionChanged%wordLength);
			    	word = word.insert(positionChanged%wordLength, newLetter);
			    	if(originalLetter == newLetter){
			    		return false;
			    	}
	    		}
	    		wordArray.add(word.toString());
	    		if(word.toString().equals(endWord)){
	    			wordLadder.add(word.toString());
	    			return true;
	    		}

	    	}
    		return false;
    	}
	    boolean flag = true;
		while(flag){
			while(combinationCheck(word.toString()) || !Dictionary.checkValid(word.toString())){
				newLetter = Dictionary.nextLetter(newLetter);
				word = word.deleteCharAt(positionChanged%wordLength);
				word = word.insert(positionChanged%wordLength, newLetter);
				if(newLetter == originalLetter){
			    	if(!MakeLadder(word.toString(),endWord,positionChanged + 1, (initialPosition + 1)% (wordLength+1))){
			    		wordLadder.remove(word.toString());
			    		return false;
			    	}
			    	else{return true;}
				}
			}
	    	if(!MakeLadder(word.toString(),endWord,positionChanged + 1, initialPosition)){
	    		wordLadder.remove(word.toString());
	    	}
	    	else{return true;}
	    }
		while(!flag){
//			while(combinationCheck(word.toString()) || !Dictionary.checkValid(word.toString())){
//				newLetter = Dictionary.nextLetter(newLetter);
//				if(newLetter == originalLetter){return false;}
//				word = word.deleteCharAt(positionChanged);
//				word = word.insert(positionChanged, newLetter);
//
//			}
	    	if(!MakeLadder(word.toString(),endWord,positionChanged + 1, initialPosition + 1)){
	    		wordLadder.remove(word.toString());
	    		flag = true;
	    	}
	    	else{return true;}
	    }
		return false;
    }
    
    private boolean combinationCheck (String word){
    	Iterator<String> i = wordArray.iterator();
    	while(i.hasNext()){
    		String pastWord = i.next();
    		if(pastWord.equalsIgnoreCase(word)){return true;}
    	}
        return false;
    }

}
