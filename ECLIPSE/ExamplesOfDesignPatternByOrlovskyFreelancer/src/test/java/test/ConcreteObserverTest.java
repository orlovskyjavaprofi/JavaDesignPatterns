package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import observerexample.ConcreteObserver;

class ConcreteObserverTest {
	private ConcreteObserver observerObj;

	@BeforeEach
	void setUp() {
		observerObj = new ConcreteObserver();
	}

	@Test
	void testIfObserverObjCanBeCreated() {
		assertNotNull(observerObj, "observer object has reference to null");
	}



}
