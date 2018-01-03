package adventofcode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayFive {
	
	
	public static void main(String[] args) {
		
		int niceCounter = 0;
		int naughtyCounter = 0;
		
	    File file = new File("testinputday5.txt");

	    try {

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            String s = sc.next();
	            
	            int vowelCounter = countVowels(s);
	            if (vowelCounter > 2 && findDoubleLetters(s) == true && findForbiddenStrings(s) == false ){
	            	niceCounter ++;
	            }
	            
	            else {
	            	naughtyCounter++;
	            }
	        
	        }
	        
	        sc.close();
	    } 
	    
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	   
	    System.out.println("Nice:" + niceCounter);
	    System.out.println("Naughty:" + naughtyCounter);
	 }
	
	
	public static int countVowels (String s){
		int countLineVowels = 0;
		
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
				countLineVowels ++;
			}
		}
		
		return countLineVowels;
	}
	
	
	
	public static boolean findDoubleLetters (String s){
		 
		for (int i = 0; i <s.length()-1; i++){
			if (s.charAt(i) == s.charAt(i+1)){
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public static boolean findForbiddenStrings (String s){
		for (int i = 0; i < s.length()-1; i++){
			if (s.charAt(i) == 'a' && s.charAt(i+1) == 'b'){
				return true;
			}
			
			if (s.charAt(i) == 'c' && s.charAt(i+1) == 'd'){
				return true;
			}
			
			if (s.charAt(i) == 'p' && s.charAt(i+1) == 'q'){
				return true;
			}
			
			if (s.charAt(i) == 'x' && s.charAt(i+1) == 'y'){
				return true;
			}
		}
		
		return false;
	}

}
