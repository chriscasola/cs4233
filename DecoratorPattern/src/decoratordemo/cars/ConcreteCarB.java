package decoratordemo.cars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import decoratordemo.common.CarComponent;

public class ConcreteCarB implements CarComponent {
	
	private final Double cost = 25000.00;

	@Override
	public Set<String> getComponentNames() {
		String[] name = {"Car B"};
		return new HashSet<String>(Arrays.asList(name));
	}

	@Override
	public Set<String> getFeatures() {
		return new HashSet<String>();
	}

	@Override
	public Double getCost() {
		return cost;
	}

}
