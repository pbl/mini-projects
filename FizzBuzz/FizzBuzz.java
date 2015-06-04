import java.lang.StringBuilder;

public class FizzBuzz{
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();

		for(int i=1; i<Integer.parseInt(args[0]); i++){
			sb.append(fizzBuzz(i) + "\n");
		}
		System.out.println(sb);
	}

	public static String fizzBuzz(int i){
		String str = "";
		if(i % 3 == 0) str += "Fizz";
		if(i % 5 == 0) str +=  "Buzz";
		if(str.isEmpty()) str = String.valueOf(i);
		return str;
	}
}