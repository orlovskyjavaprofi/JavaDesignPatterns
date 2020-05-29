package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import decoratorexample.Beverage;
import decoratorexample.DarkRoast;
import decoratorexample.Decaf;
import decoratorexample.Espresso;
import decoratorexample.HouseBlend;
import decoratorexample.Mocha;
import decoratorexample.Soy;
import decoratorexample.Whip;

class DecoratorTest {
	private Espresso espressoOb;
	private HouseBlend hoseblendOb;
	private DarkRoast darkRoastOb;
	private Decaf decafOb;
	private Mocha mochaobj;
	private Beverage beverage;
	private Whip whipObj;
	private Soy soyObj;

	@BeforeEach
	void setUp() {
		espressoOb = new Espresso();
		hoseblendOb = new HouseBlend();
		darkRoastOb = new DarkRoast();
		decafOb = new Decaf();
		mochaobj = new Mocha(beverage);
		whipObj = new Whip(beverage);
		soyObj = new Soy(beverage);
	}
	@Test
	public void canCreateWhipObj() {
		assertNotNull(whipObj, "Can't create whip obj");
	}

	@Test
	public void canCreateSoyObj() {
		assertNotNull(soyObj, "Can't create soy obj");
	}

	@Test
	public void canCreateEspressoObj() {
		assertNotNull(espressoOb, "Can't create espresso obj");
	}
	@Test
	public void canCreateHouseBlendObj() {
		assertNotNull(hoseblendOb, "Can't create house blend obj");
	}

	@Test
	public void checkExpressoCosts() {
		double expectedResult = 1.99;

		assertEquals(expectedResult, espressoOb.cost(), "the espresso costs are invalid!");
	}

	@Test
	public void checkHouseBlendsCosts() {
		double expectedResult = 0.89;

		assertEquals(expectedResult, hoseblendOb.cost(), "the house blend costs are invalid!");
	}

	@Test
	public void checkDarkRoastCosts() {
		double expectedResult = 0.99;

		assertEquals(expectedResult, darkRoastOb.cost(), "the dark roast costs are invalid!");
	}

	@Test
	public void checkDecafCosts() {
		double expectedResult = 1.05;

		assertEquals(expectedResult, decafOb.cost(), "the dark roast costs are invalid!");
	}

	@Test
	public void checkThatMochaReturnDescriptionOfBeverageDarkRoast() {
		String expectedResult = "Dark Roast Coffee, Mocha";
		mochaobj = new Mocha(darkRoastOb);

		assertEquals(expectedResult, mochaobj.getDescription(),
				"the expected moca descriptio for dark roast was not produced");
	}

	@Test
	public void checkThatMochaCostforDarkRoastAdded() {
		double expectedResult = 1.19;
		mochaobj = new Mocha(darkRoastOb);

		assertEquals(expectedResult, mochaobj.cost(), "the expected moca costs for dark roast was not produced");
	}

	@Test
	public void checkThatMochaReturnDescriptionOfBeverageDeacaf() {
		String expectedResult = "Decaf Coffee, Mocha";
		mochaobj = new Mocha(decafOb);

		assertEquals(expectedResult,
				mochaobj.getDescription(),
				"the expected moca descriptio for decaf was not produced");
	}

	@Test
	public void checkThatMochaReturnDescriptionOfBeverageEspresso() {
		String expectedResult = "Espresso, Mocha";
		mochaobj = new Mocha(espressoOb);

		assertEquals(expectedResult, mochaobj
				.getDescription(),
				"the expected moca descriptio for Espresso was not produced");
	}

	@Test
	public void checkThatMochaCostforEspressoAdded() {
		double expectedResult = 2.19;
		mochaobj = new Mocha(espressoOb);

		assertEquals(expectedResult, mochaobj.cost(), "the expected moca costs for Espresso was not produced");
	}

