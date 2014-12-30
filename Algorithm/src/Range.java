//[4, 5, 6, 7, 8, 9, 12, 15, 16, 17, 18, 20, 22, 23, 24, 27]
/*Given a sorted array with some sequenced numbers and some non-sequenced numbers.
 *  Write an algorithm that takes this array as an input and returns a list of {start, end} 
 *  of all consecutive numbers. Consecutive numbers have difference of 1 only. 
 */
import java.util.ArrayList;
		
public class Range {
	 private int begin;
	 private int end;
	 //Range(int begin,int end){
		// this.begin=begin;
		 //this.end=end;
	 //}
	 	
	public void beginSet(int begin){
		this.begin=begin;
	}
	public int beginGet(){
		return this.begin;
	}
	public void endSet(int end){
		this.end=end;
	}
	public int endGet(){
		return this.begin;
	}
	
	public static ArrayList<Range> getRange(int[] intArray){
		ArrayList<Range> rangelist=new ArrayList<>();
		int i=0;
		int start=0;
		int endi;
		while(i<intArray.length-1){
			
				if(intArray[i+1]-intArray[i]==1){
					i++;
				}
				else{
					endi=i;
					if(start!=endi){
						Range r1=new Range();
						r1.beginSet(start);
						r1.endSet(endi);
						rangelist.add(r1);
						//System.out.println(start);
						//System.out.println(endi);
					}
					i++;
					start=i;
				}
		}
		return rangelist;
	}
	
	
	public static ArrayList<Range> getRangeBin(int[] intArray){
		/*** using binary search
		 * in process
		 */
		int start=0;
		int end=intArray.length-1;
		ArrayList<Range> rangelist=new ArrayList<>();
		while(start<end){
			int rangeend=findEnd(intArray, start, end);
			if(rangeend!=start){
				Range r1=new Range();
				r1.beginSet(start);
				r1.endSet(rangeend);
				rangelist.add(r1);
			}
			else{
				start++;
			}
		}
		return rangelist;
	}
	
	public static int findEnd(int[] intArray, int start, int end){
		int mid;
		while(start<end){
			mid=(start+end)/2;
			if(mid-start==intArray[mid]-intArray[start]){
				if(mid-start+1==intArray[mid+1]-intArray[start])
				{
					System.out.println("end found"+mid);
					return mid;
				}
				else{
					start=mid+1;
					continue;
				}
			}
			else{
				end=mid-1;			
			}
		}
		return start;
	}
	
	public static void printArrayList(ArrayList<Range> a1){
		for(int i=0;i<a1.size();i++){
			System.out.print(a1.get(i).begin);
			System.out.print(" , ");
			System.out.print(a1.get(i).end);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] a= {4, 5, 6, 7, 8, 9, 12, 15, 16, 17, 18, 20, 22, 23, 24, 27};
		ArrayList<Range> a1=getRange(a);
		printArrayList(a1);		
	}

}
