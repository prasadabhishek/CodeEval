package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class KadanesAlgorithm {

	public static Integer Kadane(String[] arr) {
		int max_so_far = 0;
		int max_ending_here = 0;

		for (int i = 0; i < arr.length; i++) {
			max_ending_here = max_ending_here + Integer.valueOf(arr[i].trim());

			if (max_ending_here < 0)
				max_ending_here = 0;
			else if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}

	static int maxSubArraySum(String[] a, int size) {
		int max_so_far = Integer.valueOf(a[0].trim()), i;
		int curr_max = Integer.valueOf(a[0].trim());

		for (i = 1; i < size; i++) {
			curr_max = Math.max(Integer.valueOf(a[i].trim()), curr_max
					+ Integer.valueOf(a[i].trim()));
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				String[] arr = line.split(",");
				System.out.println(maxSubArraySum(arr, arr.length));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
