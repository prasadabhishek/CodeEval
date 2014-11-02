package test;

import java.util.ArrayList;
import java.util.Arrays;

public class FindNumberWithSameDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num = "123456784987654321";
		int index = 0;
		for (int i = 0; i < num.length() - 1; i++) {
			if (Integer.parseInt(String.valueOf(num.charAt(i))) < Integer
					.parseInt(String.valueOf(num.charAt(i + 1)))) {
				index = i;
			}
		}
		if (index == 0) {
			System.out.println("None Found");
			System.exit(0);
		}
		int newIndex = 0;
		int min = Integer.valueOf(num.charAt(index + 1));
		for (int i = index + 1; i < num.length(); i++) {
			if (Integer.parseInt(String.valueOf(num.charAt(i))) > Integer
					.parseInt(String.valueOf(num.charAt(index)))
					&& Integer.parseInt(String.valueOf(num.charAt(i))) < min) {
				min = Integer.valueOf(num.charAt(i));
				newIndex = i;
			}
		}
		String part1 = "";
		ArrayList<Integer> part2 = new ArrayList<Integer>();

		for (int i = 0; i < index; i++) {
			part1 = part1 + Integer.parseInt(String.valueOf(num.charAt(i)));
		}
		part1 = part1 + Integer.parseInt(String.valueOf(num.charAt(newIndex)));
		for (int i = index + 1; i < num.length(); i++) {
			if (i == newIndex)
				part2.add(Integer.parseInt(String.valueOf(num.charAt(i))));
			else
				part2.add(Integer.parseInt(String.valueOf(num.charAt(i))));
		}
		Arrays.sort(part2.toArray());
		for (int i = 0; i < part2.size(); i++) {
			part1 = part1 + part2.get(i);
		}
		System.out.println(part1);
	}
}
