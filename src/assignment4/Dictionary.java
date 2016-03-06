package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
	protected static ArrayList<String> dictionaryArray = new ArrayList<String>();
	static char alphabet[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	protected int wordAmount;
	public static char nextLetter (char letter){
		int index = 0;
		for(int i = 0; i < alphabet.length; i++){
			if(letter == alphabet[i]){
				index = (i + 1)% alphabet.length;
				i=alphabet.length;
			}
		}
		return alphabet[index];
	}
	public Dictionary(String args[])
	{
	    extractWords(args);  
	    this.wordAmount = dictionaryArray.size();
		
	}
	
	public int  getSize ()
	{
		return wordAmount;
	}
	
	public static boolean checkValid(String word)
	{
		
		for (int i=0; i<dictionaryArray.size(); i++)
		{
			if(dictionaryArray.get(i).equalsIgnoreCase(word))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void extractWords(String args[])
	{
		 try 
	        {
	         
	 			FileReader freader = new FileReader(args[0]);
	 			BufferedReader reader = new BufferedReader(freader);
	 			
	 			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
					if(!s.startsWith("*"))
					{
						dictionaryArray.add(s.substring(0,5));
					}
				}
	 			
	 			
	 			
			reader.close();
			freader.close();
	        } 
	        
	        catch (FileNotFoundException e) 
			{
				System.err.println ("Error: File not found. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			} 
	        catch (IOException e) 
			{
				System.err.println ("Error: IO exception. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			}
		
		
	}

}
