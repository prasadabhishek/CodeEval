package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class RemoveCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				String[] elem = line.split(",");
				String result = "";
				for (int i = 0; i < elem[0].length(); i++) {
					if (!elem[1].trim().contains(String.valueOf(elem[0].charAt(i)))) {
						result += elem[0].charAt(i);
					}
				}
				System.out.println(result);
			}
		} catch (Exception e) {

		}
	}

}
