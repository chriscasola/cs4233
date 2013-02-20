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

import java.util.Set;

/**
 * This interface describes the behavior of a car component.
 *
 * @author Chris Casola
 * @version Feb 19, 2013
 */
public interface CarComponent {

	/**
	 * @return a set containing the names of the components of this car
	 */
	Set<String> getComponentNames();
	
	/**
	 * @return a set containing the names of the features this car has
	 */
	Set<String> getFeatures();
	
	/**
	 * @return the total cost of this car
	 */
	Double getCost();
}
