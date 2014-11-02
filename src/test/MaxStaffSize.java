package test;

import java.util.HashMap;
import java.util.TreeMap;

public class MaxStaffSize {

	public static Integer calculateMass(String mass, Integer start, Integer end) {
		Integer result = 0;
		for (int i = start; i < end + 1; i++) {
			result = result + Integer.valueOf(String.valueOf(mass.charAt(i)));
		}
		return result;
	}

	public static Integer calculateWeightSum(String mass, Integer start,
			Integer end) {
		Integer result = 0;
		for (int i = start; i < end + 1; i++) {
			result = result
					+ (Integer.valueOf(String.valueOf(mass.charAt(i))) * i + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mass = "131251141231";
		int length = mass.length();
		double[][] centerofGravity = new double[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				try {
					int sum = calculateMass(mass, i, j);
					int weightSum = calculateWeightSum(mass, i, j);
					double weightedSum = weightSum / sum;
					centerofGravity[i][j] = weightedSum;
				} catch (Exception e) {
					System.out.println(i + " " + j);
				}
			}
		}
		int maxLength = Integer.MIN_VALUE;
		HashMap<Double, String> hash = new HashMap<Double, String>();
		TreeMap<Integer, String> resulthash = new TreeMap<Integer, String>();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				int len = j - i;
				hash.put(centerofGravity[i][j], String.valueOf(i) + " "
						+ String.valueOf(i));
				if (hash.containsKey(centerofGravity[i][j])
						|| !hash.containsKey((j - i) - centerofGravity[i][j]))
					resulthash.put(len,
							String.valueOf(i) + " " + String.valueOf(i));

			}
		}
		System.out.println(resulthash);
	}
}
