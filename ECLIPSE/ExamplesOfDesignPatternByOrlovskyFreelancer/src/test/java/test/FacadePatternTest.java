package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import facadepatternexample.Amplifier;
import facadepatternexample.CdPlayer;
import facadepatternexample.DvdPlayer;
import facadepatternexample.HomeTheaterFacade;
import facadepatternexample.PopcornPopper;
import facadepatternexample.Projector;
import facadepatternexample.Screen;
import facadepatternexample.TheaterLights;
import facadepatternexample.Tuner;

class FacadePatternTest {

	private Amplifier amplifierObj;
	private Tuner tunerObj;
	private DvdPlayer dvdPlayerObj;
	private CdPlayer cdPlayerObj;
	private PopcornPopper popcornPopperObj;
	private Projector projectorObj;
	private Screen screenObj;
	private TheaterLights theaterLightsObj;
	private HomeTheaterFacade homeTheaterFacade;

	@BeforeEach
	public void setUP() {
		amplifierObj = new Amplifier("Cool amplifier");
		tunerObj = new Tuner("Cool tuner", amplifierObj);
		dvdPlayerObj = new DvdPlayer("Cool dvd player", amplifierObj);
		cdPlayerObj = new CdPlayer("CD player", amplifierObj);
		popcornPopperObj = new PopcornPopper("Popcorn popper");
		projectorObj = new Projector("Cool projector", dvdPlayerObj);
		screenObj = new Screen("Beatiful screen");
		theaterLightsObj = new TheaterLights("Light!");
		homeTheaterFacade = new HomeTheaterFacade(amplifierObj, tunerObj, dvdPlayerObj, cdPlayerObj,
				projectorObj,
				screenObj, theaterLightsObj, popcornPopperObj);
	}

	@Test
	public void executeTestDriveForFacadePatter() {

		homeTheaterFacade.watchMovie("Dead pool!");
		homeTheaterFacade.endMovie();
	}

	@Test
	public void checkIfTheaterFacadeCanBeCreated() {
		assertNotNull(homeTheaterFacade);
	}

	@Test
	public void checkIfLightsCanBeCreated() {
		assertNotNull(theaterLightsObj);
	}

	@Test
	public void checkIfScreenCanBeCreated() {
		assertNotNull(screenObj);
	}

	@Test
	public void checkIfProjectorCanBeCreated() {
		assertNotNull(projectorObj);
	}

	@Test
	public void checkIfPopperCanBeCreated() {
		assertNotNull(popcornPopperObj);
	}

	@Test
	public void checkIfAmplifierCanBeCreated() {
		assertNotNull(amplifierObj);
	}

	@Test
	public void checkIfTunerCanBeCreated() {
		assertNotNull(tunerObj);
	}

	@Test
	public void checkIfDvdPlayerCanBeCreated() {
		assertNotNull(cdPlayerObj);
	}

	@Test
	public void checkIfCDPlayerCanBeCreated() {
		assertNotNull(dvdPlayerObj);
	}

}
