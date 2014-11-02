package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Template {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
