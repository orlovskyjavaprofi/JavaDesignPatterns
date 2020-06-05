package commandpatterexample;

public class Customer {

	Waitress waitress;

	public Customer(Waitress waitress) {
		this.waitress = waitress;
	}

	public boolean orderFood(Order order) {
		boolean result = false;
		if (order != null) {
			waitress.takeOrder(order);
			result = true;
		}

		return result;
	}

}
