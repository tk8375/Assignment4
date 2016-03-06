/*
    ADD YOUR HEADER HERE
 */

package assignment4;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface
{
    // declare class members here.
	private List<String> wordLadder;
	private ArrayList<String> wordArray;
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there

    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
        // implement this method
    	wordLadder = new ArrayList<String>();
    	wordArray = new ArrayList<String>();
        //throw new UnsupportedOperationException("Not implemented yet!");
    	MakeLadder(startWord, endWord, -1);
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
    
	boolean MakeLadder(String startWord, String endWord, int positionChanged)
	{
		ArrayList<String> candidateList = new ArrayList<>();
		
		if(wordArray.contains(startWord)){
			return false;
		}
		wordLadder.add(startWord);
		wordArray.add(startWord);
		
		// PART I: Create the list of candidate words
		// iterate through every character position in the fromWord
		for(int a = 0; a <startWord.length(); a ++){
			if(a != positionChanged){
				char letter = Dictionary.nextLetter(startWord.charAt(a));
				for(int b = 0; b < Dictionary.alphabet.length; b++){
					if(b>0){
						letter = Dictionary.nextLetter(letter);
					}
					if(letter != startWord.charAt(a)){
						StringBuilder word = new StringBuilder(startWord);
						word.setCharAt(a, letter);
						if(Dictionary.checkValid(word.toString())&& !wordArray.contains(word.toString())){
							int diff = NumOfDiff(word.toString(), endWord);
							if (diff == 1){
								wordLadder.add(word.toString());
								wordLadder.add(endWord);
								return true;
							}
							word.insert(0, diff);
							word.append(a);
							
							candidateList.add(word.toString());
//							if(!MakeLadder(word.toString(),endWord,a)){
//								wordLadder.remove(word.toString());
//							}
//							else{return true;}
						}
					}
				}
			}
			
		}
		for (String candidateWord : candidateList)
		{
			int candidateChangedPos = Integer.parseInt(candidateWord.substring(candidateWord.length() - 1));
			String nextWord =  candidateWord.substring(1, candidateWord.length() - 1);
			
			if (MakeLadder(nextWord, endWord, candidateChangedPos))
			{
				return true;
			}
		}
		
		wordLadder.remove(startWord);
		return false;
	}

	private int NumOfDiff(String word, String endWord) {
		int diff = 0;
		for (int i = 0; i < word.length(); i++){
			if (word.charAt(i) != endWord.charAt(i))
			{
				diff++;
			}
		}
		
		return diff;
	}

	

    


}
