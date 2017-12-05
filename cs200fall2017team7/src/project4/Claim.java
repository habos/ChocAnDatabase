package project4;
/**
 * Entity stereotype class that contains data for claims and methods to access the data.
 * @author Logan
 */
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
	boolean isCurrent;

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
		isCurrent = true;

	}
	public Claim( String currentDate, String dateProvided, int providerId, int memberId, int serviceCode, String comments) {
		this.providerId = providerId;
		this.memberId=memberId;
		this.currentDate = currentDate;
		this.serviceCode = serviceCode;
		this.comments = comments;
		this.dateProvided = dateProvided;
		isCurrent = true;
		
	}
	
	/**
	 * Gets the provider ID.
	 * @return providerID 
	 */
	public int getID() {
		return providerId;
	}

	//NOTE: Check to see if we ever use this method.
	/**
	 * Returns a string with claim information
	 */
	public String toString() {
		return "Current date and time: " + currentDate + "\n" + "Date service was provided: " + dateProvided + "\n"
				+ "Provider number: " + providerId + "\n" + "Member number: " + memberId + "\n" + "Service Code: "
				+ serviceCode + "\nComments: " + comments;
	}

	/**
	 * Returns a string consisting of claim information that a provider needs.
	 * @return A string formatted in accordance with requirements
	 */
	public String toStringProvider() {
		return "Date of Service: " + dateProvided + "\nDate and time data were recived by the computer: " + currentDate
				+ "\nMember name: " + memberName + "\nMember number: " + memberId + "\nService code: " + serviceCode
				+ "fee to be paid: $" + fee;
	}

	/**
	 * Returns a string consisting of claim information that a member needs
	 * @return A string formatted in accordance with requirements
	 */
	public String toStringMember() {
		return "Date of service: " + dateProvided + "\nProvider name: " + providerName + "\nService name: " + serviceName;
	}
	
	/**
	 * This method will return whether or not a provider matches a particular provider ID.
	 * @param id the ID to be tested for a match
	 * @return if id matches or not
	 */
	public boolean matchProvider(int id) {
		if (id == providerId)
			return true;
		return false;
	}
	/**
	 * This method will return whether or not a member matches a particular member ID.
	 * 
	 *
	 * @param id the ID to be tested for a match
	 * @return if id matches or not
	 */
	public boolean matchMember(int id) {
		if (id == memberId)
			return true;
		return false;
	}
	
	/**
	 * Gets fee for the claim.
	 * @return The fee
	 */
	public int getFee() {
		return fee;
	}

}
