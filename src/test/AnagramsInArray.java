package test;

import java.util.HashMap;
import java.util.TreeMap;

public class AnagramsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[] { "bat", "cat", "put", "tab", "atb" };
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			TreeMap<Character, Integer> tree = new TreeMap<Character, Integer>();
			for (int j = 0; j < arr[i].length(); j++) {
				tree.put(arr[i].charAt(j), 0);
			}
			String s = "";
			for (char c : tree.keySet()) {
				s = s + c;
			}
			if (hash.containsKey(s)) {
				System.out.println("Yes" + " | " + arr[hash.get(s)] + " & "
						+ arr[i]);
				return;
			} else {
				hash.put(s, i);
			}
		}
		System.out.println("No");
	}

}
