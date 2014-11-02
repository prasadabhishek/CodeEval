package test;

public class TowerOfHanoi {

	public static void print(int n, int beg, int to, int aux) {
		System.out.println("Move " + beg + " ----> " + to);
	}

	public static void hanoi(int n, int beg, int end, int aux) {
		if (n == 1) {
			print(1, beg, end, aux);
			return;
		}
		hanoi(n - 1, beg, aux, end);
		print(1, beg, end, aux);
		hanoi(n - 1, aux, end, beg);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		hanoi(n, 1, 3, 2);
	}

}
