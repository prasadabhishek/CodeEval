package test;

import java.util.HashMap;

/* where product of each combination is different */
public class ColorfulNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 3242; i < 5000; i++) {
			Boolean color = true;
			HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

			int size = 2;
			int len = String.valueOf(i).length();

			if (len != 1 && color) {
				while (size < len && color) {
					int j = 0;
					int k = j + size;
					while (k < len + 1 && color) {
						String test = String.valueOf(i).substring(j, k);
						int product = 1;
						for (int l = 0; l < test.length(); l++) {
							product = product
									* Integer.parseInt(String.valueOf(test
											.charAt(l)));
						}
						if (hash.containsKey(product)) {
							System.out.println(i + " | " + "Not Colorful");
							color = false;
						} else {
							hash.put(product, i);
						}
						j++;
						k++;
					}
					size++;
				}
			}
			if (color)
				System.out.println(i + " | " + "Colorful");
		}
	}
}
