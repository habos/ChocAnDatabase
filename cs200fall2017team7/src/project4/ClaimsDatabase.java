package project4;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ClaimsDatabase {
	
	Scanner user_input = new Scanner( System.in );// create a scanner for the add method
	DateFormat dateFormat = new SimpleDateFormat("MM–DD–YYYY hh:mm:ss");// set up the date and time format
	
	
	Claim[] claims;
	
	public void add() {
		Date date = new Date();
		
		System.out.println("%nEnter Provider ID: ");
		int provID = user_input.nextInt();
		System.out.println("%nEnter Service Code: ");
		int servCode = user_input.nextInt();
		System.out.println("%nEnter any comments: ");
		String comments = user_input.next();
		System.out.println("%nEnter date service was provided (MM–DD–YYYY).");
		String manualDate = user_input.next();
		
		
		
		Claim newClaim = new Claim(provID, dateFormat.format(date), servCode, comments, manualDate);
	}


}
