package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class Fibonacci {

	public static void fibo(Integer a, Integer b, Integer n) {
		int temp = 0;
		if (n == 1) {
			System.out.println(1);
			return;
		}
		while (n > 1) {
			temp = a + b;
			a = b;
			b = temp;
			n = n - 1;
		}
		System.out.println(temp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				fibo(0, 1, Integer.valueOf(line));
			}

		} catch (Exception e) {

		}

	}
}
