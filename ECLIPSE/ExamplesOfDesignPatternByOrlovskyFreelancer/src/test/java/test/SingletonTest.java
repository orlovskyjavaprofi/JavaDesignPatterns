package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import singletonexample.Singleton;

class SingletonTest {
	private Singleton singletonObj;

	@BeforeEach
	public void setUp() {
		singletonObj = Singleton.getInstance();
	}

	@Test
	public void checkIfSingletonCanBeCreated() {
		assertTrue(singletonObj instanceof Singleton);
	}

}
