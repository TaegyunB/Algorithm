import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> stringToNum = new TreeMap<>();
		
		
		String line;
		int sum = 0;
		while ((line = br.readLine()) != null) {
			
			stringToNum.put(line, stringToNum.getOrDefault(line, 0) + 1);
			sum++;
					
		}
		
		for (String name : stringToNum.keySet()) {
			double avg = ((double)stringToNum.get(name) / (double)sum) * 100;
			System.out.printf("%s %.4f \n", name, avg);
		}
	}
}
