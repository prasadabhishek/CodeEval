package test;

public class AddBinaryStrings {

	public static String getAddition(Character a, Character b) {
		if (a == '0' && b == '0') {
			return "0";
		} else if (a == '1' && b == '1') {
			return "0";
		} else {
			return "1";
		}
	}

	public void addBinaryStrings(String a, String b) {
		String result = "";
		String carry = "0";

		Integer la = a.length();
		Integer lb = b.length();

		while (lb > -1 || la > -1) {
			char cha = ' ';
			char chb = ' ';
			if (la > 0)
				cha = a.charAt(la - 1);
			if (lb > 0)
				chb = b.charAt(lb - 1);

			String digit = "";
			if (lb > 0 && la > 0)
				digit = getAddition(cha, chb);
			else if (la > 0 && lb <= 0)
				digit = String.valueOf(cha);
			else
				digit = String.valueOf(chb);

			if (carry == "1")
				digit = getAddition(digit.charAt(0), carry.charAt(0));
			if ((cha == '1' && chb == '1')
					|| (carry.charAt(0) == '1' && cha == '1')
					|| (carry.charAt(0) == '1' && chb == '1'))
				carry = "1";
			else
				carry = "0";
			result = result + digit;
			lb--;
			la--;
		}
		if (carry == "1")
			result = result + "1";

		System.out.println(new StringBuilder(result).reverse().toString());
	}

	public static void main(String[] args) {	

		AddBinaryStrings astr = new AddBinaryStrings();

		astr.addBinaryStrings("101", "1111");

	}

}
