package project4;

public class MemberReport extends Report {
	
	/**
	 * Constructor
	 * @param id the corresponding member ID
	 * @param memberData personal data corresponding to the member
	 * @return void
	 */
	public MemberReport(int id, MembersDatabase memberData){
		report = memberData.getRecords(id);
	}
}
