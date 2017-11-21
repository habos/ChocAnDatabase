package project4;

public class MemberReport extends Report {
	
	private Member member;
	
	/**
	 * Constructor
	 * @param mem = a member object
	 */
	public MemberReport(Member mem){
		member = mem;
	}
	
	/**
	 * toString function that will pass the report as a string
	 */
	public String toString(){
		String memberReportString = "";
		memberReportString = member.toString();
		//Once ClaimsDatabase is done add all the member claims here
		return memberReportString;
	}
	
}
