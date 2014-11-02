package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class RIghtMostChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				String[] elem = line.split(",");
				System.out.println(elem[0].lastIndexOf(elem[1]));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
