package test;

public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 13; i++) {
			for (int j = 1; j < 13; j++) {
				if (j < 2)
					System.out.print(i * j);
				else
					System.out.format("%4d", i * j);
			}
			System.out.println();
		}
	}

}
