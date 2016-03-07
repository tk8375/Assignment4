/*
   Taewhan Ko (tk8375)
   Steven Cisneros (snc782)
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
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
	public WordLadderSolver(){
		
	}
    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException 
    {
    	
        // implement this method
    	wordLadder = new ArrayList<String>();
    	wordArray = new ArrayList<String>();
    	
        //throw new UnsupportedOperationException("Not implemented yet!");
		if (Dictionary.checkValid(startWord) && Dictionary.checkValid(endWord)){
			if(NumOfDiff(startWord, endWord) <= 1){
				wordLadder.add(startWord);
				wordLadder.add(endWord);
				return wordLadder;
			}
			
			
			if (MakeLadder(startWord, endWord, -1)){
				sortLadder();
				return wordLadder;
			}
		}
			wordLadder.clear();
			return wordLadder;

//    	Iterator<String> i =wordLadder.iterator();
//    	while(i.hasNext()){
//    		System.out.println(i.next());
//    	}
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) 
    {//check if ladder is not empty
    	if(wordLadder.size()>0 && wordLadder != null){
    		//check ladder has the start and end words as the boundaries
	    	if(!wordLadder.get(0).equals(startWord) || !wordLadder.get(wordLadder.size()-1).equals(endWord)){
	    	
	    	return false;
	    	}
	    	
    	}
    	//check if all the words in the ladder are valid dictionary words
    	for (int i=0; i<wordLadder.size();i++)
    	{
    		if(!Dictionary.checkValid(wordLadder.get(i)))
    		{
    			return false;
    		}
    		
    	}
    	//check all the words in the ladder are different by 1 letters
    	for(int i=0; i<wordLadder.size()-1;i++)
    	{
    		
    		if(i<wordLadder.size())
    		{
    			if (!oneLetter(wordLadder.get(i),wordLadder.get(i+1)))
    			{
    				return false;
    			}
    		}
    	}

    	return true;
        //throw new UnsupportedOperationException("Not implemented yet!");
        
        
        
    }

    // add additional methods here
    
	boolean MakeLadder(String startWord, String endWord, int positionChanged)
	{
		
		if(wordArray.contains(startWord)){
			return false;
		}
		wordLadder.add(startWord);
		wordArray.add(startWord);
		
		// iterate through every character position in the fromWord
		for(int a = 0; a <startWord.length(); a ++){
			
			//check if same position changed
			if(a != positionChanged){
				char letter = Dictionary.nextLetter(startWord.charAt(a));
				
				//check through all combination of letters
				for(int b = 0; b < Dictionary.alphabet.length; b++){
					if(b>0){
						letter = Dictionary.nextLetter(letter);
					}
					
					//make sure the letter didnt loop back around
					if(letter != startWord.charAt(a)){
						StringBuilder word = new StringBuilder(startWord);
						word.setCharAt(a, letter);
						
						//make sure the word is valid and not repeating
						if(Dictionary.checkValid(word.toString())&& !wordArray.contains(word.toString())){
							int diff = NumOfDiff(word.toString(), endWord);
							if (diff == 1){
								wordLadder.add(word.toString());
								wordLadder.add(endWord);
								return true;
							}
							
							//recursion until the answer is reached
							if(!MakeLadder(word.toString(),endWord,a)){
								wordLadder.remove(word.toString());
							}
							else{return true;}
						}
					}
				}
			}
			
		}
		//no ladder created
		wordLadder.remove(startWord);
		return false;
	}
	
	//check if the two words are 1 letter apart for equivalent
	 public static boolean oneLetter(String word1, String word2)
	 {
	    	int wordSize=word1.length();
	    	int diffCount=0;
	    	for(int i=0; i<wordSize; i++)
	    	{
	    		if(word1.charAt(i) != word2.charAt(i))
	    		{
	    			diffCount++;
	    		}
	    	}
	    	if (diffCount <=1)
	    		return true;
	    	else
	    		return false;
	 }
	 //tells how many letters are different between two words
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
	//
	private void sortLadder(){
		for(int i = 0; i<wordLadder.size()-1;i++){
			if(i+2 < wordLadder.size()){
				if(NumOfDiff(wordLadder.get(i),wordLadder.get(i+2)) <= 1){
					wordLadder.remove(i+1);
				}
			}
		}
	}

	

    


}
