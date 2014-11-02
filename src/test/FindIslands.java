package test;

import java.util.HashMap;

public class FindIslands {

	static int[][] matrix = new int[][] { { 1, 1, 1, 1 }, { 1, 0, 1, 1 },
			{ 1, 1, 1, 0 }, { 1, 1, 1, 0 } };
	static int COLS = 4;
	static int ROWS = 4;
	static HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
	static HashMap<String, Boolean> edgeCovered = new HashMap<String, Boolean>();

	public static void coverEdge(int i, int j, int parentI, int parentJ) {
		String node = String.valueOf(i) + String.valueOf(parentJ);
		String parentNode = String.valueOf(parentI) + String.valueOf(j);

		String key = node + parentNode;
		String key2 = parentNode + node;

		if (!edgeCovered.containsKey(key)) {
			edgeCovered.put(key, false);
		}
		if (!edgeCovered.containsKey(key2)) {
			edgeCovered.put(key2, false);
		}
	}

	public static Boolean shallEscape(int i, int j, int parentI, int parentJ) {
		String node = String.valueOf(i) + String.valueOf(parentJ);
		String parentNode = String.valueOf(parentI) + String.valueOf(j);

		String key = node + parentNode;
		String key2 = parentNode + node;

		if (edgeCovered.containsKey(key)) {
			return true;
		}
		if (edgeCovered.containsKey(key2)) {
			return true;
		}
		return false;
	}

	public static void DFS(int i, int j, int parentValue, int parentI,
			int parentJ) {
		String node = String.valueOf(i) + String.valueOf(parentJ);
		String parentNode = String.valueOf(parentI) + String.valueOf(j);

		String key = node + parentNode;
		String key2 = parentNode + node;

		if (i != parentI || j != parentJ) {
			if (matrix[i][j] == 1 && matrix[parentI][parentJ] == 1) {

				if (!visited.containsKey(key)) {
					visited.put(key, true);
				}
				if (!visited.containsKey(key2)) {
					visited.put(key2, true);
				}
			}
		}

		/* UP */
		if (i - 1 > 0 && i - 1 < ROWS) {
			if (!shallEscape(i - 1, j, i, j)) {
				coverEdge(i - 1, j, i, j);
				DFS(i - 1, j, matrix[i][j], i, j);
			}
		}
		/* DOWN */
		if (i + 1 > 0 && i + 1 < ROWS) {
			if (!shallEscape(i + 1, j, i, j)) {
				coverEdge(i + 1, j, i, j);
				DFS(i + 1, j, matrix[i][j], i, j);
			}
		}
		/* RIGHT */
		if (j + 1 > 0 && j + 1 < COLS) {
			if (!shallEscape(i, j + 1, i, j)) {
				coverEdge(i, j + 1, i, j);
				DFS(i, j + 1, matrix[i][j], i, j);
			}
		}
		/* LEFT */
		if (j - 1 > 0 && j - 1 < COLS) {
			if (!shallEscape(i, j - 1, i, j)) {
				coverEdge(i, j - 1, i, j);
				DFS(i, j - 1, matrix[i][j], i, j);
			}
		}
		return;
	}

	public static void main(String[] args) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				DFS(i, j, matrix[0][0], i, j);
			}
		}
		System.out.println(visited.size() / 2);
		System.out.println(visited);
	}
}
