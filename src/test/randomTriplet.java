package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class randomTriplet {

	public static class Node {
		private ArrayList<String> neighbours;
		private String data;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public ArrayList<String> getNeighbours() {
			return neighbours;
		}

		public void setNeighbours(ArrayList<String> neighbours) {
			this.neighbours = neighbours;
		}

		public void addNeighbour(String s) {
			this.neighbours.add(s);
		}

		public Boolean hasNeighbour(String s) {
			if (this.neighbours.contains(s))
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
	}

	public static class Graph {
		private ArrayList<Node> nodelist;

		public Graph(){
			nodelist =  new ArrayList<Node>();
		}
		public ArrayList<Node> getNode() {
			return nodelist;
		}

		public void setNode(ArrayList<Node> node) {
			this.nodelist = node;
		}

		public void addNode(Node n) {
			this.nodelist.add(n);
		}
	}

	public static String getRandomTriplet(String s) {
		ArrayList<String> result = new ArrayList<String>();
		int prevX = -1;
		int minimum = 0;
		try {
			while (result.size() < 3) {
				Random ran = new Random();
				int range = s.length() - minimum;
				int x = ran.nextInt(range) + minimum;
				if (result.size() == 0) {
					if (x > prevX && x < s.length() - 3) {
						result.add(String.valueOf(s.charAt(x)));
						prevX = x;
						minimum = x;
					}
				} else if (result.size() == 1) {
					if (x > prevX && x < s.length() - 1) {
						result.add(String.valueOf(s.charAt(x)));
						prevX = x;
						minimum = x;
					}
				} else {
					if (x > prevX) {
						result.add(String.valueOf(s.charAt(x)));
						prevX = x;
						minimum = x;
					}
				}
			}
		} catch (Exception e) {

		}
		String ret = "";
		for (String str : result)
			ret = ret + str;
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		HashMap<String, String> hash = new HashMap<String, String>();
		Boolean found = false;
		/* Create the Graph */
		Graph g = new Graph();
		while (!found) {
			String str = getRandomTriplet("hell");
			if (!hash.containsKey(str)) {
				hash.put(str, str);
				/* Creating a Node */
				Node n = new Node();
				n.setData(String.valueOf(str.charAt(0)));
				g.addNode(n);
				System.out.println(hash);
			} else {

			}

		}

	}

}
