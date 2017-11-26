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
	
	public void setID(int ID){
		this.providerID = ID;
	}
	//FIXME- make into correct form of output
	public String toString() {
		return "Provider ID: "+providerID+"\nDate Entered: "+ currentDate +"\nService Code: "+ serviceCode+
				"\nComments: "+comments+"\nDate Provided: "+ dateProvided+"\n";
	}
	/**
	 * 
	 * @param id
	 * @return if id matches
	 */
	public boolean match(int id) {
		if(id == providerID)
			return true;
		return false;
	}
	
}
