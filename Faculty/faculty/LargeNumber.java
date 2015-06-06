package faculty;

public class LargeNumber {

	public static String add(String n1, String n2){
		char[] longNumber;
		char[] shortNumber;
		if(n1.length() > n2.length()){
			longNumber = n1.toCharArray();
			shortNumber = n2.toCharArray();
		} else {
			longNumber = n2.toCharArray();
			shortNumber = n1.toCharArray();
		}
		int commonNumbers = Math.max(n1.length(), n2.length()) - Math.abs(n1.length()-n2.length());
		String result = "";
		int longIndex = longNumber.length-1;
		int shortIndex = shortNumber.length-1;
		int carry = 0;
		int iterationTimes = longIndex;
		for(int i=0; i<=iterationTimes; i++){
			char digit1 = longNumber[longIndex];
			longIndex--;
			char digit2 = '0';
			if(i < commonNumbers){
				digit2 = shortNumber[shortIndex];
				shortIndex--;
			}
			int n = Character.getNumericValue(digit1) + Character.getNumericValue(digit2) + carry;
			carry = n / 10;
			result = String.valueOf(n % 10) + result;
		}
		if(carry == 1){
			result = "1" + result;
		}
		return result;
	}
	
	// n smaller must be small enough so it can't parsed to an int
	public static String mult(String nBigger, String nSmaller){
		String result = "0";
		for(int i=0; i<Integer.parseInt(nSmaller); i++){
			result = LargeNumber.add(result, nBigger);
		}
		return result;
	}
	
	public static String faculty(String n){
		String result = "1";
		if(n.equals("0")){
			return result;
		}
		int nbr = Integer.parseInt(n);
		for(int i=0; i<Integer.parseInt(n); i++){
			result = LargeNumber.mult(result, String.valueOf(nbr));
			nbr--;
		}
		return result;
	}
	
}
