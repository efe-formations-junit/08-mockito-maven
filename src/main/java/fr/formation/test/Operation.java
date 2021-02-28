package fr.formation.test;

import java.util.List;

public interface Operation {

	double addition(double a, double b);

	double soustraction(double a, double b);

	double multiplication(double a, double b);

	double division(double a, double b);
	
	int getRandomInt();
	
	List<Integer> getRandomIntList(int nb);

}