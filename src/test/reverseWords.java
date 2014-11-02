package test;

import java.util.Stack;

public class reverseWords {

	public static String getReverse(String s) {
		String result = "";
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				st.push(s.charAt(i));
			} else {
				while (st.size() != 0) {
					result = result + String.valueOf(st.pop());
				}
				result = result + " ";
			}
			if (i == s.length() - 1) {
				while (st.size() != 0) {
					result = result + String.valueOf(st.pop());
				}
				result = result + " ";
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getReverse("This is a Dog."));
	}

}
