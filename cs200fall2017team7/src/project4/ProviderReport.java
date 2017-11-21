package project4;

public class ProviderReport extends Report {
	
	private Provider provider;
	
	/**
	 * Constructor
	 * @param prov
	 */
	public ProviderReport(Provider prov){
		provider = prov;
	}
	
	/**
	 * toString function that will pass the report as a string
	 */
	public String toString(){
		String providerReportString = "";
		providerReportString = provider.toString();
		//Add info about services provided here
		return providerReportString;
	}
	
}
