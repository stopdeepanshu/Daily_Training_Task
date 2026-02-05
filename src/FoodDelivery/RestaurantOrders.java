package FoodDelivery;

public class RestaurantOrders implements Orders {

	private String customerName;
	private double orderAmount;
	private double GSTPercentage;
	

	public RestaurantOrders(String customerName, double orderAmount, double GSTPercentage ) {

		this.customerName = customerName;
		this.orderAmount = orderAmount;
		this.GSTPercentage = GSTPercentage;
	
	}

	@Override
	public double calculateFinalAmount() {
		orderAmount= orderAmount + (orderAmount * (GSTPercentage / 100.0));
		System.out.println("Hey" + customerName + ", your bill final amount is " + orderAmount);
		return orderAmount;
	}

	@Override
	public String getOrderDetails() {
		
		return "Customer Name: "+customerName+" Final Order Amount: "+calculateFinalAmount();
	}
}
