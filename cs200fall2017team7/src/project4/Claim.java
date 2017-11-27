package project4;

public class Claim {

	private int providerId;
	String currentDate;
	int serviceCode;
	String comments;
	String dateProvided;
	int memberId;
	String memberName;
	String providerName;
	String serviceName;
	int fee;

	public Claim(int providerId, String providerName, int memberId, String memberName, String currentDate,
			int serviceCode, String serviceName, int fee, String comments, String dateProvided) {

		this.providerId = providerId;
		this.providerName = providerName;
		this.memberId = memberId;
		this.memberName = memberName;
		this.currentDate = currentDate;
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		this.fee = fee;
		this.comments = comments;
		this.dateProvided = dateProvided;

	}

	public int getID() {
		return providerId;
	}

	// FIXME- make into correct form of output (needs two more for prov and member
	// report)
	public String toString() {
		return "Current date and time: " + currentDate + "\n" + "Date service was provided: " + dateProvided + "\n"
				+ "Provider number: " + providerId + "\n" + "Member number: " + memberId + "\n" + "Service Code: "
				+ serviceCode + "\nComments: " + comments;
	}

	public String toStringProvider() {
		return "Date of Service: " + dateProvided + "\nDate and time data were recived by the computer: " + currentDate
				+ "\nMember name: " + memberName + "\nMember number: " + memberId + "\nService code: " + serviceCode
				+ "fee to be paid: $" + fee;
	}

	public String toStringMember() {
		return "Date of service: " + dateProvided + "\nProvider name: " + providerName + "\nService name: " + serviceName;

	}
	
	public String persistenceToString(){
		return currentDate + "\n" + dateProvided + "\n" + providerId + "\n" + memberId + "\n" + serviceCode + "\n" + comments + "\n#";
	}

	/**
	 * 
	 * @param id
	 * @return if id matches
	 */
	public boolean matchProvider(int id) {
		if (id == providerId)
			return true;
		return false;
	}

	public boolean matchMember(int id) {
		if (id == memberId)
			return true;
		return false;
	}
	
	public int getFee() {
		return fee;
	}

}
