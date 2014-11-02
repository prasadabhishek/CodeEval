package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EqualityIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(3, 4, 7, 1, 2, 9, 8);
		HashMap<Integer, String> hash = new HashMap<Integer, String>();

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					Integer sum = list.get(i) + list.get(j);
					if (hash.containsKey(sum)) {
						/* A , B != C , D */
						if (!hash.get(sum).contains(String.valueOf(i))
								|| !hash.get(sum).contains(String.valueOf(j))) {
							/*
							 * A < B < C < D
							 */
							if (i > Integer
									.valueOf(hash.get(sum).split(" ")[1])) {
								hash.put(sum,
										hash.get(sum) + " " + String.valueOf(i)
												+ " " + String.valueOf(j));
								System.out.println(hash.get(sum));
								return;
							}
						}
					} else {
						if (i < j) {
							hash.put(sum,
									String.valueOf(i) + " " + String.valueOf(j));
						}
					}
				}
			}
		}
	}
}
