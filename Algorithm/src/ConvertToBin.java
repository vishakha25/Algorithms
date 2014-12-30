
public class ConvertToBin {
		public String convertBinaryS(int num){
			String bin="";
			while(num>0){
				bin=num%2+bin;
				num/=2;
			}
			return bin;
		}
		
		public int countOneBits(int num){
			String s=convertBinaryS(num);
			int count=0;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i)=='1'){
					count++;
				}
			}
			return count;
		}
		
		public int convertBinaryI(int num){
			int oldval=1;
			int newval=1;
			//System.out.println(b);
			while(num>0){
				//System.out.println(b);
				if(num%2==1){
					oldval=newval;
					newval=newval<<1;
					System.out.println(Integer.toBinaryString(newval));
					newval=newval^oldval;
					System.out.println(Integer.toBinaryString(newval));
				}
				else{
					
				}
				num=num/2;
			}
			return newval;
		}
		
		public int reverseBits(int num){
			int b=1;
			int rem;
			while(num>0){
				
			}
			return 0;
		}
		public static void main (String[] args){
			ConvertToBin cb1=new ConvertToBin();
			System.out.println(cb1.convertBinaryS(100));
			//System.out.println(cb1.convertBinaryI(11));
			//System.out.println(cb1.countOneBits(100));
			System.out.println(Integer.toBinaryString(cb1.reverseBits(100)));
		}
	
}
