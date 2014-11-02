package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class checkSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;
		ArrayList<String> A = new ArrayList<String>();
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\micro\\input.txt"));
			while (in.ready()) {
				A.add(in.readLine());
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < A.size(); i++) {
			String[] word = A.get(i).split(",");
			int size = 0 ;

		}
	}
}
