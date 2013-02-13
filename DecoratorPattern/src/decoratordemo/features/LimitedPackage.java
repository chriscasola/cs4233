package decoratordemo.features;

import decoratordemo.common.CarComponent;
import decoratordemo.common.CarFeature;

public class LimitedPackage extends CarFeature {

	public LimitedPackage(CarComponent c) {
		super(c, 1500.0, "Limited Package");
		myFeatures.add("Moonroof");
		myFeatures.add("Heated cloth seats");
		myFeatures.add("iPod Connection");
	}
}
