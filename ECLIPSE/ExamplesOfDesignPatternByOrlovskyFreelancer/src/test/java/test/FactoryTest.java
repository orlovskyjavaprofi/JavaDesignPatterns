package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import factoryexample.Pizza;
import factoryexample.PizzaStore;
import factoryexample.SimplePizzaFactory;
import factoryexample.pizzatype.CheesePizza;
import factoryexample.pizzatype.ClamPizza;
import factoryexample.pizzatype.PepperoniPizza;
import factoryexample.pizzatype.VeggiePizza;

class FactoryTest extends Pizza {
	private SimplePizzaFactory simplePizzaFactoryObj;
	private CheesePizza cheesePizzaObj;
	private ClamPizza clamPizzaObj;
	private PepperoniPizza pepperoniPizzaObj;
	private VeggiePizza veggiePizzaObj;
	private PizzaStore pizzaStoreObj;

	@BeforeEach
	public void setUp() {

		simplePizzaFactoryObj = new SimplePizzaFactory();
		pizzaStoreObj = new PizzaStore(simplePizzaFactoryObj);
		cheesePizzaObj = new CheesePizza();
		clamPizzaObj = new ClamPizza();
		pepperoniPizzaObj = new PepperoniPizza();
		veggiePizzaObj = new VeggiePizza();
	}

	@Test
	public void checkThatclamPizzaStoreCanBeCreated() {
		assertNotNull(pizzaStoreObj);
	}

	@Test
	public void checkIfPizzaOrderCanBemade() {

		assertTrue(pizzaStoreObj.orderPizza("cheese") instanceof Pizza);
	}

	@Test
	public void testIfSimpleFactorCanProduceCheesePizza() {
		assertTrue(simplePizzaFactoryObj.createPizza("cheese") instanceof CheesePizza);
	}

	@Test
	public void testIfSimpleFactorCanProducePepperoniPizza() {
		assertTrue(simplePizzaFactoryObj.createPizza("pepperoni") instanceof PepperoniPizza);
	}

	@Test
	public void testIfSimpleFactorCanProduceVeggiePizza() {
		assertTrue(simplePizzaFactoryObj.createPizza("veggie") instanceof VeggiePizza);
	}

	@Test
	public void testIfSimpleFactorCanProduceClamPizza() {
		assertTrue(simplePizzaFactoryObj.createPizza("clam") instanceof ClamPizza);
	}

	@Test
	public void checkThatclamPepperoniVeggiePizzaCanBeCreated() {
		assertNotNull(veggiePizzaObj);
	}

	@Test
	public void checkThatclamPepperoniPizzaCanBeCreated() {
		assertNotNull(pepperoniPizzaObj);
	}

	@Test
	public void checkThatclamPizzaCanBeCreated() {
		assertNotNull(clamPizzaObj);
	}

	@Test
	public void checkThatPizzaCanBeCreated() {
		assertNotNull(simplePizzaFactoryObj);
	}

	@Test
	public void checkThatcheesePizzaCanBeCreated() {
		assertNotNull(cheesePizzaObj);
	}

	@Test
	public void testIfDefaulPizzaSetUp() {
		String expectedResult = "default pizza!";
		String actualResult = getName();
		assertEquals(expectedResult, actualResult, "Default pizza is not set up!");
	}
	
	@Test
	public void testIfDefaulPizzaprepared() {
		String expectedResult = "---- default pizza! ----\n" + "default dough\n" + "default sauce\n";
		String actualResult = toString();
		assertEquals(expectedResult, actualResult, "Default pizza is not prepared!");
	}


}
