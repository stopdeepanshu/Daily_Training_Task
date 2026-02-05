package Insurance_Task;

public class VehicleInsurance implements Insurance {
	private String policyHolder;
	private int vehicleType;
	private double vehicleValue;
	private double rate;

	
	
	public VehicleInsurance(String policyHolder, int vehicleType, double vehicleValue) {
		super();
		this.policyHolder = policyHolder;
		this.vehicleType = vehicleType;
		this.vehicleValue = vehicleValue;
		this.rate = rate;
	}

	@Override
	public void calculateAnnualPremium() {
		if (vehicleType == 2) {
			rate = 0.02;
		} else if (vehicleType == 4) {
			rate = 0.04;
		}
		double annualPremium = vehicleValue * rate;
		System.out.println("Your annual premium is " + annualPremium);
		
		double monthlyPremium = annualPremium/12;
		System.out.println("Your monthly premium is "+monthlyPremium);
	}

}
