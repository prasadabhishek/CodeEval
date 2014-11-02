package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class sumOfIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			int sum = 0;
			while ((line = in.readLine()) != null) {
				sum += Integer.valueOf(line);
			}
			System.out.println(sum);
		} catch (Exception e) {

		}

	}
}
