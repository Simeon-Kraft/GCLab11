package lab11;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Lab11 {

	static List<Car> inventory = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		carInstant();

		System.out.println("Welcome to a tiny car lot.");
		
		boolean done = false;
		while (!done) {
			System.out.println("Select: (list, select, look up, add, remove, trade, quit)");
			String userSelect = scnr.nextLine().toLowerCase();

			switch (userSelect) {
			case "list":
				getList();
				break;
			case "select":
				selectCar(scnr);
				break;
			case "add":
				addCar(scnr);
				break;
			case "remove":
				removeCar(scnr);
				break;
			case "look up":
				lookUp(scnr);
				break;
			case "trade":
				replaceCar(scnr);
				break;
			default:
				System.out.println("Invalid option.");
				break;
			case "quit":
				done = true;
				break;
			}

		} System.out.println("Goodbye.");
	}
	public static void lookUp(Scanner scnr) {
		System.out.println("Choose a car inventory number: (enter 1-" + (inventory.size()) + ")");
		int userNum = getInt(scnr);
		System.out.println("Here ya go\n========\n" + inventory.get(userNum - 1));
	}
	
	public static void replaceCar(Scanner scnr) {
		
		System.out.println("Enter the lot number (1-6) of the car you'd like to trade for: ");
		int num = getInt(scnr);
		System.out.println("Enter the make, model, year, and price of the car you'd like to trade-in. \n");
		inventory.set(num - 1, new UsedCar(scnr.nextLine(), scnr.nextLine(), getYear(scnr), getPrice(scnr), getMileage(scnr)));
		
		System.out.println("Good deal. No tradsie-backsies.");
		
		
	}
	
	public static void removeCar(Scanner scnr) {

		System.out.println(
				"You want us to just trash one of our cars? In THIS economy? Ok. Say the word and we'll do it. (Select 1-6)");
		int userNum = getInt(scnr);
		System.out.println("You want to remove this bad-boy from our rolls?");
		System.out.println(inventory.get(userNum - 1));
		System.out.println("Consider it done.");
		inventory.remove(userNum - 1);
	}

	public static void getList() {
		System.out.println("Inventory by List\n=================");
		System.out.printf("%-6s %14s %15s %19s %21s", "Make", "Model", "Year", "Price", "Mileage\n");
		System.out.printf("%-6s %14s %16s %18s %21s", "=====", "=====", "=====", "=====", "=======\n");

		for (int i = 0; i < inventory.size(); i++) {
			System.out.println((i + 1) + ". " + inventory.get(i));
			System.out.println("\n");
		}
	}

	public static void addCar(Scanner scnr) {

		System.out.println(
				"Enter the make, model, year, and price of the car you'd like to add. If used, enter mileage as well.\n");
		inventory.add(new UsedCar(scnr.nextLine(), scnr.nextLine(), getYear(scnr), getPrice(scnr), getMileage(scnr)));

		System.out.println("Your listing has been added.");

	}

	public static int getYear(Scanner scnr) {
		System.out.println("Enter a year for the car: ");
		try {
			int num = scnr.nextInt();
			scnr.nextLine();
			return num;
		} catch (InputMismatchException e) {
			System.out.println("Enter a whole number for the year.");
			scnr.nextLine();
			return getYear(scnr);
		}

	}

	public static double getPrice(Scanner scnr) {
		System.out.println("Enter a price for the car: ");
		try {
			double dub = scnr.nextDouble();
			scnr.nextLine();
			return dub;
		} catch (InputMismatchException e) {
			System.out.println("Enter a valid price for the car.");
			scnr.nextLine();
			return getPrice(scnr);
		}
	}

	public static double getMileage(Scanner scnr) {
		System.out.println("Enter the car's mileage (If unused, enter 0): ");
		try {
			double dub = scnr.nextDouble();
			scnr.nextLine();
			return dub;
		} catch (InputMismatchException e) {
			System.out.println("Invalid entry. Enter the car's mileage or zero (0) if unused.");
			scnr.nextLine();
			return getPrice(scnr);
		}
	}

	public static void selectCar(Scanner scnr) {
		System.out.println("Which car would you like to purchase? (select 1-6)\n");
		int userSelect = getInt(scnr);

		System.out.println("You've selected: \n" + inventory.get(userSelect -1) + "\nReally? In THIS economy? Ok, then.");
		System.out.println("That bad-boy will be taken off the rolls.");

		inventory.remove(userSelect -1);

	}

	public static int getInt(Scanner scnr) {

		System.out.print("Enter a number: ");
		try {
			int num = scnr.nextInt();
			scnr.nextLine();
			return num;
		} catch (InputMismatchException e) {
			System.out.println("We have no such car. Please choose from cars 1-6: ");
			scnr.nextLine();
			return getInt(scnr);
		}
	}

	public static void carInstant() {
		inventory.add(new Car("Ford", "Foo", 1999, 29.990));
		inventory.add(new Car("Honda", "Hoo", 1889, 66.0));
		inventory.add(new Car("Toyota", "Too", 2001, 18.990));
		inventory.add(new UsedCar("Nissan", "Noo", 2009, 17.970, 70.000));
		inventory.add(new UsedCar("Subaru", "Soo", 2019, 26.000, 46.500));
		inventory.add(new UsedCar("GM", "Goo", 2003, 21.000, 27.000));
	}

}
