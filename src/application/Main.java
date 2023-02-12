package application;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the number of employees: ");
		int n = scan.nextInt();

		List<Employee> e1 = new ArrayList<Employee>();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i);
			System.out.print("Outsourced? (y/n): ");
			char outsourced = scan.next().charAt(0);
			
			System.out.print("Name: ");
			String name = scan.next();
			
			System.out.print("Hours: ");
			int hours = scan.nextInt();
			
			System.out.print("Value per hour: ");
			Double valuePerHour = scan.nextDouble();
			
			if (outsourced == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = scan.nextDouble();
				
				Employee e = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				e1.add(e);
			} else {
				Employee e = new Employee(name, hours, valuePerHour);
				e1.add(e);
			}
		}
		
		System.out.println("");
		System.out.println("PAYMENTS:");
		
		for (Employee employee : e1) {
			System.out.println(employee.getName() + "- $" + employee.payment());
		}
	}

}
