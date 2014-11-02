package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class TimeDifference {

	public static String TimeDiff(String a, String b) {
		String[] aSplit = a.split(":");
		String[] bSplit = b.split(":");

		Integer aSec = Integer.valueOf(aSplit[0]) * 60 * 60
				+ Integer.valueOf(aSplit[1]) * 60 + Integer.valueOf(aSplit[2]);
		Integer bSec = Integer.valueOf(bSplit[0]) * 60 * 60
				+ Integer.valueOf(bSplit[1]) * 60 + Integer.valueOf(bSplit[2]);

		Integer diff = Math.abs(aSec - bSec);

		String hr = String.valueOf(diff / (60 * 60));
		if (Integer.valueOf(hr) < 10)
			hr = "0" + hr;
		diff = diff % (60 * 60);
		String min = String.valueOf(diff / 60);
		if (Integer.valueOf(min) < 10)
			min = "0" + min;
		diff = diff % 60;
		String sec = String.valueOf(diff % 60);
		if (Integer.valueOf(sec) < 10)
			sec = "0" + sec;
		return hr + ":" + min + ":" + sec;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				String[] time = line.split(" ");
				System.out.println(TimeDiff(time[0], time[1]));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
