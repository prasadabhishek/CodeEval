package test;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[] { 4, 3, 13, 2, 22, 4, 3, 13, 2, 22, 4, 3, 13, 2, 22 };
		Stack<Integer> s = new Stack<Integer>();

		/* Add first element into stack */
		s.push(a[0]);
		int count = 1;
		while (count < a.length) {
			int temp = s.peek();
			if (temp < a[count]) {
				// result.put(temp, a[count]);
				System.out.println(temp + " | " + a[count]);
				s.pop();
				if (s.isEmpty()) {
					s.push(a[count]);
					count++;
				}
			} else {
				s.push(a[count]);
				count++;
			}
		}
		while (!s.isEmpty()) {
			System.out.println(s.pop() + " | " + -1);
		}

	}
}
