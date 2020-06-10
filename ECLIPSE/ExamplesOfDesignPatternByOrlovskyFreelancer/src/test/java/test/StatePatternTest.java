package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import statepatternexample.GumballMachine;
import statepatternexample.HasQuarterState;
import statepatternexample.NoQuarterState;
import statepatternexample.SoldOutState;
import statepatternexample.SoldState;
import statepatternexample.WinnerState;

class StatePatternTest {
	private WinnerState winnerStateObj;
	private GumballMachine gumballMachineObj;
	private SoldState soldStateObj;
	private SoldOutState soldOutStateObj;
	private NoQuarterState noQuarterStateObj;
	private HasQuarterState hasQuarterStateObj;

	@BeforeEach
	public void setUp() {

		gumballMachineObj = new GumballMachine(100);
		winnerStateObj = new WinnerState(gumballMachineObj);
		soldStateObj = new SoldState(gumballMachineObj);
		soldOutStateObj = new SoldOutState(gumballMachineObj);
		noQuarterStateObj = new NoQuarterState(gumballMachineObj);
		hasQuarterStateObj = new HasQuarterState(gumballMachineObj);

	}

	@Test
	public void executeTestDriveForGumballMachine() {

		for (int i = 0; i <= 46; i++) {
			insertQuarterTurnCrank2Times();
		}

	}

	private void insertQuarterTurnCrank2Times() {
		System.out.println(gumballMachineObj);
		gumballMachineObj.insertQuarter();
		gumballMachineObj.turnCrank();
		gumballMachineObj.insertQuarter();
		gumballMachineObj.turnCrank();
		System.out.println(gumballMachineObj);
	}

	@Test
	public void checkIfHasQuarterStateCanBeCreated() {
		assertNotNull(hasQuarterStateObj);
	}

	@Test
	public void checkIfNoQuarterStateCanBeCreated() {
		assertNotNull(noQuarterStateObj);
	}

	@Test
	public void checkIfWinnerStateCanBeCreated() {
		assertNotNull(winnerStateObj);
	}

	@Test
	public void checkIfGumballMachineStateCanBeCreated() {
		assertNotNull(gumballMachineObj);
	}

	@Test
	public void checkIfSoldStateStateCanBeCreated() {
		assertNotNull(soldStateObj);
	}

	@Test
	public void checkIfSoldOutStateCanBeCreated() {
		assertNotNull(soldOutStateObj);
	}


}
