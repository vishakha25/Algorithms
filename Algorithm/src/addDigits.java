
public class addDigits {
	public int addNum(int num){
		/*adding digits of a number,
		 * For example: 123 -> Result:6 <- 1+2+3
		 */
		if(num<0){
			//making number positive
			num=0-num;
		}
		int result=0;
		//int rem;
		while(num>0){
		//	rem=num%10;
			//result+=rem;
			result+=(num%10);
			num=num/10;
		}
		if(result>9){
			/*if the result has more than 1 digit,
			* reursive call the function until single digit left in sum
			*/
			System.out.println(result);
			result=addNum(result);
		}
		return result;	
	}
	
	public int addNumRec(int num){
		//recursive way of doing same algorithm above
		//can also add check for negative numbers
		int result=addN(num);
		if (result>9){
			result=addNumRec(result);
		}
		return result;
	}
	
	int addN(int n){
		if(n<1)
			return 0;
		else
			return n%10+addN(n/10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addDigits a1=new addDigits();
		//System.out.println(a1.addNum(1999945));
		System.out.println(a1.addNumRec(99));
	}

}
