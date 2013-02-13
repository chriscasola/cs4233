package decoratordemo.features;

import decoratordemo.common.CarComponent;
import decoratordemo.common.CarFeature;

public class BasePackage extends CarFeature {

	public BasePackage(CarComponent c) {
		super(c, 500.0, "Base Package");
		myFeatures.add("Power windows");
		myFeatures.add("Power locks");
		myFeatures.add("Keyless entry");
	}
}
