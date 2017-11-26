package project4;

public class MemberReport extends Report {
	
	/**
	 * Constructor
	 * @param mem = a member object
	 */
	public MemberReport(int id, MembersDatabase memberData){
		report = memberData.getRecords(id);
	}
	
}
