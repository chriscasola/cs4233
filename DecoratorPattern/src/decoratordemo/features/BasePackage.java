/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package decoratordemo.features;

import decoratordemo.common.CarComponent;
import decoratordemo.common.CarPackage;

/**
 * This is the base package for a car. It contains the following
 * features: power windows, power locks, and keyless entry. It
 * costs $500 to add this package.
 *
 * @author Chris Casola
 * @version Feb 19, 2013
 */
public class BasePackage extends CarPackage {

	/**
	 * Constructs a new base package
	 * 
	 * @param c the CarComponent to add this package to
	 */
	public BasePackage(CarComponent c) {
		super(c, 500.0, "Base Package");
		myFeatures.add("Power windows");
		myFeatures.add("Power locks");
		myFeatures.add("Keyless entry");
	}
}
