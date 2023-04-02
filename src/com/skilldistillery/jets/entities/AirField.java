package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> fleet = new ArrayList<>();

	public AirField() {
		readFromFile();
	}

	public List<Jet> readFromFile() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"))) {
			String aJet;
			while ((aJet = bufIn.readLine()) != null) {
				Jet nj = null; // as you read in a Jet, create a Jet!
				String[] jetDetails = aJet.split(",");
				String model = jetDetails[1];
				double speed = Double.parseDouble(jetDetails[2]);
				int range = Integer.parseInt(jetDetails[3]);
				long price = Long.parseLong(jetDetails[4]);
				if (jetDetails[0].equals("Fighter")) {
					nj = new Fighter(model, speed, range, price);
				}
				if (jetDetails[0].equals("Cargo")) {
					nj = new Cargo(model, speed, range, price);
				}
				if (jetDetails[0].equals("Passenger")) {
					nj = new Passenger(model, speed, range, price);
				}
				fleet.add(nj);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return fleet;
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}
}
