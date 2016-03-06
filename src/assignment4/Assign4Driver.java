package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Assign4Driver
{
	
	public static ArrayList<String> ladderSolution = new ArrayList<String>();
    public static void main(String[] args)
    {
        // Create a word ladder solver object
    	
        Assignment4Interface wordLadderSolver = new WordLadderSolver();
        
        Dictionary Glossary = new Dictionary(args);
//
//		 try 
//	        {
//	         
//	 			FileReader freader = new FileReader(args[1]);
//	 			BufferedReader reader = new BufferedReader(freader);
//	 			
//	 			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
//				{
//					String[] wordPair = new String[2];
//					wordPair = s.split(" ");
//					
//					//any of the two words is not in dictionary
//					if( !Glossary.checkValid(wordPair[0]) || !Glossary.checkValid(wordPair[1]) )
//					{
//						
//						System.err.println("At least one of the words :" + wordPair[0] + " and " + wordPair[1] + " are not found in the dictionary");
//						
//					}
//					
//					
//					//Both words are in dictionary and ladder exists between them
//					
//					else if(wordLadderSolver.validateResult(wordPair[0], wordPair[1], ))
//					{
//						ladderSolution.add(wordPair[1]);
//						System.out.println("For the words: " + wordPair[0] + "and" + wordPair[1]+ ", this word ladder was found:");
//						//printList(solutionList); print 
//					}
//					
//					//Both words are in dictionary, but no ladder exists between them
//					else
//					{
//						
//						System.err.println("There is no word ladder between words: " + wordPair[0] + " and " + wordPair[1] + "!");
//					}
//					
//					System.out.println("");
//					//clear solution and start over with new pair of words
//					ladderSolution = new ArrayList<String>();
//				}
//				
//				
//				// close readers
//				reader.close();
//				
//				freader.close();
//	        } 
//	        
//	        catch (FileNotFoundException e) 
//			{
//				System.err.println ("Error: File not found. Exiting...");
//				e.printStackTrace();
//				System.exit(-1);
//			} 
//	        catch (IOException e) 
//			{
//				System.err.println ("Error: IO exception. Exiting...");
//				e.printStackTrace();
//				System.exit(-1);
//			}
        try 
        {
            List<String> result = wordLadderSolver.computeLadder("stone", "money");
            boolean correct = wordLadderSolver.validateResult("stone", "money", result);
        } 
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
        
        
    }
    
    
}
