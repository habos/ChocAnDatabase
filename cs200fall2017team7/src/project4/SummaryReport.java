package project4;

public class SummaryReport extends Report{

	protected int providerTotalFee;
	protected int overallTotal;
	protected int providerConsultations;
	
	protected int numProvidersServices;// number of providers who gave service
	protected int totalConsultations;
	protected int totalFees;
	
	protected String providerName;
	
	public SummaryReport(ProvidersDatabase providers) {
		 
		report = "";
		
		providerTotalFee = 0;
		overallTotal = 0;
		providerConsultations = 0;
		
		totalConsultations = providers.getTotalConsultant();
		totalFees = providers.getTotalFee();
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
				
			}
		}
		
		report += "\nTotal Providers who provided service: "+numProvidersServices+"\nTotal Consultations: "+totalConsultations+"\nTotal Fees: "+totalFees;
		
	}
	
	
}
