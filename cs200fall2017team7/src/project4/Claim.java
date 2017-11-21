package project4;

public class Claim extends Record {
	
		private int providerID;
		String currentDate;
		int serviceCode;
		String comments;
		String dateProvided;
		
		
	public Claim(int iD, String currDate, int servCode, String note, String providedDate) {
			
		providerID = iD;
		currentDate = currDate;
		serviceCode = servCode;
		comments = note;
		dateProvided = providedDate;
			
	}
	
	public int getID() {
		return providerID;
	}
	
	public String toString() {
		return String.format("%s\r%n" + 
				"%s\r%n" + 
				"%d\r%n" + 
				"%d\r%n" + 
				"%s\r%n" 
				, currentDate, dateProvided, providerID, serviceCode, comments);
	}
	
}
