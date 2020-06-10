package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import compositepatternexample.CompositeIterator;
import compositepatternexample.Menu;
import compositepatternexample.MenuComponent;
import compositepatternexample.MenuItem;
import compositepatternexample.NullIterator;
import compositepatternexample.Waitress;

class CompositePatternTest {
	private NullIterator nullIteratorObj;
	private CompositeIterator compositeIteratorObj;
	private MenuItem menuItemObj;
	private Menu menuObj;
	private Waitress waitressObj;
	private MenuComponent allMenus;
	private Iterator<MenuComponent> iterator;
	private MenuComponent pancakeHouseMenu;
	private MenuComponent dinerMenu;
	private MenuComponent cafeMenu;
	private MenuComponent dessertMenu;

	@BeforeEach
	public void setUp() {
		allMenus = new Menu("ALL MENUS", "All menus combined");
		nullIteratorObj = new NullIterator();
		menuItemObj = new MenuItem("Burger", "Cool Burger", false, 9.99);
		compositeIteratorObj = new CompositeIterator(iterator);
		menuObj = new Menu("Cool menu", "Big menu");

		pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
		dinerMenu = new Menu("DINER MENU", "Lunch");
		cafeMenu = new Menu("CAFE MENU", "Dinner");
		dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		waitressObj = new Waitress(allMenus);

		pancakeCreateMenus();
		createDinerMenu();
		createDessertMenu();
		createCafeMenu();
	}

	private void createCafeMenu() {
		cafeMenu.add(new MenuItem("Veggie Burger and Air Fries",
				"Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99));
		cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69));
		cafeMenu.add(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29));
	}

	private void createDessertMenu() {
		dessertMenu.add(
				new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true, 1.59));
		dessertMenu.add(
				new MenuItem("Cheesecake", "Creamy New York cheesecake, with a chocolate graham crust", true, 1.99));
		dessertMenu.add(new MenuItem("Sorbet", "A scoop of raspberry and a scoop of lime", true, 1.89));
	}

	private void createDinerMenu() {
		dinerMenu
				.add(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
		dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
		dinerMenu.add(new MenuItem("Soup of the day", "A bowl of the soup of the day, with a side of potato salad",
				false, 3.29));
		dinerMenu.add(
				new MenuItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05));
		dinerMenu.add(new MenuItem("Steamed Veggies and Brown Rice", "A medly of steamed vegetables over brown rice",
				true, 3.99));

		dinerMenu.add(
				new MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89));

		dinerMenu.add(dessertMenu);
	}

	private void pancakeCreateMenus() {
		pancakeHouseMenu
				.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99));

		pancakeHouseMenu
				.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
		pancakeHouseMenu.add(new MenuItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries, and blueberry syrup", true, 3.49));
		pancakeHouseMenu
				.add(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59));
	}

	@Test
	public void executeTestDriveForcompositepatter() {
		waitressObj.printVegetarianMenu();
		waitressObj.printMenu();
	}

	@Test
	public void checkIfWaitressCanBeCreated() {
		assertNotNull(waitressObj);
	}

	@Test
	public void checkIfMenuCanBeCreated() {
		assertNotNull(menuObj);
	}

	@Test
	public void checkIfMenuItemCanBeCreated() {
		assertNotNull(menuItemObj);
	}

	@Test
	public void checkIfNullIteratorCanBeCreated() {
		assertNotNull(nullIteratorObj);
	}

	@Test
	public void checkIfCompositeIteratorCanBeCreated() {
		assertNotNull(compositeIteratorObj);
	}
}
