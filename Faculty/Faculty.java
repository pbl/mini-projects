public class Faculty{
	public static void main(String[] args){
		
		// int a = 0;
		int n = 10;
		long sum = 3628000;  
		System.out.println(Integer.MAX_VALUE/1000);
		while(n<15){
			long elapsedTime = System.currentTimeMillis();
			// for(int i=0; i<sum; i++){
			// 	a = a+1;
			// }
			System.out.println("Number of loops: " + sum);
			System.out.println("Elapsed time in seconds for faculty " + n + ": " + (System.currentTimeMillis() - elapsedTime) / 1000);	
			n++;
			sum = sum*n;
			
		}
		
	}
}