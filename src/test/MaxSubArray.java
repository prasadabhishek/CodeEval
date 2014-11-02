package test;

import java.util.ArrayList;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		int max_so_far = 0;
		int max_ending_here = 0;
		
		/* KADANE's ALGORITHM */
		for (int i = 0; i < a.length; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0)
				max_ending_here = 0;
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				path.add(a[i]);
			}
		}
		
		System.out.println("The max subarray is between indexes : " + path
				+ " with a sum of : " + max_so_far);
	}

}
