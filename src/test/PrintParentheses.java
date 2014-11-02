package test;

public class PrintParentheses {
	/* Wrapper over _printParenthesis() */
	static void printParenthesis(int n) {
		if (n > 0)
			_printParenthesis(0, n, 0, 0);
		return;
	}

	static void _printParenthesis(int pos, int n, int open, int close) {
		char[] str = new char[100];

		if (close == n) {
			System.out.println(str);
			return;
		} else {
			if (open > close) {
				str[pos] = '}';
				_printParenthesis(pos + 1, n, open, close + 1);
			}
			if (open < n) {
				str[pos] = '{';
				_printParenthesis(pos + 1, n, open + 1, close);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		printParenthesis(n);

	}

}
