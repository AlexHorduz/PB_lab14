package lab14_PB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Task3 {
	public static void main(String[] args) {
		try {
			copyNoEmptyStrings("Task3/source.txt", "Task3/destination.txt");
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void copyNoEmptyStrings(String source, String destination) throws FileNotFoundException, IOException {
		if (source == null || destination == null) {
			throw new NullPointerException("Null passed as a parameter");
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(source));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
			String s = null;
			while ((s = br.readLine()) != null) {
				if (!s.isEmpty()) {
					bw.write(s + '\n');
				}
			}
		} 
		
	}
}	
