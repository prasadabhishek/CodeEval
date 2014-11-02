package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class soution {


	public static void main(String args[]) {
		BufferedReader in;
		ArrayList<String> A = new ArrayList<String>();
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\micro\\input.txt"));
			while (in.ready()) {
				A.add(in.readLine());
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		// String[] A = { "NEXT", "NEXT", "GOTO 5", "NEXT", "GOTO 1", "NEXT" };
		HashMap<Integer, Boolean> isChecked = new HashMap<Integer, Boolean>();
		// HashMap<Integer, Boolean> done = new HashMap<Integer, Boolean>();
		int i = 0;
		do {
			if (!isChecked.containsKey(i)) {
				if (A.get(i).matches("NEXT")) {
					isChecked.put(i, Boolean.TRUE);
					// isChecked.put(i + 1, Boolean.TRUE);
					i++;
				} else {
					isChecked.put(i, Boolean.TRUE);
					String[] temp = A.get(i).split(" ");
					String gotowhat = temp[1];
					i = Integer.valueOf(gotowhat) - 1;
					// isChecked.put(Integer.valueOf(gotowhat), Boolean.TRUE);
				}
			} else {
				break;
			}
		} while (!isChecked.containsKey(i));

		for (int j = 0; j < A.size(); j++) {
			if (!isChecked.containsKey(j)) {
				System.out.println(j + 1);
			}
		}
	}
}
