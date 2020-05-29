package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import observerexample.ConcreteSubject;

class ConcreteSubjectTest {
	private ConcreteSubject concreteSubjectObj;

	@BeforeEach
	void setUp() {
		concreteSubjectObj = new ConcreteSubject();
	}

	@Test
	public void testIfconcreteSubjectObjCanbeCreated() {
		assertNotNull(concreteSubjectObj);
	}


}
