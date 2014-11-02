package test;

import java.io.BufferedReader;
import java.io.File;

public class FileSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File f = new File("C:\\Users\\Abhishek\\Desktop\\input.txt");
			System.out.println(f.length());
		} catch (Exception e) {

		}
	}
}
