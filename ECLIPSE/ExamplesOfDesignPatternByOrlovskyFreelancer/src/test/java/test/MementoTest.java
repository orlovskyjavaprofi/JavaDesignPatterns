package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mementoexample.CareTaker;
import mementoexample.Memento;
import mementoexample.Originator;

class MementoTest {
	private Memento mementoObj;
	private Originator originatorObj;
	private CareTaker careTakerObj;

	@BeforeEach
	public void setUp() {
		mementoObj = new Memento("test");
		originatorObj = new Originator();
		careTakerObj = new CareTaker();
	}

	@Test
	void checkIfMementoCanBeCreated() {
		assertNotNull(mementoObj);
	}

	@Test
	void checkIfOrganizatorCanBeCreated() {
		assertNotNull(originatorObj);
	}

	@Test
	void checkIfCareTakerCanBeCreated() {
		assertNotNull(careTakerObj);
	}

	@Test
	void showUsageOfMemento() {
		originatorObj.setState("State #1");
		System.out.println("Current State: " + originatorObj.getState());
		originatorObj.setState("State #2");
		System.out.println("Current State: " + originatorObj.getState() + " saving it to momento!");
		careTakerObj.add(originatorObj.saveStateToMemento());

		originatorObj.setState("State #3");
		System.out.println("Current State: " + originatorObj.getState() + " saving it to momento!");
		careTakerObj.add(originatorObj.saveStateToMemento());

		originatorObj.setState("State #4");
		System.out.println("Current State: " + originatorObj.getState() + " geting it from momento!\n");
		System.out.println("State from momento: " + originatorObj.getState());

		originatorObj.getStateFromMemento(careTakerObj.get(0));
		System.out.println("First saved State: " + originatorObj.getState());
		originatorObj.getStateFromMemento(careTakerObj.get(1));
		System.out.println("Second saved State: " + originatorObj.getState());
	}

}
