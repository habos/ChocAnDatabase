package project4;

/**
 * Special type of report that contains EFT information.
 * @author Logan
 */

public class EFT extends Report{
	
	/**
	 * This function writes the relevant info into the EFT
	 * @param providerName name of provider
	 * @param providerID ID of provider
	 * @param fee price of fee to be paid
	 */
	public EFT(String providerName, int providerID, int fee){
		
		report = "Provider Name: "+providerName+"\nProvider ID: "+providerID+"\nFee to be paid: "+fee+"\n";
		
	}
	
}
