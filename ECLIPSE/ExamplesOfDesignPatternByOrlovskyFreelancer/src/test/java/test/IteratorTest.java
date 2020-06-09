package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iteratorexample.Waitress;
import iteratorexample.AlternatingDinerMenuIterator;
import iteratorexample.CafeMenu;
import iteratorexample.DinerMenu;
import iteratorexample.DinerMenuIterator;
import iteratorexample.Menu;
import iteratorexample.MenuItem;
import iteratorexample.PancakeHouseMenu;

class IteratorTest {

	private MenuItem menuItemObj;
	private DinerMenuIterator dinerMenuIteratorObj;
	private CafeMenu cafeMenuObj;
	private DinerMenu dinerMenuObj;
	private AlternatingDinerMenuIterator alternatingDinerMenuIteratorObj;
	private PancakeHouseMenu pancakeHouseMenuObj;
	private Waitress waitressObj;

	@BeforeEach
	public void setUp() {
		menuItemObj = new MenuItem("First", "Great", true, 0.0);
		cafeMenuObj = new CafeMenu();
		pancakeHouseMenuObj = new PancakeHouseMenu();
		dinerMenuObj = new DinerMenu();
		MenuItem[] list = new MenuItem[] { menuItemObj };
		dinerMenuIteratorObj = new DinerMenuIterator(list);

		alternatingDinerMenuIteratorObj = new AlternatingDinerMenuIterator(list);

		waitressObj = new Waitress(pancakeHouseMenuObj, dinerMenuObj, cafeMenuObj);
	}

	@Test
	public void executeTestDriveforMenus() {
		waitressObj.printMenu();
		waitressObj.printVegetarianMenu();

		System.out.println("\nCustomer asks, is the Hotdog vegetarian?");
		System.out.print("Waitress says: ");
		checkForVegetarianFood();
		System.out.println("\nCustomer asks, are the Waffles vegetarian?");
		System.out.print("Waitress says: ");
		checkIfWafflesVegetarian();
	}

	private void checkIfWafflesVegetarian() {
		if (waitressObj.isItemVegetarian("Waffles")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private void checkForVegetarianFood() {
		if (waitressObj.isItemVegetarian("Hotdog")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	@Test
	public void testIfWaitressCanBeCreated() {
		assertNotNull(waitressObj);
	}

	@Test
	public void testIfPancakeHouseMenuCanBeCreated() {
		assertNotNull(pancakeHouseMenuObj);
	}

	@Test
	public void testIfAlternatingDinerMenuIteratorCanBeCreated() {
		assertNotNull(alternatingDinerMenuIteratorObj);
	}

	@Test
	public void testIfdinerMenuObjCanBeCreated() {
		assertNotNull(dinerMenuObj);
	}

	@Test
	public void testIfcafeMenuObjCanBeCreated() {
		assertNotNull(cafeMenuObj);
	}

	@Test
	public void testIfdinerMenuIteratorObjCanBeCreated() {
		assertNotNull(dinerMenuIteratorObj);
	}

	@Test
	public void testIfMenuItemCanBeCreated() {
		assertNotNull(menuItemObj);
	}

	@Test
	public void testIfNameOfMenuCanBeRecoverd() {
		assertEquals("First", menuItemObj.getName(), "name of menu was not returned");
	}

	@Test
	public void testIfDescriptionOfMenuCanBeRecoverd() {
		assertEquals("Great", menuItemObj.getDescription(), "name of description was not returned");
	}

	@Test
	public void testIfPriceIsSetUpOfMenuCanBeRecoverd() {
		assertEquals(0.0, menuItemObj.getPrice(), "price of price was not returned");
	}

	@Test
	public void testIfVegetarianIsSetUpOfMenuCanBeRecoverd() {
		assertEquals(true, menuItemObj.isVegetarian(), "price of vegetarian was not returned");
	}

}
