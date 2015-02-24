package src.simulation.grid.grass;

public class Grass {
	
	public static final int growthCap = 30;
	private int growth;
	
	public Grass() {
		this.growth = 0;
	}

	public int getGrowth(int growth) {
		return this.growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
	}

	public void grow() {
		this.growth += (this.growth < 30) ? 1 : 0;
	}

	public boolean isGrown() {
		return (growth==growthCap) ? true : false;
	}
}