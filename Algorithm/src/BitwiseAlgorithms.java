import java.util.ArrayList;
import java.util.Arrays;

public class BitwiseAlgorithms {
	
	public int countOneBit(int num){
		int count=0;
		while(true){
			if((num&1)==1){
				count++;
			}
			if(num!=0){
			num>>>=1;
			}
			else{
				break;
			}
		}
		return count;
		
	}
	
	void findSingleinDups(int numbers[]){ 
	    if (numbers.length < 2)
	        return;

	    int resultExclusiveOR = 0;
	    for (int i = 0; i < numbers.length; ++ i) 
	        resultExclusiveOR ^= numbers[i];
	    
	   // System.out.println("XOR result" +Integer.toBinaryString(resultExclusiveOR));
	    int indexOf1 = findFirstBitIs1(resultExclusiveOR);

	    int num1=0;
	    int num2=0;
	    for (int j = 0; j < numbers.length; ++ j) {
	        if(isBit1(numbers[j], indexOf1)){
	            num1 ^= numbers[j];
	            //System.out.println("1: num[j]"+numbers[j]+" in binary= "+Integer.toBinaryString(numbers[j]));
	        	//System.out.println("Num1: " +Integer.toBinaryString(num1));
	        }
	        else{
	            num2 ^= numbers[j];
	            //System.out.println("2:num[j]"+numbers[j]+" in binary= "+Integer.toBinaryString(numbers[j]));
	           // System.out.println("Num2:" +Integer.toBinaryString(num2));
	        }
	    }
	    System.out.println(+ num1+ "  "+ num2);
	}

	// The first 1 bit from the rightmost
	int findFirstBitIs1(int num){
	    int indexBit = 0;
	    while (((num & 1) == 0) && (indexBit < 32)) { 
	    	System.out.println("In find first bits1 = " +Integer.toBinaryString(num));
	        num = num >> 1;
	    	System.out.println("In find first bits2 = " +Integer.toBinaryString(num));
	        ++ indexBit;
	    }
	    
	    return indexBit;
	}

	// check whether the bit with index indexBit is 1 
	boolean isBit1(int num, int indexBit) {
	    num = num >> indexBit;
	    return (num & 1) == 1;

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitwiseAlgorithms ba1=new BitwiseAlgorithms();
		int num=7;
		int[] nums={2,3,4,4,5,6,6,5};
		
		//System.out.println(Integer.toBinaryString(num));
		//System.out.println(ba1.countOneBit(num));
		ba1.findSingleinDups(nums);
		
		
	}

}
