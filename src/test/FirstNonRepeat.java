package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedHashMap;

public class FirstNonRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
				for (int i = 0; i < line.length(); i++) {
					if (hash.containsKey(line.charAt(i))) {
						hash.put(line.charAt(i), 1);
					} else {
						hash.put(line.charAt(i), 0);
					}
				}
				for (Character s : hash.keySet()) {
					if (hash.get(s) != 1) {
						System.out.println(s);
						break;
					}
				}
			}
		} catch (Exception e) {

		}
	}
}
