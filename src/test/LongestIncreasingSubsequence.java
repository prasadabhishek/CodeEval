package test;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {

	static int[] a = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
	static int[] lcs = new int[a.length];
	static int maxUntilNow = 0;
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static Integer maxLCS(int j) {
		int max = 0;
		for (int i = 0; i < j; i++) {
			if (lcs[i] > max && a[j] > a[i])
				max = lcs[i];
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < a.length; i++) {
			lcs[i] = 1 + maxLCS(i);
			if (maxUntilNow < lcs[i]) {
				maxUntilNow = lcs[i];
				list.add(a[i]);
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(lcs[i]);
		}
		System.out.println("The Max Increasing Path is : " + list);
	}
}
