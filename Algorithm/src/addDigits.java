
public class addDigits {
	
	public int addNum(int num){
		if(num<0){
			num=0-num;
		}
		int result=0;
		int rem;
		while(num>0){
			rem=num%10;
			result+=rem;
			num=num/10;
		}
		if(result>9){
			System.out.println(result);
			result=addNum(result);
		}
		return result;	
	}
	
	
	public int addNumRec(int num){
		int result=addN(num);
		if (result>9){
			result=addNumRec(result);
		}
		return result;
	}
	
	int addN(int n){
		int result;
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
