package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Stack;

public class LinkedList {
	static Node mainHead = null;
	static Boolean maindHeadSet = false;

	public static class Node {
		private Node next;
		private Node prev;
		private String data;

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node(String elem) {
			this.data = elem;
		}
	}

	public static void reverse(Node head) {
		if (head == null)
			return;
		Node curr = head;
		Node prev = null;

		while (curr != null) {
			Node next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		head = prev;
		mainHead = prev;
	}

	public static void reverseTill(Node head, Node till) {
		if (head == null)
			return;
		Node curr = head;
		Node prev = null;
		Node end = till.getNext();
		while (curr != end) {
			Node next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}

		head = prev;

		if (!maindHeadSet)
			mainHead = prev;
		else
			maindHeadSet = true;
	}

	public static void printList(Node n) {
		while (n != null) {
			if (n.getNext() != null)
				System.out.print(n.getData() + " -> ");
			else
				System.out.print(n.getData());
			n = n.getNext();
		}
		System.out.println("");
	}

	public static void reverseKnodes(Node head, int n) {
		Node done = null;
		int count = 0;
		LinkedHashMap<Node, Node> list = new LinkedHashMap<Node, Node>();
		Node curr = head;
		while (curr != null) {
			if (count < n - 1) {
				count++;
			} else {
				list.put(head, curr);
				head = curr.getNext();
				count = 0;
			}
			curr = curr.getNext();
		}

		for (Node node : list.keySet()) {
			reverseTill(node, list.get(node));
		}
	}

	public static Node reverseK(Node head, int k) {

		Node current = head;
		Node next = null;
		Node prev = null;
		int count = 0;

		/* reverse first k nodes of the linked list */
		while (current != null && count < k) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count++;
		}

		/*
		 * next is now a pointer to (k+1)th node Recursively call for the list
		 * starting from current. And make rest of the list as next of first
		 * node
		 */
		if (next != null) {
			head.setNext(reverseK(next, k));
		}

		/* prev is new head of the input list */
		return prev;
	}

	public static String hash(int m) {
		Node fastPointer = mainHead;
		Node slowPointer = mainHead;
		int count = 0;
		/* Run the fast pointer to mth node */
		while (count != m) {
			fastPointer = fastPointer.getNext();
			count++;
		}
		/* Now start the slow pointer */
		while (fastPointer != null) {
			fastPointer = fastPointer.getNext();
			slowPointer = slowPointer.getNext();
		}
		return slowPointer.getData();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {

				String[] elem = line.split(" ");

				Stack<String> s = new Stack<String>();
				s.addAll(Arrays.asList(elem).subList(0, elem.length - 1));

				Integer m = Integer.valueOf(elem[elem.length - 1]);

				// Ignore input if the index is too large or otherwise out of
				// bounds.
				if (m > s.size() || m < 1) {
					continue;
				}

				String result = s.pop();
				for (int i = 2; i <= m; i++) {
					result = s.pop();
				}

				System.out.println(result);

			}

		} catch (Exception e) {

		}
	}
}
