package decoratordemo.common;

import java.util.Set;

public interface CarComponent {

	public Set<String> getComponentNames();
	
	public Set<String> getFeatures();
	
	public Double getCost();
}
