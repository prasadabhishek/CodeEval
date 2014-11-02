package test;

import java.util.ArrayList;

public class MaxPath {

	public static void max(int[][] a) {
		int i = 0;
		int j = 0;
		int max = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();
		while (i < 3 && j < 3) {
			if (i == 0 && j == 0) {
				max = a[i][j];
				path.add(a[i][j]);
			}

			int R = 0;
			int D = 0;
			if (i + 1 < 3)
				R = a[i + 1][j];
			if (j + 1 < 3)
				D = a[i][j + 1];

			if (R != 0 && D != 0) {
				/* Go Right */
				if (R > D) {
					max = max + a[i + 1][j];
					path.add(a[i + 1][j]);
					i++;
				} else {/* Go Down */
					max = max + a[i][j + 1];
					path.add(a[i][j + 1]);
					j++;
				}
			} else if (R == 0 && D != 0) {
				max = max + a[i][j + 1];
				path.add(a[i][j + 1]);
				j++;
			} else if (R != 0 && D == 0) {
				max = max + a[i + 1][j];
				path.add(a[i + 1][j]);
				i++;
			} else {
				i++;
				j++;
			}
		}
		System.out.println("The Max path is : " + path + " of value : " + max);
	}

	public static void min(int[][] a) {
		int i = 0;
		int j = 0;
		int min = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();
		while (i < 3 && j < 3) {
			if (i == 0 && j == 0) {
				min = a[i][j];
				path.add(a[i][j]);
			}

			int R = 0;
			int D = 0;
			if (i + 1 < 3)
				R = a[i + 1][j];
			if (j + 1 < 3)
				D = a[i][j + 1];

			if (R != 0 && D != 0) {
				/* Go Right */
				if (R < D) {
					min = min + a[i + 1][j];
					path.add(a[i + 1][j]);
					i++;
				} else {/* Go Down */
					min = min + a[i][j + 1];
					path.add(a[i][j + 1]);
					j++;
				}
			} else if (R == 0 && D != 0) {
				min = min + a[i][j + 1];
				path.add(a[i][j + 1]);
				j++;
			} else if (R != 0 && D == 0) {
				min = min + a[i + 1][j];
				path.add(a[i + 1][j]);
				i++;
			} else {
				i++;
				j++;
			}
		}
		System.out.println("The Min path is : " + path + " of value : " + min);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[][] { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		max(a);
		min(a);
	}
}
