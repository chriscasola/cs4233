/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package decoratordemo.cars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import decoratordemo.common.CarComponent;

/**
 * A model B car
 *
 * @author Chris Casola
 * @version Feb 19, 2013
 */
public class ConcreteCarB implements CarComponent {
	
	private final Double cost = 25000.00;

	/* 
	 * @see decoratordemo.common.CarComponent#getComponentNames()
	 */
	@Override
	public Set<String> getComponentNames() {
		final String[] name = {"Car B"};
		return new HashSet<String>(Arrays.asList(name));
	}

	/* 
	 * @see decoratordemo.common.CarComponent#getFeatures()
	 */
	@Override
	public Set<String> getFeatures() {
		return new HashSet<String>();
	}

	/* 
	 * @see decoratordemo.common.CarComponent#getCost()
	 */
	@Override
	public Double getCost() {
		return cost;
	}

}
