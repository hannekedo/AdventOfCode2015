package adventofcode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {
	
	public static void main(String[] args) {
		
	    File file = new File("testinputday2.txt");
	    int totalPaper = 0;

	    try {

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	        	String s = sc.next();
	            String[] dimensions = s.split("x");
	            int length = Integer.parseInt(dimensions[0]);
	            int width = Integer.parseInt(dimensions[1]);
	            int height = Integer.parseInt(dimensions[2]);
	            	                  	            
	            int paperNeeded = paperarea (length, width, height) + smallestside (length, width, height);

	            totalPaper = totalPaper + paperNeeded;
	        }
	        
	        System.out.println("Paper needed:"+totalPaper);
	        
	        sc.close();
	    } 
	    
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	   
	 }
	
	private static int paperarea(int length, int width, int height){
		return (2*length*width)+(2*width*height)+(2*height*length);
	}
	
	private static int smallestside (int length, int width, int height){
        int smallestside = 1;
		
		if (length*width <= width*height && length*width  <= height*length){
        	smallestside = length*width;
        }
        
        else if (width*height <= length*width && width*height <= height*length){
        	smallestside = width*height;
        }
        
        else if (height*length <= width*height && height*length <= length*width){
        	smallestside = height*length;
        }
		
		return smallestside;
	}
}

