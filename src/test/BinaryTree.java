package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {
	static TreeMap<Integer, String> hash = new TreeMap<Integer, String>();
	static HashMap<Node, Boolean> startedAt = new HashMap<Node, Boolean>();
	static Stack s = new Stack();
	static Queue<Integer> q = new LinkedList<Integer>();
	static int maxDepth = 0;

	public static class Node {
		private Node left;
		private Node right;
		private Node parent;
		private Integer data;

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Node(Integer d) {
			this.data = d;
		}

	}

	public static void printVertical(Node root, Integer seed) {
		if (root.left != null || root.right != null) {
			/* Put Root */
			if (!hash.containsKey(seed))
				hash.put(seed, String.valueOf(root.getData()));

			if (root.left != null) {
				/* Put Left */
				if (!hash.containsKey(seed - 1))
					hash.put(seed - 1, String.valueOf(root.getLeft().getData()));
				else
					hash.put(seed - 1, String.valueOf(hash.get(seed - 1)) + " "
							+ String.valueOf(root.getLeft().getData()));
				/* For Left */
				printVertical(root.getLeft(), seed - 1);
			}
			if (root.right != null) {
				/* Put Right */
				if (!hash.containsKey(seed + 1))
					hash.put(seed + 1,
							String.valueOf(root.getRight().getData()));
				else
					hash.put(seed + 1, String.valueOf(hash.get(seed + 1)) + " "
							+ String.valueOf(root.getRight().getData()));
				/* For Right */
				printVertical(root.getRight(), seed + 1);
			}

		} else
			return;
	}

	public static void LevelOrderPrint(Node root, Integer seed) {
		if (root.left != null || root.right != null) {
			/* Put Root */
			if (!hash.containsKey(seed))
				hash.put(seed, String.valueOf(root.getData()));

			if (root.left != null) {
				/* Put Left */
				if (!hash.containsKey(seed + 1))
					hash.put(seed + 1, String.valueOf(root.getLeft().getData()));
				else
					hash.put(seed + 1, String.valueOf(hash.get(seed + 1)) + " "
							+ String.valueOf(root.getLeft().getData()));
				/* For Left */
				LevelOrderPrint(root.getLeft(), seed + 1);
			}
			if (root.right != null) {
				/* Put Right */
				if (!hash.containsKey(seed + 1))
					hash.put(seed + 1,
							String.valueOf(root.getRight().getData()));
				else
					hash.put(seed + 1, String.valueOf(hash.get(seed + 1)) + " "
							+ String.valueOf(root.getRight().getData()));
				/* For Right */
				LevelOrderPrint(root.getRight(), seed + 1);
			}

		} else
			return;
	}

	public static void printZigZag(Node n) {
		LevelOrderPrint(n, 1);
		for (Integer i : hash.keySet()) {
			if ((i % 2) > 0) {
				String[] arr = hash.get(i).split(" ");
				for (int j = 0; j < arr.length; j++)
					System.out.print(arr[j] + " ");
				System.out.println("");
			} else {
				String[] arr = hash.get(i).split(" ");
				for (int j = arr.length - 1; j > -1; j--)
					System.out.print(arr[j] + " ");
				System.out.println("");
			}
		}

	}

	public static void findSum(int sum, Node node, String pathSoFar,
			int sumSoFar) {
		maxDepth++;
		/* base case */
		if (node == null)
			return;
		/* Add up the sum */
		sumSoFar = sumSoFar + node.getData();

		/* print if sum found */
		if (sum == sumSoFar) {
			pathSoFar = pathSoFar + " " + String.valueOf(node.getData());
			String[] sp = pathSoFar.split(" ");
			if (sp.length > 2) {
				for (int i = 0; i < sp.length; i++) {
					if (sp[i] != "")
						System.out.print(sp[i]);
					if (i != sp.length - 1)
						System.out.print(" --> ");
				}
				System.out.println("");
			}

		} else {/* create path */
			pathSoFar = pathSoFar + " " + String.valueOf(node.getData());
		}

		/* recurse for left subtree and start a new recursion from left child */
		if (node.getLeft() != null) {
			findSum(sum, node.getLeft(), pathSoFar, sumSoFar);
			if (!startedAt.containsKey(node.getLeft())) {
				startedAt.put(node.getLeft(), true);
				findSum(sum, node.getLeft(), "", 0);
			}
		}
		/* recurse for right subtree and start a new recursion from right child */
		if (node.getRight() != null) {
			findSum(sum, node.getRight(), pathSoFar, sumSoFar);
			if (!startedAt.containsKey(node.getRight())) {
				startedAt.put(node.getRight(), true);
				findSum(sum, node.getRight(), "", 0);
			}
		}
		return;
	}

	public static void findMaxDepth(Node root, int max) {
		if (root.left != null || root.right != null) {

			if (root.left != null) {
				/* For Left */
				findMaxDepth(root.getLeft(), max + 1);
			}
			if (root.right != null) {
				/* For Right */
				findMaxDepth(root.getRight(), max + 1);
			}

		} else {
			if (maxDepth < max)
				maxDepth = max;
			return;
		}
	}

	public static Node LeastCommonAncestor(Node root, Integer a, Integer b) {
		if (root == null)
			return null;
		if (root.getData() == a || root.getData() == b)
			return root;
		Node L = LeastCommonAncestor(root.getLeft(), a, b);
		Node R = LeastCommonAncestor(root.getRight(), a, b);
		if (L != null && R != null)
			return root;
		return (L != null ? L : R);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(30);
		n.setLeft(new Node(8));
		n.setRight(new Node(52));
		n.getLeft().setLeft(new Node(3));
		n.getLeft().setRight(new Node(20));
		n.getLeft().getRight().setRight(new Node(29));
		n.getLeft().getRight().setLeft(new Node(10));
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {
				String[] elem = line.split(" ");
				System.out.println(LeastCommonAncestor(n,
						Integer.valueOf(elem[0]), Integer.valueOf(elem[1]))
						.getData());
			}
		} catch (Exception e) {

		}

	}
}
