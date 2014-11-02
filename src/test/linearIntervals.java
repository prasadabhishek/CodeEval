package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class linearIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1, 0, 1, 0, 1, 0, 1, 0);
		for (int i = 0; i < list.size(); i++) {
			int countZero = 0;
			int countOne = 0;
			for (int j = i; j < list.size(); j++) {
				if (list.get(j) == 0)
					countZero++;
				else
					countOne++;
				if (countZero == countOne) {
					System.out.println(i + " - " + j);
				}
			}
		}
	}
}
