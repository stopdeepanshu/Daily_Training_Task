package FoodDelivery;

public class GroceryOrders implements Orders {

	private String customerName;
	private double orderAmount;
	private boolean isMembershipHolder;

	public GroceryOrders(String customerName, double orderAmount, boolean isMembershipHolder) {
		super();
		this.customerName = customerName;
		this.orderAmount = orderAmount;
		this.isMembershipHolder = isMembershipHolder;
	}

	

	public double calculateFinalAmount() {
		double billAmount=0;
		if (isMembershipHolder == true) {
			billAmount = orderAmount - (orderAmount*0.10);
			System.out.println("Hi Premium Member, You got 10% of discount and Your Billing Amount is " + billAmount+".");
		} else {
			billAmount = orderAmount;
			System.out.println("Hi "+customerName+", The Billing amount is " + billAmount);
		}
		return billAmount;
		
	}

	@Override
	public String getOrderDetails() {
		return "customer Name :"+customerName+"\n Order Amount:"+"\n Final Amount :"+calculateFinalAmount();
	}
}
