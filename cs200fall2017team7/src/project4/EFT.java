package project4;

public class EFT extends Report{
	
	/**
	 * This function writes the relevant info into the EFT
	 * @param providerName name of provider
	 * @param providerID ID of provider
	 * @param price price of fee to be paid
	 */
	public EFT(String providerName, int providerID, int price ){
		
		report = "Provider Name: "+providerName+"\nProvider ID: "+providerID+"\nFee to be paid: "+price+"\n";
		
	}
	
}
