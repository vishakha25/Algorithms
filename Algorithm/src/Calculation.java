
public class Calculation {
	public int power(int num,int exp){
		if(exp==0){
			return 1;
		}
		int result=1;
		while(exp!=0){
			if((exp&1)==1){
				result*=num;
			}
			exp=exp>>1;
			num*=num;
		}
		return result;
	}
	
	public int maxThree(int a,int b, int c){
		if(a>b && a>c)
				return a;
		else if(b>c)
			return b;
		else
			return c;
	}
	
	
	public void sortThree(int a, int b, int c){
		
		if(a<b){
			int temp=a;
			a=b;
			b=temp;
		}
		if(b<c){
			int temp=b;
			b=c;
			c=temp;
		}
		if(a<b){
			int temp=a;
			a=b;
			b=temp;
		}
		System.out.println(a+"  "+b+"  "+ c);
		
	}
	
	/*Returns the square root of n. Note that the function */
	float squareRoot(float n)
	{
	  /*We are using n itself as initial approximation
	   This can definitely be improved */
	  float result = n;
	  float b = 1;
	  float e = 0.01f; /* e decides the accuracy level*/
	  while(result - b > e)
	  {
	    result = (result + b)/2;
	    b = n/result;
	  }
	  return result;
	}
	 
	public boolean perfectSquare(int num){
		int mid,result;
		int hi=num/2;
		int lo=0;
		boolean flag=false;
		while(!flag){
			mid= (hi+lo)/2;
			result=mid*mid;
			if(result==num){
				System.out.println("Perfect Square of "+mid);
				flag=true;
			}	
			else if(result<num && lo<mid){
				lo=mid;
				System.out.println("lo="+lo+"   hi="+ hi+"   mid="+mid);
				continue;
			}
			else if(result>num && hi>mid){
				System.out.println("lo="+lo+"   hi="+ hi+"   mid="+mid);
				hi=mid;
				continue;
			}
			else{
				break;
			}
		}
		
		return flag;
		}
	
	public int divide(int a, int b) throws Exception{
		if(a<b){
			return 0;
		}
		if(b==0){
			throw new ArithmeticException();
		}
		int i=1;
		//dividing without using division operator
		while((i*b)<a){
				i++;
		}
		while(i*b>a){
			i--;
			}
		return i;
	}
	
	public String toRoman(int n){
		String roman="";
        int repeat;
        int magnitude[]={1000,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String symbol[]={"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        repeat=n/1;
        for(int x=0; n>0; x++){
            repeat=n/magnitude[x];
            for(int i=1; i<=repeat; i++){
                roman=roman + symbol[x];
            }
            n=n%magnitude[x];
        }
        return roman;
    }
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Calculation c1=new Calculation();
		//System.out.println(c1.divide(300,10));
		//System.out.println(c1.perfectSquare(423724));
		//System.out.println(c1.toRoman(3500));
		//System.out.println(c1.power(5,10));
		c1.sortThree(6, 3, 8);
		//float num=c1.squareRoot(1000);
		//System.out.println(num);
		//System.out.format("%-3.3f", num);
		
	}
}
