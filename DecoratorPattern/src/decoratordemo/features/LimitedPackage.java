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
 * This is the limited package for a car. It contains the following
 * features: moonroof, heated cloth seats, and iPod connection. This
 * packages costs $1500.
 *
 * @author Chris Casola
 * @version Feb 19, 2013
 */
public class LimitedPackage extends CarPackage {

	/**
	 * Constructs a new limited package
	 * 
	 * @param c the CarComponent to add this package to
	 */
	public LimitedPackage(CarComponent c) {
		super(c, 1500.0, "Limited Package");
		myFeatures.add("Moonroof");
		myFeatures.add("Heated cloth seats");
		myFeatures.add("iPod Connection");
	}
}
