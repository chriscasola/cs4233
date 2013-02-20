/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package decoratordemo.common;

import java.util.HashSet;
import java.util.Set;

/**
 * This abstract class represents a package that can be added to a car. Each
 * package contains a number of features and has a cost.
 *
 * @author Chris Casola
 * @version Feb 19, 2013
 */
public abstract class CarPackage implements CarComponent {

	protected final CarComponent innerCarComponent;
	protected final Set<String> myFeatures;
	protected final Double cost;
	protected final String packageName;
	
	/**
	 * Constructs a new car package. This constructor is only called by
	 * child classes.
	 * 
	 * @param c the CarComponent this package should be applied to
	 * @param cost the cost of this package
	 * @param packageName the name of this package
	 */
	protected CarPackage(CarComponent c, Double cost, String packageName) {
		innerCarComponent = c;
		myFeatures = new HashSet<String>();
		this.cost = cost;
		this.packageName = packageName;
	}
	
	/* 
	 * @see decoratordemo.common.CarComponent#getComponentNames()
	 */
	@Override
	public Set<String> getComponentNames() {
		final Set<String> names = new HashSet<String>();
		names.addAll(innerCarComponent.getComponentNames());
		names.add(packageName);
		return names;
	}
	
	/* 
	 * @see decoratordemo.common.CarComponent#getCost()
	 */
	@Override
	public Double getCost() {
		return innerCarComponent.getCost() + cost;
	}
	
	/* 
	 * @see decoratordemo.common.CarComponent#getFeatures()
	 */
	@Override
	public Set<String> getFeatures() {
		final Set<String> features = new HashSet<String>();
		features.addAll(innerCarComponent.getFeatures());
		features.addAll(myFeatures);
		return features;
	}
}
