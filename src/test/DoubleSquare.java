package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DoubleSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			int N = Integer.valueOf(in.readLine());
			while ((line = in.readLine()) != null) {
				TreeMap<Integer, Integer> squares = new TreeMap<Integer, Integer>();
				int X = Integer.valueOf(line);
				int num = 0;
				while (num * num <= X) {
					squares.put(num, num * num);
					num++;
				}

				HashMap<Integer, Integer> done = new HashMap<Integer, Integer>();
				HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();

				for (Entry<Integer, Integer> entry : squares.entrySet()) {
					if (!result.containsKey(entry.getKey())) {
						int val1 = entry.getValue();
						int val2 = X - entry.getValue();

						if (squares.containsValue(val2)) {

							if (!done.containsKey(val1))
								done.put(val1, val1);

							if (!done.containsKey(val2))
								done.put(val2, val2);

							result.put(val1, val2);
							result.put(val2, val1);
						}
					}
				}

				if (X == 0)
					System.out.println(X + " | " + 1);
				else
					System.out.println(X + " | " + result.size() / 2);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
