package project4;

public class Claim {
	
		private int providerId;
		String currentDate;
		int serviceCode;
		String comments;
		String dateProvided;
		int memberId;
		
	public Claim(int providerId,int memberId, String currDate, int servCode, String note, String providedDate) {
			
		providerId = this.providerId;
		memberId = this.memberId;
		currentDate = currDate;
		serviceCode = servCode;
		comments = note;
		dateProvided = providedDate;
			
	}
	
	public int getID() {
		return providerId;
	}

	//FIXME- make into correct form of output (needs two for prov and member report)
	public String toString() {
		return "\nDate of Service: "+ dateProvided+"\n"
				+"\nDate and time data were recived by the computer: "+ currentDate 
				+"\nService Code: "+ serviceCode
				+"\nComments: "+comments;
	}
	/**
	 * 
	 * @param id
	 * @return if id matches
	 */
	public boolean matchProvider(int id) {
		if(id == providerId)
			return true;
		return false;
	}
	public boolean matchMember(int id) {
		if(id==memberId)
			return true;
		return false;
	}
	
}
