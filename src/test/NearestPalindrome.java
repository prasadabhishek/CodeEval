package test;

public class NearestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 7957;
		String num = String.valueOf(a);
		int mid = String.valueOf(a).length() / 2;
		String rev = "";
		String half = "";
		for (int i = 0; i < mid; i++) {
			rev = rev + num.charAt(i);
			half = half + num.charAt(i);
		}
		for (int i = mid - 1; i > -1; i--) {
			rev = rev + num.charAt(i);
		}
		
		System.out.println(rev);
		
		int temp = 0;
		if (Integer.valueOf(rev) < a) {
			temp = Integer.valueOf(half) + 1;
		} else {
			temp = Integer.valueOf(half) - 1;
		}
		System.out.println(temp);
		
	}

}
