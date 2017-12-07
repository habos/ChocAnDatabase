package project4;

/**
 * Reports sent to members.
 * @author Chris
 * @author Harry
 */

public class MemberReport extends Report {
	
	/**
	 * Constructor
	 * @param id the corresponding member ID
	 * @param memberData personal data corresponding to the member
	 * 
	 */
	public MemberReport(int id, MembersDatabase memberData){
		report = memberData.getRecords(id);
	}
}
