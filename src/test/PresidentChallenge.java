package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PresidentChallenge {

	private static Integer noOfIssues;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Abhishek\\Desktop\\input.txt");
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			line = in.readLine();
			noOfIssues = Integer.valueOf(line.substring(line.indexOf(":") + 1,
					line.length()).trim());
			/* Skip the space */
			line = in.readLine();
			/* Create Social Issues Weight Map */
			HashMap<String, Integer> social = new HashMap<String, Integer>();
			while ((line = in.readLine()) != "") {
				String name = line.substring(0, line.indexOf(":")).trim();
				Integer val = Integer.valueOf(line.substring(
						line.indexOf(":") + 1, line.length()).trim());
				social.put(name, val);
			}
			/* Skip the space */
			line = in.readLine();
			/* Read State Wise Data */
			while ((line = in.readLine()) != null) {

				line = in.readLine();

				while ((line = in.readLine()) != "") {
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}

	public static class SocialIssues {
		private String Name;
		private Integer Value;

		SocialIssues(String name, Integer val) {
			Name = name;
			Value = val;
		}
	}

	public static class StateDetail {
		private String Name;
		private Integer Votes;
		private HashMap<String, String> Weights;

		StateDetail(String name, Integer votes, HashMap weights) {
			Name = name;
			Votes = votes;
			Weights = weights;
		}

	}

}
