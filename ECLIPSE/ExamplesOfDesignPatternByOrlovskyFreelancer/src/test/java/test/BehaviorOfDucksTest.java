package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implementtointerface.behaviors.FlyNoWay;
import implementtointerface.behaviors.FlyWithWings;
import implementtointerface.behaviors.MuteQuack;
import implementtointerface.behaviors.Quack;
import implementtointerface.behaviors.Squeak;
import implementtointerface.model.Animal;

class BehaviorOfDucksTest {
	private Animal duck;

	@BeforeEach
	void setUp() {
		duck = new Animal();
	}

	@Test
	void testIfAnimalCanBeCreated() {
		assertNotNull(duck, "duck animal has reference to null");
	}

	@Test
	void testIfAnimalDuckCanFlyWithWingsBehavior() {
		FlyWithWings duckBehaviorFlyWithWings = new FlyWithWings();
		duck = new Animal(duckBehaviorFlyWithWings);

		assertEquals(duck.getFlyBehavior().fly(), "flying", "fly with wings behavior at duck isnt available!");
	}

	@Test
	void testIfAnimalDuckCantFlyBehavior() {
		FlyNoWay duckBehaviorFlyNoWay = new FlyNoWay();
		duck = new Animal(duckBehaviorFlyNoWay);

		assertEquals(duck.getFlyBehavior().fly(), "can't fly!", "no fly behavior at duck isnt available!");
	}

	@Test
	void testIfAnimalDuckCanQuackBehavior() {
		Quack duckBehaviorQuack = new Quack();
		duck = new Animal(duckBehaviorQuack);
		assertEquals(duck.getQuackBehavior().quack(), "duck quacking!", "no quacking behavior at duck isnt available!");
	}

	@Test
	void testIfAnimalDuckCanSqueakBehavior() {
		Squeak duckBehavior = new Squeak();

		duck = new Animal(duckBehavior);
		assertEquals(duck.getQuackBehavior().quack(), "rubber duck quacking!",
				"no rubber duck quacking behavior at duck isnt available!");
	}

	@Test
	void testIfAnimalDuckCanMuteQuackBehavior() {
		MuteQuack duckBehavior = new MuteQuack();
		duck = new Animal(duckBehavior);
		assertEquals(duck.getQuackBehavior().quack(), "do nothing -can't quack!",
				"no mute quacking behavior at duck isnt available!");
	}
}
