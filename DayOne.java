package adventofcode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne {
	
	public static void main(String[] args) {
		
	    File file = new File("testinput.txt");
	    int floor = 0;

	    try {

	        Scanner sc = new Scanner(file);
	        sc.useDelimiter("");

	        while (sc.hasNext()) {
	            String s = sc.next();
	            char c = s.charAt(0);

	            if (c == '('){
	            	floor = floor +1;
	            }
	            
	            if (c == ')'){
	            	floor = floor -1;
	            }
	        }
	        
	        sc.close();
	    } 
	    
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	   
	    System.out.println(floor);
	 }
}
