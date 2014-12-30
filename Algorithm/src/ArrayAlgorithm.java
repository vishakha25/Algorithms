import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
public class ArrayAlgorithm {

	public int majority(int[] intArray){
		if(intArray.length<3){
			throw new IllegalArgumentException("Array too small for majority.");
		}
		System.out.println(intArray.length);
		HashMap<Integer,Integer> map1=new HashMap<>();
		int majoritycount=intArray.length/2;
		for(int x:intArray){
			if(map1.containsKey(x)){
				if(map1.get(x)>=majoritycount){
					return x;
				}
				map1.put(x, map1.get(x)+1);
			}
			else{
				map1.put(x, 1);
			}
		}
		return -1;
	}
	
	public int countOccurences(int[] intArray,int num){
		int index=binarysearch(intArray, num);
		int mid=index+1;
		int count=0;
		if(index<0){
			throw new IllegalArgumentException("Number not found");
		}
		else{
			while(intArray[index]==num){
				count++;
				if(index==0){
					break;
				}
				index--;
			}
			while(intArray[mid]==num){
				count++;
				if(mid==intArray.length-1){
					break;
				}
				mid++;
			}
		}
		return count;
	}
	
	public void findSum(int[] n, int sum){
		HashMap<Integer,Integer> map1=new HashMap<>();
		for(int x:n){
			if(map1.containsKey(x)){
				System.out.println("Pair Found: ");
				System.out.println(x+" , "+ map1.get(x));
			}
			else{
				map1.put(sum-x, x);
			}
		}	
	}
	
	public void findSumSorted(int [] n,int sum){
		int i=0;
		int j=n.length-1;
		while(i<j){
			if(n[i]+n[j]==sum){
				System.out.println("Pair Found");
				System.out.println(n[i]+ " , " +n[j]);
				i++;
				continue;
			}
			else if(n[i]+n[j]>sum){
				j--;
			}
			else{
				i++;
			}
		}
		
	}
	
	public int binarysearch(int[] intArray,int num){
		int low=0;
		int high=intArray.length;
		int mid;
		while(low<high){
			mid=(low+high)/2;
			if(intArray[mid]==num){
				return mid;
			}
			else if(intArray[mid]>num){
				high=mid;
			}
			else{
				low=mid;
			}
		}
		return -1;
				
	}
	
	public int bigInt(int n){
		/* Takes a num and returns next big integer formed using numbers in
		 * the given int. 
		 */
		String s=Integer.toString(n);
		//System.out.println(s);
		char[] a=s.toCharArray();
		//printArray(a);
		int swapIntBigIndex=-1, swapIntSmallIndex=-1;
		int i=a.length-1;
			while(i>0){
				if(a[i]>a[i-1]){
					//System.out.println(i);
					swapIntSmallIndex=i-1;
					swapIntBigIndex=i;
					break;
				}
				else{
					i--;
					if(i==0){
						//throw new IllegalArgumentException("Can't find bigger number");
						System.out.println("Can't find bigger number");
						System.exit(0);
					}
				}
				
			}
			
			//System.out.println("big"+ swapIntBigIndex+ "Small"+ swapIntSmallIndex);
			
			for(int j=i;j<a.length-1;j++){
				if(a[j]>a[swapIntSmallIndex] && a[j]<a[swapIntBigIndex]){
					swapIntBigIndex=j;
				}
			}
			//swapping
			char temp=a[swapIntBigIndex];
			a[swapIntBigIndex]=a[swapIntSmallIndex];
			a[swapIntSmallIndex]=temp;
			Arrays.sort(a,swapIntSmallIndex+1,a.length);
		
			int finalInt=Integer.parseInt(new String(a));
			assert(finalInt>n);
			return finalInt;
	}
	
	public int median(int[] a){
		Arrays.sort(a);
		int len=a.length;
		if(len%2==0){
			return ((a[len/2]+a[len/2+1])/2);
		}
		else{
			return a[len/2];
		}
	} 
	
	public int[] topThree(int[] a){
		if(a.length<3){
			throw new IllegalArgumentException("Array too Small to get top 3 elements");
		}
		Arrays.sort(a);
		int[] result=new int[3];
		result[0]=a[a.length-1];
		result[1]=a[a.length-2];
		result[2]=a[a.length-3];
		return result;
	}
	
	public int[] findSingles(int[] a){
		HashMap<Integer,Integer> map1=new HashMap<>();
		for(int x:a){
			if(map1.containsKey(x)){
				map1.remove(x);
			}
			else{
				map1.put(x, 1);
			}
		}
		int i=0;
		int[] result=new int[map1.size()];
		Set<Integer> keys=map1.keySet();
		for(Integer x:keys){
			result[i++]=x;
		}
		return result;
		
		
	}
	
	public int[] findDuplicates(int[] a){
		HashMap<Integer,Integer> map1=new HashMap<>();
		ArrayList<Integer> result=new ArrayList<>();
		for(int x:a){
			if(map1.containsKey(x)){
				result.add(x);
			}
			else{
				map1.put(x, 1);
			}
		}
		int[] r=new int[result.size()];
		int j=0;
		for(Integer x:result){
			r[j++]=x;
		}
		return r;
	}
	
	public static void main(String[] args) {
		ArrayAlgorithm aa1= new ArrayAlgorithm();
		int[] a1={1,2,2,2,2,2,2,2,4,4,5,6};
		int[] b1={12,5,3,6,8,15,11,7,2,4};
		int[] c1={1,2,3,4,5,6,7,8,9,10,11,12};
		int[] d1={6,5,2,6,4,5,2,3,7,8,3};
		System.out.println(aa1.majority(a1));
		System.out.println(aa1.countOccurences(a1, 4));
		System.out.println(aa1.bigInt(3512345));
		System.out.println(aa1.median(b1));
		
		printIntArray(aa1.findSingles(d1));
		System.out.println();
		printIntArray(aa1.findDuplicates(d1));
		aa1.findSum(b1, 12);
		aa1.findSumSorted(c1, 8);
		
	}
	
	public int[] multiplyArray(int[] a,int[] b){
		int prod=1;
		for(int x:b){
			prod*=x;
		}
		int[] c=new int[a.length];
		for(int i=0;i<a.length;i++){
			if(i<b.length){
				c[i]=(a[i]*prod)/b[i];
				}
			else{
				c[i]=(a[i]*prod);
			}
		}
		return c;
	}
	
	public int[] multiplyArrayAll(int[] a,int[] b){
		int[] left=new int[b.length];
		int[] right=new int[b.length];
		int[] result=new int[a.length];
		int prod=1;
		for(int i=0;i<b.length;i++){
			left[i]=prod;
			prod*=b[i];
			
		}
		prod=1;
		for(int i=b.length-1;i>=0;i--){
			right[i]=prod;
			prod*=b[i];
			}
		for(int i=0;i<b.length;i++){
			b[i]=left[i]*right[i];
		}
		for(int i=0;i<a.length;i++){
			result[i]=a[i]*b[i];
		}
		return result;
	
	}
	
	public static void printIntArray(int[] intArray){
		for(int x:intArray){
			System.out.print(x+ "  ");
		}
	}
}
