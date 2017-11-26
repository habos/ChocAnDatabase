package project4;
/**
 * Start of the program
 * @author Chris
 *
 */
public class Setup {

	public static void main(String[] args) {
	
		
		//MemberDatabase members = new MembersDatabase();
		ProvidersDatabase providers = new ProvidersDatabase();
		providers.add();
		System.out.println(providers.getRecords(1));
		
		ClaimsDatabase claims = new ClaimsDatabase();
		
		
	}

}
