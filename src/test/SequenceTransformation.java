package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SequenceTransformation {

	static Boolean isIt;

	public static int countSections(String line) {
		char last = line.charAt(0);
		int count = 1;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != last)
				count += 1;
			last = line.charAt(i);
		}
		return count;
	}

	public static Boolean oneLetter(String line) {
		char last = line.charAt(0);
		int count = 1;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != last)
				return false;
			last = line.charAt(i);
		}
		return true;
	}

	public static Boolean allA(String line) {
		char last = 'A';
		int count = 1;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != last)
				return false;
			last = line.charAt(i);
		}
		return true;
	}

	public static Boolean allOne(String line) {
		char last = '1';
		int count = 1;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != last)
				return false;
			last = line.charAt(i);
		}
		return true;
	}

	public static Boolean allB(String line) {
		char last = 'B';
		int count = 1;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != last)
				return false;
			last = line.charAt(i);
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Abhishek\\Desktop\\micro\\input.txt");
		BufferedReader in;

		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				String values[] = line.split(" ");
				String binary = values[0];
				String text = values[1];
				Integer index = 0;
				isIt = true;

				if (oneLetter(text)) {
					if (allA(text) && binary.length() <= text.length())
						System.out.println("Yes");
					else if (allB(text) && binary.length() <= text.length()
							&& allOne(binary))
						System.out.println("Yes");
					else
						System.out.println("No");
				} else if (text.charAt(0) == 'B' && binary.charAt(0) != '1') {
					System.out.println("No");
				} else if (countSections(binary) == countSections(text)) {
					System.out.println("Yes");
				} else if (countSections(binary) > countSections(text)) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
