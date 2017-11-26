package project4;
/**
 * Start of the program
 * @author Chris
 *
 */
public class Setup {

	public static void main(String[] args) {
	
		/*
		MemberDatabase members = new MembersDatabase();
		ProviderDatabase providers = new ProvidersDatabase();
		
		*/
		ClaimsDatabase claims = new ClaimsDatabase();
		claims.add();
		System.out.println(claims.getClaims(1));
		
	}

}
