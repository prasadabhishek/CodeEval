package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountOnes {

	public static Integer DoubleDabble(Integer n) {
		
		Integer dividend = n;
		Integer divisor = 2;
		Integer quotient = dividend;
		Integer remainder = 0;
		Integer count = 0;
		while (quotient != 0) {
			remainder = quotient % divisor;
			quotient = quotient / divisor;

			if (remainder == 1)
				count++;
		}
		return count;
	}

	public static String IntegerToBinary(Integer n) {
		if(n==0)
			return "0";
		Integer dividend = n;
		Integer divisor = 2;
		Integer quotient = dividend;
		Integer remainder = 0;
		Integer count = 0;
		String result = "";
		while (quotient != 0) {
			remainder = quotient % divisor;
			quotient = quotient / divisor;
			result = remainder + result;
			if (remainder == 1)
				count++;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(IntegerToBinary(Integer.valueOf(line)));
			}
		} catch (Exception e) {

		}

	}
}