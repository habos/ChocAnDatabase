package project4;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;

public class ClaimsDatabase {
	
	Scanner user_input = new Scanner( System.in );// create a scanner for the add method
	DateFormat dateFormat = new SimpleDateFormat("MM–DD–YYYY hh:mm:ss");// set up the date and time format
	
	
	ArrayList<Claim> claims = new ArrayList<Claim>();
	
	public void add() {
		Date date = new Date();
		
		System.out.println("Enter Provider ID: ");
		int provID = user_input.nextInt();
		System.out.println("Enter Provider ID: ");
		int memberId = user_input.nextInt();
		System.out.println("Enter Service Code: ");
		int servCode = user_input.nextInt();
		user_input.nextLine();
		System.out.println("Enter any comments: ");
		String comments = user_input.nextLine();
		System.out.println("Enter date service was provided (MM–DD–YYYY).");
		String manualDate = user_input.nextLine();
		claims.add(new Claim(provID, memberId, dateFormat.format(date), servCode, comments, manualDate));
	}
	
		
	/**
	 * 
	 * @param idOfProvider - id for the provider you want the claims of
	 * @return list of the providers claims as a string  (empty string if no matches)
	 */
	//FIXME needs two for prov and member
	public String getClaims(int idOfProvider){
	
		Iterator<Claim> claims = this.claims.iterator();
		String matchingClaims = "";
		
		while(claims.hasNext())
		{
			Claim claim = claims.next();
			if(claim.matchProvider(idOfProvider)) {
				matchingClaims += claim.toString();
			}		
		}
			return matchingClaims;	
	}

}
