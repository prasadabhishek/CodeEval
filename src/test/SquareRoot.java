package test;

public class SquareRoot {
	
	static float sqrt(float n) {
		float low = 0, high = n;
		float mid = (low + high) / 2;
		while (Math.abs(mid * mid - n) > 0.00001) {
			if (mid * mid < n)
				low = mid;
			else if (mid * mid > n)
				high = mid;
			mid = (low + high) / 2;
		}
		return mid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(25f));
	}

}
