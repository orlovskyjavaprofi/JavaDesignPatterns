package commandpatterexample;

public class Diner {
	public static void main(String[] args) {
		Cook cook = new Cook();
		Waitress waitress = new Waitress();
		Customer customer = new Customer(waitress);

		Order o = () -> {
			ListOfOrders orders = new ListOfOrders();
			orders.getOrders().add(cook.makeBurger());
			orders.getOrders().add(cook.makeFries());

			return orders;
		};
		customer.orderFood(o);
	}
}
