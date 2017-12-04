package project4;

public class ProviderReport extends Report {
	
	
	
	/**
	 * Constructor
	 * @param id - the corresponding provider ID
	 * @param providerData - personal data corresponding to the provider
	 * 
	 */
	public ProviderReport(int id, ProvidersDatabase providerData){
		report = providerData.getRecords(id);
	}
}
