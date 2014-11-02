package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class powerSets {

	private static List<List<String>> computePowerIterative(List<String> input) {
		List<List<String>> powerSet = new ArrayList<List<String>>();
		/* Add Empty Set */
		powerSet.add(new ArrayList<String>());
		for (int i = 0; i < input.size(); i++) {
			String elem = input.get(i);
			int numOfExistingElements = powerSet.size();
			for (int j = 0; j < numOfExistingElements; j++) {
				List<String> list =  powerSet.get(j);
				List<String> newList = new ArrayList<String>();
				newList.addAll(list);
				newList.add(elem);
				powerSet.add(newList);
			}
		}
		return powerSet;
	}

	private static void printPowerSet(List<List<String>> powerSet) {
		for (List<String> lst : powerSet) {
			System.out.print("{");
			for (String s : lst) {
				System.out.print(s);
			}
			System.out.print("}");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> input = new ArrayList<String>();
		input =  Arrays.asList("a","b","h","i","s","h","e","k","p","r","a","s","a","d");
		List<List<String>> powerSet = computePowerIterative(input);
		System.out.println("Size of power set " + powerSet.size());
		printPowerSet(powerSet);
	}

}
