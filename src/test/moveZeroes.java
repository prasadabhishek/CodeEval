package test;

import java.util.Arrays;
import java.util.List;

public class moveZeroes {
	static int[] list = { 0,0,-1,1,0,2,3,0,0,5 };

	public static int Manipulate() {
		if (list.length < 1)
			return 0;
		int i = -1, m = 0;

		while (m < list.length) {
			if (list[m] != 0) {
				i += 1;
				list[i] = list[m];
			}
			m++;
		}
		int count = i + 1;
		while (i + 1 < m) {
			i += 1;
			list[i] = 0;
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Manipulate());
	}

}
