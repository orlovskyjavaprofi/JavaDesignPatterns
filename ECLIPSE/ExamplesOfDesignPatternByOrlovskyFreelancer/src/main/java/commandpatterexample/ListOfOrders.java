package commandpatterexample;

import java.util.ArrayList;

public class ListOfOrders implements Order {
	ArrayList<String> orders = new ArrayList<String>();
	@Override
	public Order orderUp() {

		return this;
	}

	public ArrayList<String> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<String> orders) {
		this.orders = orders;
	}


}
