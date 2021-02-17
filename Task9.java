package lab14_PB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task9 {
	public static void main(String[] args) {
		try (FileOutputStream out = new FileOutputStream("Task9/file.bin")) {
			byte[] buf = {0, 0, 0, 0, 4, 5, 0, 0, 0, 0, 0};
			out.write(buf);
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
			
		
		
		try {
			System.out.println(longestZeroSequenceLength("Task9/file.bin"));
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static long longestZeroSequenceLength(String filename) throws FileNotFoundException, IOException {
		if (filename == null) {
			throw new NullPointerException("Null passed as a parameter");
		}
		
		long maxSequence = 0;
		try (FileInputStream in = new FileInputStream(filename)) {
			byte[] buf = new byte[512];
			long currentSequence = 0;
			int readed = -1;
			
			while ((readed = in.read(buf)) != -1) {
				for (int i = 0; i < readed; i++) {
					if (buf[i] == 0) {
						currentSequence++;
						maxSequence = max(maxSequence, currentSequence);
					} else {
						currentSequence = 0;
					}
				}
			}
		}
		return maxSequence;
	}
	
	static long max(long l, long r) {
		return (l > r) ? l : r;
	}
}
