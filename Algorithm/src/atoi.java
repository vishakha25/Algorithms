import java.util.ArrayList;

//program to convert string to ascii
public class atoi {
	public int convertToint(String value){
		char c;
		@SuppressWarnings("unused")
		int charcount=0;
		int base=10;
		int result = 0;
		if (value==null || value.length()==0){
			return 0;
		}
		int i=0;
		boolean negative=false;
		if(value.charAt(i)=='-'){
			negative=true;
			i++;
		}
		for(;i<value.length();i++){
			 c=value.charAt(i);
			 if(c>47 && c<58){
				 result*=base;
				 result+=(c-48);
				 //System.out.println(result);
				 //System.out.println(c);
			 }
			 else{
				 charcount+=1;
			 }
			 
		}
		if(negative){
			result=0-result;
		}
		//System.out.println("Character found= "+ charcount);
		return result;	
	}
	
	public int convertSumInt(String value){
		char c;
		@SuppressWarnings("unused")
		int charcount=0;
		int base=10;
		int result = 0;
		if (value==null || value.length()==0){
			return 0;
		}
		int i=0;
		int j=0;
		boolean negative=false;
		int[] values=new int[value.length()];
		for(;i<value.length();i++){
			 c=value.charAt(i);
			 if(value.charAt(i)=='-'){
					negative=true;
				}
			 else if(c>47 && c<58){
				 result*=base;
				 result+=(c-48);
				 //System.out.println(result);
				 //System.out.println(c);
			 }
			 else{
				 if(negative){
					 result=0-result;
					 negative=false;
				 }
				 values[j]=result;
				 j++;
				 result=0;
				 charcount+=1;
			 }
		}
		int sum=0;
		for(int x:values){
			sum+=x;
		}
		
		//System.out.println("Character found= "+ charcount);
		return sum;	
	}
	
	public String covertToAscii(int num){
		//char[] result=new char[12]; //Max length of integer is 10, and one character to store '-' sign
		
		String result="";
		//int i=result.length -1;
		int rem;
		if(num==0){
			return "0";
		}
		boolean negative=(num<0);
		if(negative){
			num=0-num;
		}
		//works for integers with base 10
		while(num>0){
			rem=num%10;
			num=num/10;
			result=(char)(rem+'0')+result;
		}
		if(negative){
			result="-"+result;
		}
		return result;
	}
		//print char array
		public void printCharArray(char[] charArray){
		for(char x:charArray){
			System.out.print(x);
		}
		System.out.println();
	}
	
	public String convertFToS(float num){
		return "Hello";
	
	}
		
	public int calculateExp(String exp){
		//Doesn't consider BODMAS rules
		
		
		int i=0;
		String num="";
		ArrayList<Integer> intlist= new ArrayList<>();
		ArrayList<Character> oplist=new ArrayList<>();
		char[] a1=exp.toCharArray();
		while(i<a1.length){
			if(a1[i]>47 && a1[i]<58){
				num+=a1[i];
				i++;
			}
			else{
				intlist.add(convertToint(num));
				//System.out.println(intlist.get(0));
				num="";
				oplist.add(a1[i++]);
			}
		}
		intlist.add(convertToint(num));
		int j=0;
		int m=0;
		int result=intlist.get(j++);
		while (j<intlist.size()){
			char x=oplist.get(m);
			m++;
			if(x=='+'){
				result=result+intlist.get(j);
			}
			else if(x=='-'){
				result=result-intlist.get(j);
			}
			else if(x=='*'){
				result=result*intlist.get(j);
			}
			else if(x=='/'){
				result=result/intlist.get(j);
			}
			else if(x=='%'){
				result=result%intlist.get(j);
			}
			j++;
		}
		return result;
	}
		
	
	public static void main(String[] args) {
		atoi obj1=new atoi();
		//System.out.println(obj1.covertToAscii(765398));
		//obj1.printCharArray(res);
		//System.out.println(obj1.covertToAscii(-765398));
		//obj1.printCharArray(res1);
		//int num=100232;
		//String s=num+"";
		//System.out.println(obj1.convertToint("-12vishakha34t224d5"));
		System.out.println(obj1.convertSumInt("1v2c-30f40v"));
		String expression="100+10-20*30";
		//System.out.println(obj1.calculateExp(expression));
	}

}
