package src.simulation.auxiliary;

import java.util.Random;

public class MyRandom {

	private Random rand;

	public MyRandom() {
		rand = new Random();
	}

	public int randInt(int min, int max) {

    	int randomNum = rand.nextInt((max - min) + 1) + min;

    	return randomNum;
	}
}