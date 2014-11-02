package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class phonewords {

	static HashMap<Integer, ArrayList<String>> hash = new HashMap<Integer, ArrayList<String>>();

	public static void initHash() {
		hash.put(1, new ArrayList<String>() {
			{
				add("1");
			}
		});

		hash.put(2, new ArrayList<String>() {
			{
				add("A");
				add("B");
				add("C");
			}
		});
		hash.put(3, new ArrayList<String>() {
			{
				add("D");
				add("E");
				add("F");
			}
		});
		hash.put(4, new ArrayList<String>() {
			{
				add("G");
				add("H");
				add("I");
			}
		});
		hash.put(5, new ArrayList<String>() {
			{
				add("J");
				add("K");
				add("L");
			}
		});
		hash.put(6, new ArrayList<String>() {
			{
				add("M");
				add("N");
				add("O");
			}
		});
		hash.put(7, new ArrayList<String>() {
			{
				add("P");
				add("Q");
				add("R");
				add("S");
			}
		});
		hash.put(8, new ArrayList<String>() {
			{
				add("T");
				add("U");
				add("V");
			}
		});
		hash.put(9, new ArrayList<String>() {
			{
				add("W");
				add("X");
				add("Y");
				add("Z");
			}
		});
		hash.put(0, new ArrayList<String>() {
			{
				add("0");
			}
		});

	}

	static Boolean start = false;

	static void printWordsUtil(ArrayList<Integer> number, int curr_digit,
			char output[], int n) {
		// Base case, if current output word is prepared
		int i;
		if (curr_digit == n) {
			if (start)
				System.out.print(",");
			System.out.print(output);
			start = true;
			return;
		}

		// Try all 3 possible characters for current digir in number[]
		// and recur for remaining digits
		for (i = 0; i < hash.get(number.get(curr_digit)).size(); i++) {
			output[curr_digit] = hash.get(number.get(curr_digit)).get(i)
					.toLowerCase().toCharArray()[0];
			printWordsUtil(number, curr_digit + 1, output, n);
		}
	}

	static// A wrapper over printWordsUtil(). It creates an output array and
	// calls printWordsUtil()
	void printWords(ArrayList<Integer> number, int n) {
		char[] result = new char[n];
		printWordsUtil(number, 0, result, n);
	}

	public static void main(String[] args) throws IOException {
		initHash();
		File file = new File("C:\\Users\\Abhishek\\Desktop\\micro\\input.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			start = false;
			ArrayList<Integer> number = new ArrayList<Integer>();
			for (int i = 0; i < line.length(); i++) {
				number.add(Integer.parseInt(String.valueOf(line.charAt(i))));
			}
			printWords(number, line.length());
			System.out.println("");
		}
	}
}
