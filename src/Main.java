
package src;

import src.simulation.*;

public class Main {

	private static final int N_ITERATIONS = 5000;
	private static Simulation simulation;

	public static void main(String[] args) {
		simulation = new Simulation(N_ITERATIONS);
	}
}