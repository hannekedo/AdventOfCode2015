package adventofcode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DayThree {
	
	public static void main(String[] args) {
		
	    File file = new File("testinputday3.txt");
	    Set <String> addresses = new HashSet<>();
	    int housesVisited = 0;

	    try {

	        Scanner sc = new Scanner(file);
	        sc.useDelimiter("");

	        int xCoordinate = 0;
	        int yCoordinate = 0;
	        
	        addresses.add(xCoordinate + "," + yCoordinate);
		    housesVisited = addresses.size();
	        
	        
	        while (sc.hasNext()) {
	            String s = sc.next();
	            char c = s.charAt(0);
	       
	            if (c == '^'){
	            	yCoordinate = yCoordinate + 1;
	            }
	            
	            if (c == 'v'){
	            	yCoordinate = yCoordinate - 1;
	            }
	            
	            if (c == '>'){
	            	xCoordinate = xCoordinate + 1;
	            }
	            
	            if (c == '<'){
	            	xCoordinate = xCoordinate - 1;
	            }
	            
	            addresses.add(xCoordinate + "," + yCoordinate);
			    housesVisited = addresses.size();
	            
	        }
	        
	        sc.close();
	        
	    } 
	    
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    housesVisited = addresses.size();
        System.out.println("Houses visited:" + housesVisited);
	   
	 }

}
