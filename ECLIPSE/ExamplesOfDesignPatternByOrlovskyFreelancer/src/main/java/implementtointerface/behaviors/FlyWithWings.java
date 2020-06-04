package implementtointerface.behaviors;

import implementtointerface.model.FlyableBehavior;

public class FlyWithWings implements FlyableBehavior {

	@Override
	public String fly() {

		return "flying";
	}

}
