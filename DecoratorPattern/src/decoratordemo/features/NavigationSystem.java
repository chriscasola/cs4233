package decoratordemo.features;

import decoratordemo.common.CarComponent;
import decoratordemo.common.CarFeature;

public class NavigationSystem extends CarFeature {

	public NavigationSystem(CarComponent c) {
		super(c, 2000.0, "Navigation System");
		myFeatures.add("In-dash navigation system");
	}
}

