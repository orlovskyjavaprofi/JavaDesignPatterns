package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adapterexample.Duck;
import adapterexample.DuckAdapter;
import adapterexample.MallardDuck;
import adapterexample.Turkey;
import adapterexample.TurkeyAdapter;
import adapterexample.WildTurkey;

class AdapterTest {

	private TurkeyAdapter turkeyAdapterObj;
	private Turkey turkeyInterface;
	private DuckAdapter duckAdapterObj;
	private Duck duckInterface;
	private MallardDuck mallardDuckObj;
	private WildTurkey wildTurkeyObj;

	@BeforeEach
	public void setUp() {
		turkeyAdapterObj = new TurkeyAdapter(turkeyInterface);
		duckAdapterObj = new DuckAdapter(duckInterface);
		mallardDuckObj = new MallardDuck();
		wildTurkeyObj = new WildTurkey();
	}

	@Test
	public void checkIfTurkeyAdpaterCanBeCreated() {
		assertNotNull(turkeyAdapterObj, "Turkey adapter cant be created!");
	}

	@Test
	public void checkIfDuckAdpaterCanBeCreated() {
		assertNotNull(duckAdapterObj, "Duck adapter cant be created!");
	}

	@Test
	public void checkIfMallardDuckCanBeCreated() {
		assertNotNull(mallardDuckObj, "Duck MallardDuck cant be created!");
	}

	@Test
	public void checkIfWildTurkeyCanBeCreated() {
		assertNotNull(wildTurkeyObj, "Duck WildTurkey cant be created!");
	}

	@Test
	public void executeDuckAndTurkeyAdapters() {
		duckInterface = mallardDuckObj;
		turkeyInterface = wildTurkeyObj;
		Duck turkeyAdapter = new TurkeyAdapter(turkeyInterface);
		System.out.println("The Turkey says...");
		turkeyInterface.gobble();
		turkeyInterface.fly();

		System.out.println("\nThe Duck says...");
		testDuck(duckInterface);

		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(turkeyAdapter);

	}

	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
