package FoodDelivery;

class CloudKitchenOrders implements Orders {

	private String customerName;
	private double orderAmount;
	private double deliveryDistance;
	private double billAmount;

	public CloudKitchenOrders(String customerName, double orderAmount, double deliveryDistance, double billAmount) {
		this.customerName = customerName;
		this.orderAmount = orderAmount;
		this.deliveryDistance = deliveryDistance;
		this.billAmount = billAmount;
	}
	
	public double calculateFinalAmount() {
		if (deliveryDistance > 5) {
			billAmount = billAmount + 60.0;
			System.out.println("Hey"+customerName+", your bill amount is "+billAmount);
		} else {
			billAmount = billAmount + 30.0;
			System.out.println("Hey"+customerName+", your bill amount is "+billAmount);
		}
		return billAmount;
	}
	
	@Override
	public String getOrderDetails() {
		return "Customer Name: "+customerName+" "+"Final Amounnt:"+calculateFinalAmount();
	}
}
