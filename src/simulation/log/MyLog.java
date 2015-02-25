package src.simulation.log;

public class MyLog {

	private BufferedWriter out = null;
	private FileWriter fstream = null;

	public MyLog(String fileName) {
		try {
			FileWriter fstream = new FileWriter(fileName, true);
    		out = new BufferedWriter(fstream);
    	} catch (IOException e) {
    		System.out.println(String.Format("Could not open log file '%s': %s", fileName, e.getMessage());
    	}
	}

	public void write(String text) {
		out.write(text);
	}

	public void close() {
		if (out != null) {
			out.close();
		}
	}
}