package project4;

/**
 * Entity class for a summary report
 * @author Logan
 */
public class SummaryReport extends Report{

	protected int providerTotalFee;
	protected int overallTotal;
	protected int providerConsultations;
	
	protected int numProvidersServices;// number of providers who gave service
	protected int totalConsultations;
	protected int totalFees;
	
	protected String providerName;
	
	/**
	 * Constructor
	 * @param providers Provider database
	 */
	public SummaryReport(ProvidersDatabase providers) {
		 
		report = "";
		
		providerTotalFee = 0;
		overallTotal = 0;
		providerConsultations = 0;
		
		totalConsultations =  0;//providers.getTotalConsultant();
		totalFees =     0;//providers.getTotalFee();
		numProvidersServices = 0;
		
		
		for(int i = 0; i < providers.getSize(); i++) 
		{
			if(providers.getIndivFee(i) != 0)
			{
				
				numProvidersServices++;
				
				providerTotalFee = providers.getIndivFee(i);
				providerConsultations = providers.getConsultant(i);
				providerName = providers.getName(i);
				
				report+= providerName+"\n"+"Provider Fee Total: "+providerTotalFee+"\nProvider Total Consultations: "+providerConsultations;
				
				totalConsultations+=providerConsultations;
				totalFees+= providerTotalFee;
			}
			

		}
		
		report += "\nTotal Providers who provided service: "+numProvidersServices+"\nTotal Consultations: "+totalConsultations+"\nTotal Fees: "+totalFees;
		
	}
	
	
}
