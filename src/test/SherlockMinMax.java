package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;

public class SherlockMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;

		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.valueOf(in.readLine());
			String[] a = in.readLine().split(" ");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < a.length; i++) {
				list.add(Integer.valueOf(a[i]));
			}
			Collections.sort(list);
			String[] pq = in.readLine().split(" ");

			int p = Integer.valueOf(pq[0]);
			int q = Integer.valueOf(pq[1]);

			int result = 0;
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			for (int j = p; j < q + 1; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < n; k++) {
					int temp = Math.abs(list.get(k) - j);
					if (temp < min) {
						min = temp;
						result = j;
					}
				}
				if (!map.containsKey(min))
					map.put(min, j);
			}
			System.out.println(map.get(map.lastKey()));
			System.exit(0);
		} catch (Exception e) {

		}
	}
}
