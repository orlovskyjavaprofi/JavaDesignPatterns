package test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Proxy;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import proxypatternexample.NonOwnerInvocationHandler;
import proxypatternexample.OwnerInvocationHandler;
import proxypatternexample.PersonBean;
import proxypatternexample.PersonBeanImpl;

class ProxyPatternTest {
	private OwnerInvocationHandler ownerInvocationHandler;
	private PersonBean person;
	private PersonBeanImpl personBeanImplObj;
	private NonOwnerInvocationHandler nonOwnerInvocationHandlerObj;
	private HashMap<String, PersonBean> datingDB;

	@BeforeEach
	public void setUp() {
		ownerInvocationHandler = new OwnerInvocationHandler(person);
		nonOwnerInvocationHandlerObj = new NonOwnerInvocationHandler(person);
		personBeanImplObj = new PersonBeanImpl();
		datingDB = new HashMap<String, PersonBean>();
		initializeDatabase();
	}

	@Test
	public void executeTestDrive() {
		person = getPersonFromDatabase("Joe Javabean");
		PersonBean ownerProxy = getOwnerProxy(person);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");
		tryToSetRatingTo10(ownerProxy);
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

		PersonBean nonOwnerProxy = getNonOwnerProxy(person);
		System.out.println("Name is " + nonOwnerProxy.getName());
		setInterest(nonOwnerProxy);
		nonOwnerProxy.setHotOrNotRating(3);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
	}

	private void setInterest(PersonBean nonOwnerProxy) {
		try {
			nonOwnerProxy.setInterests("bowling, Go");
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy");
		}
	}

	private void tryToSetRatingTo10(PersonBean ownerProxy) {
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");
		}
	}

	void initializeDatabase() {
		PersonBean joe = new PersonBeanImpl();
		joe.setName("Joe Javabean");
		joe.setInterests("cars, computers, music");
		joe.setHotOrNotRating(7);
		datingDB.put(joe.getName(), joe);

		PersonBean kelly = new PersonBeanImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInterests("ebay, movies, music");
		kelly.setHotOrNotRating(6);
		datingDB.put(kelly.getName(), kelly);
	}

	PersonBean getPersonFromDatabase(String name) {
		return (PersonBean) datingDB.get(name);
	}

	PersonBean getOwnerProxy(PersonBean person) {

		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
	}

	PersonBean getNonOwnerProxy(PersonBean person) {

		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
	}

	@Test
	public void checkIfOwnerInvocationHandlercanBeCreated() {
		assertNotNull(ownerInvocationHandler);
	}

	@Test
	public void checkIfPersonBeanImplcanBeCreated() {
		assertNotNull(personBeanImplObj);
	}

	@Test
	public void checkIfNonOwnerInvocationHandlerBeCreated() {
		assertNotNull(nonOwnerInvocationHandlerObj);
	}


}
