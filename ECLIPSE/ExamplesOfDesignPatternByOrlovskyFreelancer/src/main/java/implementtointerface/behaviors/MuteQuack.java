package implementtointerface.behaviors;

import implementtointerface.model.QuackableBehavior;

public class MuteQuack implements QuackableBehavior {

	@Override
	public String quack() {
		// TODO Auto-generated method stub
		return "do nothing -can't quack!";
	}

}
