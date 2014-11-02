package test;

import java.util.Arrays;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[] { 1, 3, 7, 5, 4, 12, 13 };
		Arrays.sort(a);
		int len = a.length;
		int d[] = new int[len];
		for (int i = 0; i < len; i++) {
			d[i] = a[i] * a[i];
		}

		for (int i = len - 1; i > 2; i--) {
			int sum = d[i];
			int R = d[i - 1];
			for (int j = 0; j < i - 1; j++) {
				if (d[j] + R == sum) {
					System.out.println("The Pythagorean Triplet is : " + a[j]
							+ " | " + a[i - 1] + " | " + a[i]);
				}
			}
		}
	}
}
