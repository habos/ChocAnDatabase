package project4;

public class ProviderReport extends Report {
	
	
	
	/**
	 * Constructor
	 * @param prov
	 */
	public ProviderReport(int id, ProvidersDatabase providerData){
		report = providerData.getRecords(id);
	}
	


}
