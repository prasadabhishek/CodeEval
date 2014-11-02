package test;

public class IsZeroPossible {
	static Integer IsPossible(int[] a, int n, int sum) {
		if (n == 1)
			if (sum == Math.abs(a[0]))
				return 1;
			else
				return 0;
		return IsPossible(a, n - 1, sum + a[n - 1])
				| IsPossible(a, n - 1, sum - a[n - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 10, 5, 5 };
		if (IsPossible(a, a.length, 0) == 1)
			System.out.println("True");
	}

}
