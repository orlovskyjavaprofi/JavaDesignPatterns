package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import templatepatternexample.Coffee;
import templatepatternexample.CoffeeWithHook;
import templatepatternexample.Tea;
import templatepatternexample.TeaWithHook;

class TemplatePatternTest {

	private Coffee coffeObj;
	private Tea teaObj;
	TeaWithHook teaHook = new TeaWithHook();
	CoffeeWithHook coffeeHook = new CoffeeWithHook();

	@BeforeEach
	public void setUp() {
		coffeObj = new Coffee();
		teaObj = new Tea();
		teaHook = new TeaWithHook();
		coffeeHook = new CoffeeWithHook();
	}

	@Test
	public void testIfCoffeeWithHoolObjCanBeCreated() {
		assertNotNull(coffeeHook, "Coffee with hook  cant be instatiated!");
	}

	@Test
	public void testIfTeaWithHookObjCanBeCreated() {
		assertNotNull(teaHook, "Tea with hook  cant be instatiated!");
	}

	@Test
	public void testIfCoffeeObjCanBeCreated() {
		assertNotNull(coffeObj, "Coffee object cant be instatiated!");
	}

	@Test
	public void testIfTeaObjCanBeCreated() {
		assertNotNull(teaObj, "Tea object cant be instatiated!");
	}

	@Test
	public void executeTestDriveForTemplateMethodExample() {
		System.out.println("\nMaking tea...");
		teaObj.prepareRecipe();

		System.out.println("\nMaking coffee...");
		coffeObj.prepareRecipe();

		System.out.println("\nMaking tea...");
		teaHook.prepareRecipe();

		System.out.println("\nMaking coffee...");
		coffeeHook.prepareRecipe();
	}
}
