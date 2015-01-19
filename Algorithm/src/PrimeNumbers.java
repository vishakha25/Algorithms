import java.math.*;
public class PrimeNumbers {
		public boolean isPrime1(long num){
			/*Takes a number and 
			 * returns if it is a
			 * prime number
			 * in O(n) time
			 */
			for(int x=2;x<=num/2;x++){
				if(num%x==0){
					return false;
				}
			}
			return true;
		
		}
		public boolean isPrime(long num){
			/*Takes a number and 
			 * returns if it is a
			 * prime number
			 * in O(n) time
			 */
			if (num==2||num==3||num==5)
			{
				return true;
			}
			if(num%2==0 || num %3==0 || num%5==0){
				return false;
			}
			for(int x=7;x<=Math.sqrt(num);x+=2){
				if(num%x==0){
					return false;
				}
			}
			return true;
		
		}
		
		public void largePrime(long num){
			/**This function takes a number 
			 * and gives the next largest prime number
			 * 
			 */
			long largeprime=num;
			while(true){
			if(isPrime(largeprime)==true){
				System.out.println("Prime number greater than "+ num+ "= " + largeprime);
				break;
			}
			else{
				largeprime++;
			}
			}	
		}
		
	public void generatePrime(int num){
		boolean[] b1= new boolean[num+1];
		for(int a=1;a<=num;a++){
			b1[a]=true;
		}
		for(int i=2;i*i<num;i++){
			for(int j=2;i*j<num;j++){
				b1[i*j]=false;
			}
		}
		for(int i=0;i<num;i++){
			if(b1[i]==true){
				System.out.println(i);
			}
		}
		
	}	
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeNumbers p1=new PrimeNumbers();
		System.out.println(p1.isPrime(10));
		System.out.println(p1.isPrime(17));
		System.out.println(p1.isPrime(19));
		System.out.println(p1.isPrime(2));
		p1.largePrime(1000000004);
		p1.generatePrime(100);
		
	}

}
