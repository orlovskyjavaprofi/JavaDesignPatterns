package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bridgepatternexample.GenericRemote;
import bridgepatternexample.LG;
import bridgepatternexample.Sony;
import bridgepatternexample.SpecialRemote;
import bridgepatternexample.TVFactory;

class BrdigePatternTest {
	private TVFactory tvFactoryObj;
	private Sony sonyTVObj;
	private LG lgTVObj;
	private GenericRemote genericRemoteObj;
	private SpecialRemote specialRemoteObj;

	@BeforeEach
	public void setUp() {
		tvFactoryObj = new TVFactory();
		sonyTVObj = new Sony();
		lgTVObj = new LG();
		genericRemoteObj = new GenericRemote(tvFactoryObj);
		specialRemoteObj = new SpecialRemote(tvFactoryObj);

	}

	@Test
	public void checkIfTvFactoryCanBeCreated() {
		assertNotNull(tvFactoryObj);
	}

	@Test
	public void checkIfSonyObjCanBeCreated() {
		assertNotNull(sonyTVObj);
	}

	@Test
	public void checkIfLGObjCanBeCreated() {
		assertNotNull(lgTVObj);
	}

	@Test
	public void checkIfGenericRemoteObjCanBeCreated() {
		assertNotNull(genericRemoteObj);
	}

	@Test
	public void checkIfSpecialRemoteObjCanBeCreated() {
		assertNotNull(specialRemoteObj);
	}

	@Test
	public void checkThatTvFactoryCanProduceLG() {

		try {
			assertTrue(tvFactoryObj.getTV("LG") instanceof LG, "tv factory can produce Lg tv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void checkThatTvFactoryCanProduceSony() {

		try {
			assertTrue(tvFactoryObj.getTV("Sony") instanceof Sony, "tv factory can produce Sony tv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void showThatAllTvsWorking() {
		System.out.println("Connect your remote to the Sony TV");
		specialRemoteObj.setTV("Sony");
		specialRemoteObj.on();
		specialRemoteObj.up();
		specialRemoteObj.down();
		specialRemoteObj.off();
		System.out.println("\n\nConnect your remote to the LG TV");
		specialRemoteObj.setTV("LG");
		specialRemoteObj.on();
		specialRemoteObj.up();
		specialRemoteObj.down();
		specialRemoteObj.off();
	}

}
