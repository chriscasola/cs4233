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
 * This package consists of a navigation system. It costs
 * $2000 to add this package.
 *
 * @author Chris Casola
 * @version Feb 19, 2013
 */
public class NavigationSystem extends CarPackage {

	/**
	 * Constructs a new navigation system package
	 * 
	 * @param c the CarComponent to add this package to
	 */
	public NavigationSystem(CarComponent c) {
		super(c, 2000.0, "Navigation System");
		myFeatures.add("In-dash navigation system");
	}
}

