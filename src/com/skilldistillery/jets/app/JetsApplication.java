package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Cargo;
import com.skilldistillery.jets.entities.Fighter;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Passenger;

public class JetsApplication {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.run();
	}

	AirField af = new AirField();
	List<Jet> listOfJets = new ArrayList<>();

	public void run() {

        listOfJets = af.getFleet();
		int select;
		do {

			menu();
			select = sc.nextInt();

			if (select == 1) {
				list();
			}

			if (select == 2) {
				fly();
				
			}
			if (select == 3) {

				fastestJet();
			}

			if (select == 4) {
				longestRange();
			}
			if (select == 5) {
				loadCargoJets();
			}
			if (select == 6) {
				fightJets();

			}
			if (select == 7) {
				addJet();
			}

			if (select == 8) {
				removeJet();
			}

			if (select == 9) {
               System.out.println("Goodbye");
			}
		} while (select != 9);

	}

//create the AirField

	public void menu() {
		System.out.println("1.List fleet");
		System.out.println("2.Fly all jets");
		System.out.println("3.View fastest jet");
		System.out.println("4.View jet with longest range");
		System.out.println("5.Load all Cargo Jets");
		System.out.println("6.Dogfight!");
		System.out.println("7.Add jet to Fleet");
		System.out.println("8.Remove a jet to Fleet");
		System.out.println("9.Quit");
	}

	public void list() {
		for (Jet jet : af.getFleet()) {
			System.out.println(jet);
		}

	}

	public void fly() {
		for (Jet jet : af.getFleet()) {
			jet.fly();
			jet.toString();
		}
	}

	public void fastestJet() {
		Jet maximum = null;
		double maxSpeed = 0;
		for (Jet jet : af.getFleet()) {

			if (jet.getSpeed() > maxSpeed) {
				maxSpeed = jet.getSpeed();
				maximum = jet;

			}
		}
		System.out.println(maximum);

	}

	public void longestRange() {
		Jet maximum = null;
		int largestRange = 0;
		for (Jet jet : af.getFleet()) {
			if (jet.getRange() > largestRange) {
				largestRange = jet.getRange();
				maximum = jet;
			}
		}
		System.out.println(maximum);
	}

	public void loadCargoJets() {
		for (Jet jet : af.getFleet()) {
			if (jet instanceof Cargo) {
				((Cargo) jet).loadCargo();
				System.out.println(jet);

			}
		}
	}

	public void fightJets() {
		for (Jet jet : af.getFleet()) {
			if (jet instanceof Fighter) {
				System.out.println(jet.getModel() + ":");
				((Fighter) jet).fight();

			}
		}
	}

	public void addJet() {
		try {
			System.out.println("Select a number that corresponds to the jet type to add to the fleet:");
			System.out.println("1.Passenger 2.Fighter 3.Cargo");
			int jettype = sc.nextInt();
			System.out.println("Jet model:");
			String model = sc.next();
			System.out.println("Jet speed:");
			double speed = sc.nextDouble();
			System.out.println("Jet range:");
			int range = sc.nextInt();
			System.out.println("Jet price:");
			long price = sc.nextLong();

			if (jettype == 1) {
				af.getFleet().add(new Passenger(model, speed, range, price));

			}
			if (jettype == 2) {
				af.getFleet().add(new Fighter(model, speed, range, price));
			}
			if (jettype == 3) {
				af.getFleet().add(new Cargo(model, speed, range, price));

			}
			System.out.println("Jet has been added to fleet.");
		} catch (InputMismatchException o) {
			System.out.println("Invalid input");
			System.out.println(o.getMessage());

		}

	}

	public void removeJet() {
		List<Jet> jetsList = af.getFleet();
		for (int i = 0; i < jetsList.size(); i++) {
			System.out.println((i + 1 + " " + jetsList.get(i)));
		}
		System.out.println("Which jet would you like to delete?: ");

		try {
			int choice = sc.nextInt();
			if (choice < jetsList.size() + 1 && choice > 0) {
				System.out.println(jetsList.get(choice - 1).getModel() + "has been removed from the fleet");
				jetsList.remove(choice - 1);

			} else {
				System.out.println("Response not valid");
			}
		} catch (InputMismatchException o) {
			System.out.println(o.getMessage());
		}
	}

}
