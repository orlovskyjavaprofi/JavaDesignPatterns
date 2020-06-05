package commandpatterexample;

public class Waitress {
	Order order;

	public Waitress() {
	}

	public Order takeOrder(Order order) {
		this.order = order;
		return order.orderUp();
	}
}