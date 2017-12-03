package project4;

public class EFT extends Report{
	
	/**
	 * This function writes the relavant info into the EFT
	 * @param providerName
	 * @param providerID
	 * @param price
	 */
	public EFT(String providerName, int providerID, int price ){
		
		report = "Provider Name: "+providerName+"\nProvider ID: "+providerID+"\nFee to be paid: "+price+"\n";
		
	}
	
}
