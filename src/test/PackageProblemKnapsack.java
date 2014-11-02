package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class PackageProblemKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {

				String[] section = line.split(":");

				/* Max Weight */
				int W = Integer.valueOf(section[0].trim());

				String[] data = section[1].trim().split(" ");

				/* number of items */
				int N = data.length;

				double[] v = new double[N];
				double[] w = new double[N];

				for (int i = 0; i < data.length; i++) {
					String[] val = data[i].subSequence(1, data[i].length() - 1)
							.toString().split(",");
					v[i] = Double.valueOf(val[2].substring(1, val[2].length()));
					w[i] = Double.valueOf(val[1]);
				}

				double[][] sack = new double[N + 1][W + 1];

				for (int i = 0; i < N + 1; i++) {
					for (int j = 0; j < N + 1; j++) {
						if (i == 0 || j == 0) {
							sack[i][j] = 0;
						} else {
							if (j > w[i])
								sack[i][j] = Math.max(sack[i - 1][j],
										sack[i - 1][j - j] + w[i]);
							else
								sack[i][j] = sack[i - 1][j];
						}
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
