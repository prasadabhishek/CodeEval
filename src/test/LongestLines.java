package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LongestLines {
	static Integer len;

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Abhishek\\Desktop\\micro\\input.txt");
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
			TreeMap<Integer, String> hash = new TreeMap<Integer,String>();
			String line;
			Integer N = Integer.valueOf(in.readLine());
			while ((line = in.readLine()) != null) {
				len = line.length();
				if (hash.size() < N) {
					hash.put(len,line);
				} else {
					Iterator it = hash.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry pairs = (Map.Entry) it.next();
						if ((Integer) pairs.getKey() < len) {
							hash.remove(pairs.getKey());
							hash.put(len,line);
							break;
						}
					}
				}
			}
			ArrayList<Integer> values = new ArrayList<Integer>(hash.keySet());
			for(int i = values.size()-1;i > -1 ;i--){
				System.out.println(hash.get(values.get(i)));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
