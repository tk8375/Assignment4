package assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
	protected static ArrayList<String> dictionaryArray = new ArrayList<String>();
	protected int wordAmount;
	
	public Dictionary(String args[])
	{
	    extractWords(args);  
	    this.wordAmount = dictionaryArray.size();
		
	}
	
	public int  getSize ()
	{
		return wordAmount;
	}
	
	public boolean checkValid(String word)
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
