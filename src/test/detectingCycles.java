package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class detectingCycles {
	static String found;

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Abhishek\\Desktop\\micro\\input.txt");
		BufferedReader in;

		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				LinkedHashMap<String, Integer> hash = new LinkedHashMap<String, Integer>();
				String elem[] = line.split(" ");
				for (int i = 0; i < elem.length; i++) {
					if (!hash.containsKey(elem[i])) {
						hash.put(elem[i], 0);
					} else {
						found = elem[i];
						break;
					}
				}
				Boolean start = false;
				ArrayList<String> values = new ArrayList<String>(hash.keySet());
				for (int i = 0; i < values.size(); i++) {
					if (values.get(i).equals(found)){
						start = true;		
					}
					if(start){
						if(i!=values.size()-1)
							System.out.print(values.get(i) + " ");
						else
							System.out.print(values.get(i));
					}
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
