package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PredictNumber {
	static String found;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Abhishek\\Desktop\\micro\\input.txt");
		BufferedReader in;
		String text = "0";
		int[] seed = { 0, 1, 1, 2 };
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				Integer N = Integer.valueOf(line);
				Integer result = N;
				Integer count = 0;
				if (N >= 4) {
					while (N > 1) {
						N = (int) (Math.ceil(Double.valueOf(N / 2)));
						count++;
					}

					int half = (int) Math.pow(2, (double) count)
							+ (int) Math.pow(2, (double) count) / 2;

					if (result >= half) {
						int newCount = 0;
						for (int i = count; i > 0; i--) {
							if (result > 3
									&& result - (int) Math.pow(2, (double) i) >= 0) {
								result -= (int) Math.pow(2, (double) i);
								newCount++;
							}
						}

						result = seed[result];
						for (int i = 0; i < newCount; i++) {
							if (result == 0)
								result = 1;
							else if (result == 1)
								result = 2;
							else if (result == 2)
								result = 0;
						}
					} else {
						result = seed[result
								% ((int) Math.pow(2, (double) count))];
						if (result == 0)
							result = 1;
						else if (result == 1)
							result = 2;
						else if (result == 2)
							result = 0;
					}
					System.out.println(result);
				} else
					System.out.println(seed[N]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
