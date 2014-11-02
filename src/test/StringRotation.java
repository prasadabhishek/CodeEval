package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				String[] list = line.split(",");
				if ((list[0] + list[0]).contains(list[1])
						&& list[0].length() == list[1].length()) {
					System.out.println("True");
				} else
					System.out.println("False");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
