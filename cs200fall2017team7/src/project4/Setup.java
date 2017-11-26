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
		
		ProvidersDatabase providers = new ProvidersDatabase();
		providers.add(new Provider(100, "Dr Smith Cholocate", "321 Other main Street", "Asoolacsut", "lA", "14503"));
		System.out.println(providers.getRecords(100));
		
		
		
	}

}
