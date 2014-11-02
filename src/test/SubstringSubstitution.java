package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

import javax.print.attribute.HashAttributeSet;

public class SubstringSubstitution {
	public static void main(String[] args) throws FileNotFoundException,
			ConcurrentModificationException {
		File file = new File("C:\\Users\\Abhishek\\Desktop\\micro\\input.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		try {
			while ((line = in.readLine()) != null) {
				String[] lineArray = line.split(";");
				String mainString = lineArray[0];
				// ArrayList<Character> mainText = getList(mainString);
				String repString = lineArray[1];
				LinkedHashMap<String, Boolean> hash = new LinkedHashMap<String, Boolean>();
				String[] rep = repString.split(",");
				int i = 0;
				int index = 0;
				while (i < rep.length) {
					if (hash.size() == 0) {
						index = mainString.indexOf(rep[i]);
						/* split and add to hash */
						if (index != -1) {
							if (index - 0 > 0)
								hash.put(mainString.substring(0, index), false);
							if (index + rep[i].length() - index > 0) {
								String temp = mainString.substring(index,
										index + rep[i].length()).replaceFirst(
										rep[i], rep[i + 1]);
								hash.put(temp, true);
							}
							if (mainString.length() - index + rep[i].length() > 0)
								hash.put(mainString.substring(
										index + rep[i].length(),
										mainString.length()), false);

						}
					} else {
						int count = -1;
						for (String s : hash.keySet()) {
							count++;
							if (s.indexOf(rep[i]) != -1 && !hash.get(s)) {
								index = s.indexOf(rep[i]);
								LinkedHashMap<String, Boolean> temp = new LinkedHashMap<String, Boolean>();
								int newCount = -1;
								ArrayList<String> keyList = new ArrayList<String>(
										hash.keySet());
								for (int t = 0; t < keyList.size(); t++) {
									newCount++;
									if (newCount > count) {
										temp.put(keyList.get(t), false);
										hash.remove(keyList.get(t));
									}
								}
								/* remove itself */
								hash.remove(s);
								/* split and add new */
								if (index - 0 > 0) {
									String tempStr = s.substring(0, index);
									if (tempStr.length() > 0)
										hash.put(tempStr, false);
								}
								if (index + rep[i].length() - index > 0) {
									String tempStr = s.substring(index,
											index + rep[i].length())
											.replaceFirst(rep[i], rep[i + 1]);
									if (tempStr.length() > 0)
										hash.put(tempStr, true);
								}
								if (s.length() - index + rep[i].length() > 0) {
									String tempStr = s
											.substring(index + rep[i].length(),
													s.length());
									if (tempStr.length() > 0)
										hash.put(tempStr, false);
								}
								for (String t : temp.keySet()) {
									hash.put(t, temp.get(t));
								}
								break;
							}
						}
					}
					i += 2;
				}
				String result = "";
				for (String unit : hash.keySet())
					result += unit;
				System.out.println(result);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
