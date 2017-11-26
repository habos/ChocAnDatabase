package project4;
/**
 * Start of the program (currently for testing)
 * @author Chris
 *
 */
public class Setup {

	public static void main(String[] args) {
	
		
		MembersDatabase members = new MembersDatabase();
		members.add(new Member(1, "Joe", "123 Main St", "Tuscaloosa", "AL", "30541"));
		System.out.println(members.getRecords(1));
		members.delete(1);
		System.out.println(members.getRecords(1));
		/*
		ProvidersDatabase providers = new ProvidersDatabase();
		providers.add();
		//System.out.println(providers.getRecords(1));
		
		ClaimsDatabase claims = new ClaimsDatabase();
		*/
		
	}

}
