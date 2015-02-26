package src.simulation.log;

import java.io.*;

public class MyLog {

	private BufferedWriter out = null;
	private FileWriter fstream = null;

	public MyLog(String fileName) {
		try {
			FileWriter fstream = new FileWriter(fileName, false);
    		out = new BufferedWriter(fstream);
    	} catch (IOException e) {
    		System.out.println(String.format("Could not open log file '%s': %s", fileName, e.getMessage()));
    	}
	}

	public void write(String text) throws IOException{
		out.write(text);
	}

	public void close() throws IOException {
		if (out != null) {
			out.close();
		}
	}
}