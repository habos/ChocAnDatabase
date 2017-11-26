package project4;

public class ProviderReport extends Report {
	
	
	
	/**
	 * Constructor
	 * @param prov
	 */
	public ProviderReport(int id, ProvidersDatabase providerData, ClaimsDatabase claimsData){
		report = providerData.getRecords(id)+claimsData.getClaims(id);
	}
	
	/**
	 * toString function that will pass the report as a string
	 */

}
