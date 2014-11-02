package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class EmailIdValidator {
	static ArrayList<String> test = new ArrayList<String>(Arrays.asList("a",
			"b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1",
			"2", "3", "4", "5", "6", "7", "8", "9", "0"));

	public static boolean check(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!test.contains(text.charAt(i)))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			Boolean what = false;
			while ((line = in.readLine()) != null) {
				String[] part = line.split("@");
				String one = part[0];

				String two = part[1].split(".")[0];
				String three = part[1].split(".")[1];

				what = check(one);
				what = check(two);
				what = check(three);

				System.out.println(what);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
