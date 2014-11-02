package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

public class next {

	static public String byteToHex(byte b) {
		// Returns hex String representation of byte b
		char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		char[] array = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
		return new String(array);
	}

	static public String charToHex(char c) {
		// Returns hex String representation of char c
		byte hi = (byte) (c >>> 8);
		byte lo = (byte) (c & 0xff);
		return byteToHex(hi) + byteToHex(lo);
	}

	public static void main(String args[]) {
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
			String[] temp = A.get(i).split("@");
			String part1 = temp[0];
			String next = temp[1];
			String[] temp2 = next.split("\\.");
			String part2 = temp2[0];
			String part3 = temp2[1];
			String result = "";
			String a = "\u05D0\u05D1";

			for (int j = 0; j < part1.length(); j++) {
				if ((int) part1.charAt(j) > 33 && (int) part1.charAt(j) < 126) {
					result += part1.charAt(j);
					result = result.toLowerCase();
				} else {
					result += "+" + String.valueOf(j);
					int codepoint = part1.codePointAt(j);
					result += "?" + Integer.toHexString(codepoint);
				}
			}
		}

	}
}
