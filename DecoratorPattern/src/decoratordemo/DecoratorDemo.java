/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package decoratordemo;

import decoratordemo.cars.ConcreteCarB;
import decoratordemo.common.CarComponent;
import decoratordemo.features.BasePackage;
import decoratordemo.features.LimitedPackage;
import decoratordemo.features.NavigationSystem;

/**
 * The main class for this decorator pattern demo. The main method in this
 * class exercises the decorator code by configuring a car with a number of
 * packages and outputting various information about the car.
 *
 * @author Chris Casola
 * @version Feb 19, 2013
 */
public class DecoratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Construct a new car and add the base package
		CarComponent myCar = new ConcreteCarB();
		myCar = new BasePackage(myCar);
		
		// Print the price of the car with the base package
		System.out.println("Base price: " + myCar.getCost());
		
		// Print the names of the components applied to the car so far
		System.out.println("\nNames:");
		for (String name : myCar.getComponentNames()) {
			System.out.println("\t" + name);
		}
		
		// Print the names of the features applied to the car so far
		System.out.println("Features:");
		for (String feature : myCar.getFeatures()) {
			System.out.println("\t" + feature);
		}
		
		// Alert the user that the limited package and navigation are being added to the car
		System.out.println("\nNow adding the limited package plus navigation...\n");
		
		// Wrap the existing car in both the navigation and limited decorators
		myCar = new LimitedPackage(new NavigationSystem(myCar));
		
		// Print stats about the car after adding navigation and limited packages
		System.out.println("Names:");
		for (String name : myCar.getComponentNames()) {
			System.out.println("\t" + name);
		}
		
		System.out.println("Features:");
		for (String feature : myCar.getFeatures()) {
			System.out.println("\t" + feature);
		}
		
		// Print the total cost of the car
		System.out.println("\nTotal cost: " + myCar.getCost());
	}
}
