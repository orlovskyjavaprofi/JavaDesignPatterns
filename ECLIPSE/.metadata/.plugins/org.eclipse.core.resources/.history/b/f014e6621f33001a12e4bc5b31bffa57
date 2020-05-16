package theater;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Booking;
import model.Seat;

class SinglebookingTest {

	Booking bookingobj;
	
	@BeforeEach
	void setup() {
	    bookingobj = new Booking();
	}
	
	@Test
	void checkIfSinglebookingexist() {
		assertNotNull(bookingobj);
	}
	
	@Test
	void reserveSingleSeat() {
		List<Seat> seats = bookingobj.reserve( 1 );
		assertTrue( seats.size() == 1 );
	}

}
