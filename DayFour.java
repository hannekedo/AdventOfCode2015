package adventofcode2015;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class DayFour {

	public static void main(String[] args) throws NoSuchAlgorithmException  {
		Scanner userInput= new Scanner(System.in);
		System.out.print("Please enter your secret key: ");
		String key = userInput.next();

		MessageDigest digestAlgorithm = MessageDigest.getInstance("MD5");
				
		userInput.close();
		
	
		String result = "";
		for (int i = 0 ; ; i++){
			String text = key +i;
			result = javax.xml.bind.DatatypeConverter.printHexBinary(digestAlgorithm.digest(text.getBytes(StandardCharsets.UTF_8)));
			
			if(result.startsWith("00000")){
				System.out.println(i);
				break;
			}
		}
	
		
	}
	
	
}