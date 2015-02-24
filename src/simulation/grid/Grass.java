package src.simulation.grid;

public class Grass {
	
	public static final int growthCap = 30;
	private int growth;
	
	public Grass() {
		
	}

	public int getGrowth() {
		return this.growth;
	}

	public void setGrowth(int growth) {
		this.growth = growth;
	}

	public void grow() {
		this.growth += (this.growth < 30) ? 1 : 0;
	}
}