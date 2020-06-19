package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import builderpatternexample.CityVacationBuilder;
import builderpatternexample.Hotel;
import builderpatternexample.OutdoorsVacationBuilder;
import builderpatternexample.Reservation;
import builderpatternexample.Tent;
import builderpatternexample.Vacation;
import builderpatternexample.VacationBuilder;

class BuilderTest {

	private Reservation reservationObj;
	private Hotel hotelObj;
	private Tent tentObj;
	private Vacation vacationObj;
	private OutdoorsVacationBuilder outdoorsVacationBuilderObj;
	private CityVacationBuilder cityVacationBuilderObj;

	@BeforeEach
	public void setUp() {
		reservationObj = new Reservation();
		hotelObj = new Hotel();
		tentObj = new Tent();
		vacationObj = new Vacation();
		outdoorsVacationBuilderObj = new OutdoorsVacationBuilder();
		cityVacationBuilderObj = new CityVacationBuilder();
	}

	@Test
	public void checkIfAReservationObjCanBeCreated() {
		assertNotNull(reservationObj, "Reservation cant be created!");
	}

	@Test
	public void checkIfAHotelObjCanBeCreated() {
		assertNotNull(hotelObj, "Hotel cant be created!");
	}

	@Test
	public void checkIfATentObjCanBeCreated() {
		assertNotNull(tentObj, "Tent cant be created!");
	}

	@Test
	public void checkIfAVacationObjCanBeCreated() {
		assertNotNull(vacationObj, "Vacation cant be created!");
	}

	@Test
	public void checkIfAOutdoorsVacationBuilderObjCanBeCreated() {
		assertNotNull(outdoorsVacationBuilderObj, "VacationBuilder cant be created!");
	}

	@Test
	public void checkIfACityVacationBuilderObjCanBeCreated() {
		assertNotNull(cityVacationBuilderObj, "CityVacationBuilder cant be created!");
	}

	@Test
	public void showTheVocationBuildingProcess() {
		vacationObj = outdoorsVacationBuilderObj.addAccommodation("Two person tent", 2020, 7, 1, 5, 34)
				.addEvent("Beach").addAccommodation("Two person tent").addEvent("Mountains").getVacation();
		System.out.println(vacationObj);

		VacationBuilder cityVacationBuilder = cityVacationBuilderObj;
		vacationObj = cityVacationBuilder.addAccommodation("Grand Facadian", 2020, 8, 1, 5, 0)
				.addAccommodation("Hotel Commander", 2020, 8, 6, 2, 0).addEvent("Cirque du Soleil").getVacation();
		System.out.println(vacationObj);
	}
}
