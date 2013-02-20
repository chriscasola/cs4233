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

import static org.junit.Assert.*;

import org.junit.Test;

import decoratordemo.cars.ConcreteCarA;
import decoratordemo.cars.ConcreteCarB;
import decoratordemo.common.CarComponent;
import decoratordemo.features.BasePackage;
import decoratordemo.features.LimitedPackage;
import decoratordemo.features.NavigationSystem;

/**
 * Tests for car components and car features. These tests exercise
 * this demo of the decorator pattern.
 *
 * @author Chris Casola
 * @version Feb 19, 2013
 */
public class DecoratorDemoTest {

	@Test
	public void carInitializedWithBasePriceAndFeatures() {
		CarComponent carA = new ConcreteCarA();
		
		assertTrue(15000.0 == carA.getCost());
		assertEquals(1, carA.getComponentNames().size());
		assertTrue(carA.getComponentNames().contains("Car A"));
		assertEquals(0, carA.getFeatures().size());
	}

	@Test
	public void canAddLimitedPackageToCar() {
		CarComponent carA = new ConcreteCarA();
		carA = new LimitedPackage(carA);
		
		assertTrue(16500.0 == carA.getCost());
		assertEquals(2, carA.getComponentNames().size());
		assertTrue(carA.getComponentNames().contains("Car A"));
		assertTrue(carA.getComponentNames().contains("Limited Package"));
		assertEquals(3, carA.getFeatures().size());
		assertTrue(carA.getFeatures().contains("Moonroof"));
		assertTrue(carA.getFeatures().contains("Heated cloth seats"));
		assertTrue(carA.getFeatures().contains("iPod Connection"));
	}
	
	@Test
	public void canAddMultiplePackagesToCar() {
		CarComponent carB = new ConcreteCarB();
		carB = new BasePackage(carB);
		carB = new LimitedPackage(carB);
		carB = new NavigationSystem(carB);
		
		assertTrue(29000.0 == carB.getCost());
		assertEquals(4, carB.getComponentNames().size());
		assertTrue(carB.getComponentNames().contains("Car B"));
		assertTrue(carB.getComponentNames().contains("Limited Package"));
		assertTrue(carB.getComponentNames().contains("Base Package"));
		assertTrue(carB.getComponentNames().contains("Navigation System"));
		assertEquals(7, carB.getFeatures().size());
	}
}
