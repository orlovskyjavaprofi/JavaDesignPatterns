package model;

public class Animal {

	private FlyableBehavior duckFlyBehavior;
	private QuackableBehavior duckQuackableBehavior;

	public Animal() {

	}

	public Animal(QuackableBehavior duckQuackBehavior) {
		duckQuackableBehavior = duckQuackBehavior;
	}

	public Animal(FlyableBehavior duckBehavior) {
		duckFlyBehavior = duckBehavior;
	}

	public FlyableBehavior getFlyBehavior() {
		return duckFlyBehavior;
	}

	public QuackableBehavior getQuackBehavior() {
		return duckQuackableBehavior;
	}

}
