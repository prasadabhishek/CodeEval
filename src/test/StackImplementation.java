package test;

import java.io.BufferedReader;
import java.io.FileReader;

public class StackImplementation {

	public static class Stack {
		private Node head;
		private Node top;

		public Node getHead() {
			return head;
		}

		public void setHead(Node head) {
			this.head = head;
		}

		public Node getTop() {
			return top;
		}

		public void setTop(Node top) {
			this.top = top;
		}

		public void push(Integer val) {
			if (getHead() == null) {
				Node n = new Node(val);
				setHead(n);
				setTop(n);
			} else if (getHead().getNext() == null) {
				setTop(new Node(val));
				getHead().setNext(this.top);
				getTop().setPrev(this.head);
			} else {
				Node n = new Node(val);
				getTop().setNext(n);
				n.setPrev(getTop());
				setTop(n);
			}
		}

		public Integer pop() {
			if (top == null)
				return null;
			else {
				int result = top.getData();
				Node prev = top.getPrev();
				if (prev != null) {
					prev.setNext(null);
				}
				top = prev;
				return result;
			}
		}

		public void printStack() {
			if (head == null)
				System.out.println("Empty Stack");
			else {
				Node temp = top;
				while (temp != null) {
					System.out.println(temp.getData());
					temp = temp.getPrev();
				}
			}
		}
	}

	public static class Node {
		private Integer data;
		private Node next;
		private Node prev;

		public Node(Integer val) {
			this.data = val;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

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

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(
					"C:\\Users\\Abhishek\\Desktop\\input.txt"));
			String line;
			while ((line = in.readLine()) != null) {

				Stack s = new Stack();

				String[] split = line.split(" ");

				for (int i = 0; i < split.length; i++) {
					s.push(Integer.valueOf(split[i]));
				}
				int count = 0;
				while (s.getTop() != null) {
					if (count == 0)
						System.out.print(s.pop());
					else
						System.out.print(" " + s.pop());
					s.pop();
					count++;
				}
				System.out.println();
			}
		} catch (Exception e) {

		}

	}

}
