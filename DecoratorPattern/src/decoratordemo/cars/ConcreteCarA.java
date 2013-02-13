package decoratordemo.cars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import decoratordemo.common.CarComponent;

public class ConcreteCarA implements CarComponent {

	private final Double cost = 15000.00;
	
	@Override
	public Set<String> getComponentNames() {
		String[] name = {"Car A"};
		return new HashSet<String>(Arrays.asList(name));
	}

	@Override
	public Double getCost() {
		return cost;
	}

	@Override
	public Set<String> getFeatures() {
		return new HashSet<String>();
	}
}
