package fr.formation.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.formation.test.exception.OperationException;

public class OperationImpl implements Operation {

	@Override
	public double addition(double a, double b) {
		return a + b;
	}

	
	@Override
	public double soustraction(double a, double b) {
		return a - b;
	}
	
	@Override
	public double multiplication(double a, double b) {
		return a * b;
	}

	
	@Override
	public double division(double a, double b) {
		if (b == 0)
			throw new OperationException("Division par zero");
		
		return a / b;
	}


	@Override
	public int getRandomInt() {
		return new Random().nextInt();
	}


	@Override
	public List<Integer> getRandomIntList(int nb) {
		List<Integer> liste = new ArrayList<Integer>();
		for (int i = 0; i < nb; i++) {
			liste.add(getRandomInt());
		}
		return liste;
	}
	
}