	@Test
	public void checkThatMochaReturnDescriptionOfBeverageHouseBlend() {
		String expectedResult = "House Blend Coffee, Mocha";
		mochaobj = new Mocha(hoseblendOb);

		assertEquals(expectedResult, mochaobj.getDescription(),
				"the expected moca descriptio for House Blend was not produced");
	}

	@Test
	public void checkThatMochaCostforHouseBlendAdded() {
		double expectedResult = 1.09;
		mochaobj = new Mocha(hoseblendOb);

		assertEquals(expectedResult, mochaobj.cost(), "the expected moca costs for House Blend was not produced");
	}

	// Whip tests
	@Test
	public void checkThatWhipReturnDescriptionOfBeverageDecaf() {
		String expectedResult = "Decaf Coffee, Whip";
		whipObj = new Whip(decafOb);

		assertEquals(expectedResult, whipObj.getDescription(),
				"the expected whip descriptio for Espresso was not produced");
	}

	@Test
	public void checkThatWhipCostforDecafAdded() {
		double expectedResult = 1.1500000000000001;
		whipObj = new Whip(decafOb);
		assertEquals(expectedResult, whipObj.cost(), "the expected whip costs for decaf was not produced");
	}

	@Test
	public void checkThatWhipReturnDescriptionOfBeverageEspresso() {
		String expectedResult = "Espresso, Whip";

		whipObj = new Whip(espressoOb);
		assertEquals(expectedResult,
				whipObj.getDescription(), "the expected whip descriptio for Espresso was not produced");
	}

	@Test
	public void checkThatWhipCostforEspressoAdded() {
		double expectedResult = 2.09;

		whipObj = new Whip(espressoOb);
		assertEquals(expectedResult, whipObj.cost(), "the expected whip costs for Espresso was not produced");
	}

	@Test
	public void checkThatWhipReturnDescriptionOfBeverageHouseBlend() {
		String expectedResult = "House Blend Coffee, Whip";
		whipObj = new Whip(hoseblendOb);
		assertEquals(expectedResult, whipObj.getDescription(),
				"the expected whip descriptio for House Blend was not produced");
	}

	@Test
	public void checkThatWhipCostforHouseBlendAdded() {
		double expectedResult = 0.99;
		whipObj = new Whip(hoseblendOb);
		assertEquals(expectedResult, whipObj.cost(), "the expected whip costs for House Blend was not produced");
	}

	// Soy
	@Test
	public void checkThatSoyReturnDescriptionOfBeverageDecaf() {
		String expectedResult = "Decaf Coffee, Soy";

		soyObj = new Soy(decafOb);
		assertEquals(expectedResult, soyObj.getDescription(),
				"the expected soy descriptio for Espresso was not produced");
	}

	@Test
	public void checkThatSoyCostforDecafAdded() {
		double expectedResult = 1.2;

		soyObj = new Soy(decafOb);
		assertEquals(expectedResult, soyObj.cost(), "the expected soy costs for decaf was not produced");
	}

	@Test
	public void checkThatSoyReturnDescriptionOfBeverageEspresso() {
		String expectedResult = "Espresso, Soy";

		soyObj = new Soy(espressoOb);
		assertEquals(expectedResult, soyObj.getDescription(),
				"the expected soy descriptio for Espresso was not produced");
	}

	@Test
	public void checkThatSoyCostforEspressoAdded() {
		double expectedResult = 2.14;

		soyObj = new Soy(espressoOb);
		assertEquals(expectedResult, soyObj.cost(), "the expected soy costs for Espresso was not produced");
	}

	@Test
	public void checkThatSoyReturnDescriptionOfBeverageHouseBlend() {
		String expectedResult = "House Blend Coffee, Soy";

		soyObj = new Soy(hoseblendOb);
		assertEquals(expectedResult, soyObj.getDescription(),
				"the expected soy descriptio for House Blend was not produced");
	}

	@Test
	public void checkThatSoyCostforHouseBlendAdded() {
		double expectedResult = 1.04;
		soyObj = new Soy(hoseblendOb);
		assertEquals(expectedResult, soyObj.cost(), "the expected soy costs for House Blend was not produced");
	}
}
