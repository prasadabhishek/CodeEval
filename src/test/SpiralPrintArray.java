package test;

public class SpiralPrintArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] arr = new char[][] { { 'i', 'l', 'o', 'v', 'e' },
				{ 'd', 'i', 'n', 't', 'e' }, { 'n', 'e', 'w', 'e', 'p' },
				{ 'a', 'i', 'v', 'r', 'i' }, { 'm', 'a', 'x', 'e', 'c' } };

		boolean[][] flag = new boolean[5][5];

		int count = 0;
		int i = 0;
		int j = 0;
		int direction = 0;
		System.out.print(arr[i][j]);
		flag[i][j] = true;
		while (count != (5 * 5) - 1) {
			switch (direction) {
			case 0: {
				/* go right */
				if (j + 1 < 5 && !flag[i][j + 1]) {
					j++;
					count++;
					flag[i][j] = true;
					System.out.print(arr[i][j]);
				} else {
					direction = 1;
				}
				break;
			}
			case 1: {
				/* go down */
				if (i + 1 < 5 && !flag[i + 1][j]) {

					i++;
					count++;
					flag[i][j] = true;
					System.out.print(arr[i][j]);
				} else {
					direction = 2;
				}
				break;
			}
			case 2: {
				/* go left */
				if (j - 1 > -1 && !flag[i][j - 1]) {
					direction = 2;
					j--;
					count++;
					flag[i][j] = true;
					System.out.print(arr[i][j]);
				} else {
					direction = 3;
				}
				break;
			}
			case 3: {
				/* go up */
				if (i - 1 > -1 && !flag[i - 1][j]) {
					direction = 3;
					i--;
					count++;
					flag[i][j] = true;
					System.out.print(arr[i][j]);
				} else {
					direction = 0;
				}
				break;
			}
			}
		}
	}
}
