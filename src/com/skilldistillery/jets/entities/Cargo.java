package com.skilldistillery.jets.entities;

public class Cargo extends Jet implements CargoInt {

	public Cargo() {
		super();	
	}
	public Cargo(String model, double speed, int range, long price) {
		super(model, speed, range, price);	
	}
	@Override
	public void fly() {
		double time = this.getRange() / this.getSpeed();
		System.out.println(toString());
		System.out.println(this.getModel() + " can fly " + time + " hours, before needing fuel.");
	}
	@Override
	public void loadCargo() {
		System.out.println("Loading all cargo Jets: ");
	}

}
