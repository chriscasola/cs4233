package decoratordemo;

import decoratordemo.cars.ConcreteCarB;
import decoratordemo.common.CarComponent;
import decoratordemo.features.BasePackage;
import decoratordemo.features.LimitedPackage;
import decoratordemo.features.NavigationSystem;

public class DecoratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CarComponent myCar = new ConcreteCarB();
		myCar = new BasePackage(myCar);
		
		System.out.println("Base price: " + myCar.getCost());
		
		System.out.println("\nNames:");
		for (String name : myCar.getComponentNames()) {
			System.out.println("\t" + name);
		}
		
		System.out.println("Features:");
		for (String feature : myCar.getFeatures()) {
			System.out.println("\t" + feature);
		}
		
		System.out.println("\nNow adding the limited package plus navigation...\n");
		
		myCar = new LimitedPackage(new NavigationSystem(myCar));
		
		System.out.println("Names:");
		for (String name : myCar.getComponentNames()) {
			System.out.println("\t" + name);
		}
		
		System.out.println("Features:");
		for (String feature : myCar.getFeatures()) {
			System.out.println("\t" + feature);
		}
		
		System.out.println("\nTotal cost: " + myCar.getCost());
	}
}
