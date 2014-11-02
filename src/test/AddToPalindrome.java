package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class AddToPalindrome {

	public static Boolean isPalindrome(String s) {

		for (int i = 0; i < s.length() / 2; i++) {
			if (s.toLowerCase().charAt(i) != s.toLowerCase().charAt(
					s.length() - i - 1)) {
				return false;
			}
		}
		return true;

	}

	public static String Reverse(String s) {
		String result = "";
		for (int i = s.length() - 1; i > -1; i--) {
			result += s.charAt(i);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				int count = 0;
				while (!isPalindrome(line)) {
					line = String.valueOf(Integer.valueOf(line)
							+ Integer.valueOf(Reverse(line)));
					count++;
				}
				System.out.println(count + " " + line);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
