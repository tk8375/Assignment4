package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Assign4Driver
{
	public static List<String> ladderSolution = new ArrayList<String>();
    public static void main(String[] args)
    {
        // Create a word ladder solver object
    	
        Assignment4Interface wordLadderSolver = new WordLadderSolver();
        
        Dictionary Glossary = new Dictionary(args);                       // initialize dictionary

		 try 
	        {
	         	// read input from text file line by line
	 			FileReader freader = new FileReader(args[1]);
	 			BufferedReader reader = new BufferedReader(freader);
	 			
	 			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
	 				try{
	 					int start = 0;
	 					while(start < s.length() && s.charAt(start)==' '){
	 						start++;
	 					}
	 					s=s.toLowerCase();
						s=s.substring(start);
						String spaceSeparator = "[ ]+";
						String[] wordPair = s.split(spaceSeparator);                                          // place a pair of words from user in wordPair
					
						//any of the two words is not in dictionary
						if( !Dictionary.checkValid(wordPair[0]) || !Dictionary.checkValid(wordPair[1]) )
						{
							
							System.out.println("At least one of the words :" + wordPair[0] + " and " + wordPair[1] + " are not found in the dictionary");
							continue;
						}
						
						
						//Both words are in dictionary and ladder exists between them
						
						ladderSolution = wordLadderSolver.computeLadder(wordPair[0], wordPair[1]);
						if(wordLadderSolver.validateResult(wordPair[0], wordPair[1],ladderSolution ))
						{
							if(ladderSolution.isEmpty() || ladderSolution == null){
								System.out.println("There is no word ladder between " + wordPair[0] + " and " + wordPair[1] + "!");
							}
							else{
								System.out.println("For the words: " + wordPair[0] + " and " + wordPair[1]+ ", this word ladder was found:");
								Iterator<String> i = ladderSolution.iterator();
						    	while(i.hasNext()){
					    		System.out.println(i.next());
						    	}
							}

						}
						
						//Both words are in dictionary, but no ladder exists between them
						else{
							System.out.println("There is no word ladder between words: " + wordPair[0] + " and " + wordPair[1] + "!");
						}
						
						//System.out.println("");
						System.out.println("**********");
						//clear solution and start over with new pair of words
						
						//ladderSolution = new ArrayList<String>();              // moving on to next line, need to clear ladder of List
																			   // of previous set of words
					}
	 				 catch (ArrayIndexOutOfBoundsException e){
	 					continue;
	 				 }
				}
				
				// close readers
				reader.close();
				
				freader.close();
	        } 
	        
	        catch (FileNotFoundException e) 
			{
				System.out.println ("Error: File not found. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			} 
	        catch (IOException e) 
			{
				System.out.println ("Error: IO exception. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			}
		 	catch (NoSuchLadderException e) 
	        {
	            e.printStackTrace();
	        }

		 
       /* try 
        {
            List<String> result = wordLadderSolver.computeLadder("booty", "money");
            boolean correct = wordLadderSolver.validateResult("stone", "money", result);
        } 
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
        
        */
    }
    
    
}
