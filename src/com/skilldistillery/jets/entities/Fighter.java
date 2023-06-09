package com.skilldistillery.jets.entities;

public class Fighter extends Jet implements FighterInt {

	public Fighter() {
		super();
	}

	public Fighter(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void fight() {
		System.out.println("PEW PEW PEW ***CRASH*** ");
		System.out.println("READY AIM FIRE: ****BOOM****BANG****CRASH***");
	}

	@Override
	public void fly() {
		double time = this.getRange() / this.getSpeed();
		System.out.println(toString());
		System.out.println(this.getModel() + " can fly " + time + " hours, before needing fuel.");
	}
}
