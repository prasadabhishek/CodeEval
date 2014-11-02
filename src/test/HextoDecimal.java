package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class HextoDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final HashMap<String, Integer> hash = new HashMap<String, Integer>() {
			{
				put("0", 0);
				put("1", 1);
				put("2", 2);
				put("3", 3);
				put("4", 4);
				put("5", 5);
				put("6", 6);
				put("7", 7);
				put("8", 8);
				put("9", 9);
				put("a", 10);
				put("b", 11);
				put("c", 12);
				put("d", 13);
				put("e", 14);
				put("f", 15);

			}
		};
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				int sum = 0;
				for (int i = 0; i < line.length(); i++) {
					if (i != line.length() - 1) {
						sum += hash.get(String.valueOf(line.charAt(i))) * 16;
					} else {
						sum += hash.get(String.valueOf(line.charAt(i)));
					}
				}
				System.out.println(sum);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
