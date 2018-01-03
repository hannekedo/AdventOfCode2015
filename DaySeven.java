package adventofcode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DaySeven {
	
	static HashMap <String, String> instructions = new HashMap <String, String>();
	
	public static void main(String[] args) {
		
		Scanner userInput= new Scanner(System.in);
		System.out.print("Of which wire do you want to know the signal?: ");
		String wire = userInput.next();
		userInput.close();
		
		File file = new File("testinputday7.txt");

	    try {

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	        	String s = sc.nextLine();
	            String[] keyandvalue = s.split(" -> ");
	            String key = keyandvalue[1];
	            String value = keyandvalue[0];
	        	instructions.put(key, value);
	        }
	        
	        sc.close();
	    } 
	    
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    int signal = findValue(wire);
	    System.out.println(signal);
	   
	 }
	
	public static int findValue(String key){
			
		if (integerCheck(key) == true){
			return Integer.parseInt(key);
		}
	    

		String instruction = instructions.get(key);
	    	
		if (instruction.contains("AND")){
			String[] inputwires = instruction.split(" ");
			String inputwire1 = inputwires[0];
			String inputwire2 = inputwires[2];
			return findValue(inputwire1) & findValue(inputwire2);			
		}
		
		else if (instruction.contains("OR")){
			String[] inputwires = instruction.split(" ");
			String inputwire1 = inputwires[0];
			String inputwire2 = inputwires[2];
			return findValue(inputwire1) | findValue(inputwire2);			
		}
		
		else if (instruction.contains("LSHIFT")){
			String[] inputwires = instruction.split(" ");
			String inputwire1 = inputwires[0];
			String inputwire2 = inputwires[2];
			return findValue(inputwire1) << findValue(inputwire2);			
		}
		
		else if (instruction.contains("RSHIFT")){
			String[] inputwires = instruction.split(" ");
			String inputwire1 = inputwires[0];
			String inputwire2 = inputwires[2];
			return findValue(inputwire1) >>> findValue(inputwire2);			
		}
		
		else if (instruction.contains("NOT")){
			String[] inputwires = instruction.split(" ");
			String inputwire = inputwires[1];
			return ~ findValue(inputwire) & 0xFFFF;		
		}
		
		else if (instruction.split(" ").length == 1){
			return findValue(instruction);
		}
			
	    return 0;
	 }
	
	
	
	public static boolean integerCheck(String key){
	    try { 
	        Integer.parseInt(key); 
	    } 
	    
	    catch(NumberFormatException e) { 
	        return false;    
	    } 
	    
	    catch(NullPointerException e) {
	        return false;
	    }
	    
	    return true;
	}
}

