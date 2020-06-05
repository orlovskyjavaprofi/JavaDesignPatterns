package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commandpatterexample.Cook;
import commandpatterexample.Customer;
import commandpatterexample.Diner;
import commandpatterexample.ListOfOrders;
import commandpatterexample.Order;
import commandpatterexample.Waitress;

class CommandPatternTest {

	private Cook cookObj;
	private Waitress waitressObj;
	private Customer customerObj;
	private Diner dinerObj;

	@BeforeEach
	public void setUp() {
		cookObj = new Cook();
		waitressObj = new Waitress();
		customerObj = new Customer(waitressObj);
		dinerObj = new Diner();
	}

	@Test
	public void testIfCookObjCanBeCreated() {
		assertNotNull(cookObj,"Cook object cant be created!");
	}

	@Test
	public void testIfCookCanCookFries() {
		String expectedResult = "Making fries";
		assertEquals(expectedResult, cookObj.makeFries(), "cook cant make fries");
	}

	@Test
	public void testIfCookCanCookBurger() {
		String expectedResult = "Making a burger";
		assertEquals(expectedResult, cookObj.makeBurger(), "cook cant make burger");
	}

	@Test
	public void testIfWaitressCanBeCreated() {
		assertNotNull(waitressObj, "Can't create waitress object!");
	}

	@Test
	public void testIfWaitressCanForwardOrder() {

		Order order = () -> {
			ListOfOrders orders = new ListOfOrders();
			orders.getOrders().add(cookObj.makeBurger());
			orders.getOrders().add(cookObj.makeFries());

			return orders;
		};
		assertTrue(waitressObj.takeOrder(order) instanceof Order);
	}

	@Test
	public void testIfCustomerCanBeCreated() {

		assertNotNull(customerObj, "Customer object can't be created!");
	}

	@Test
	public void testIfCustomerCanOrderFood() {
		boolean expectedResult = true;
		Order order = () -> {
			ListOfOrders orders = new ListOfOrders();
			orders.getOrders().add(cookObj.makeBurger());
			orders.getOrders().add(cookObj.makeFries());

			return orders;
		};

		assertEquals(expectedResult, customerObj.orderFood(order), "Customer cant order food");
	}

	@Test
	public void testIfDinerCanBeCreated() {
		assertNotNull(dinerObj, "Cant create diner");
	}
}
