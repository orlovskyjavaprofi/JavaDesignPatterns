package implementtointerface.behaviors;

import implementtointerface.model.FlyableBehavior;

public class FlyNoWay implements FlyableBehavior {

	@Override
	public String fly() {

		return "can't fly!";
	}

}
