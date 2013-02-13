package decoratordemo.common;

import java.util.HashSet;
import java.util.Set;


public abstract class CarFeature implements CarComponent {

	protected final CarComponent innerCarComponent;
	
	protected final Set<String> myFeatures;
	
	protected final Double cost;
	
	protected final String featureName;
	
	protected CarFeature(CarComponent c, Double cost, String featureName) {
		innerCarComponent = c;
		myFeatures = new HashSet<String>();
		this.cost = cost;
		this.featureName = featureName;
	}
	
	@Override
	public Set<String> getComponentNames() {
		Set<String> names = new HashSet<String>();
		names.addAll(innerCarComponent.getComponentNames());
		names.add(featureName);
		return names;
	}
	
	@Override
	public Double getCost() {
		return innerCarComponent.getCost() + cost;
	}
	
	@Override
	public Set<String> getFeatures() {
		Set<String> features = new HashSet<String>();
		features.addAll(innerCarComponent.getFeatures());
		features.addAll(myFeatures);
		return features;
	}
}
