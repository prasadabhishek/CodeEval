package test;

import java.util.LinkedHashSet;

public class AllCombinations {

	static LinkedHashSet<String> set = new LinkedHashSet<String>();
	static Integer length = 0;

	public static Boolean isInOrder(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) > str.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static void allPossibleCominations(String prefix, String str) {

		int n = str.length();
		if (n == 0) {
			if (prefix.length() == length && isInOrder(prefix))
				set.add(prefix);
		} else {
			if (str.length() == length && isInOrder(str))
				set.add(str);
			for (int i = 0; i < n; i++) {
				allPossibleCominations(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abhishek";
		length = s.length();
		allPossibleCominations("", s);
		System.out.println(set);
	}

}
