/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Abhishek
 * 
 */
public class removeComments {

	public static void printNonComments() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String result = "";
			String str = br.readLine();
			String[] a = str.split("//");
			str = a[0];
			a = str.split("/\\*");
			int i = 1;
			for (String s1 : a) {
				if (s1.contains("*/")) {
					String[] b = s1.split("\\*/");
					result = result + b[1] + " ";
				} else {
					if (i == 1)
						result = result + s1 + " ";
				}
				i++;
			}
			System.out.println(result.trim());
		}
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		printNonComments();

	}

}
