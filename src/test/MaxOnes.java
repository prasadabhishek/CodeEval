package test;

public class MaxOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[][] { { 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };
		int i = 0;
		int j = 0;
		int row = 0;
		while (i < 6 && j < 6) {
			if (a[i][j] == 1) {
				row = i;
				j++; /* Go Right */
			} else {
				i++;/* Go Down */
			}
		}
		
		System.out.println("The row with max 1's is  : " + (row + 1));
	}
}
