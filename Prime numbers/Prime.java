import java.util.*;

public class Prime{
	public static void main(String[] args){
		LinkedList<Integer> primes = new LinkedList<Integer>();
		primes.addFirst(2);

		int nbrOfLoops = 0;

		for(int n=3; n<=Integer.parseInt(args[0]); n+=2){
			//check if the number is a prime
			boolean isPrime = true;
			ListIterator<Integer> itr = primes.listIterator(1);
			while(itr.hasNext() && isPrime){
				int i = itr.next();
				if(n % i == 0) isPrime = false;
				if(i > Math.sqrt(n)) break;
			}
			if(isPrime){
				primes.add(n);
			}
		}
		System.out.println(primes.size());
		System.out.println((double) primes.size() / (double) Integer.parseInt(args[0]));
		System.out.println("The numbers are");
		for(Integer e: primes){
			System.out.println(e);	
		}
		
		// System.out.println(primes);
	}

	
}