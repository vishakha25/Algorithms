/*Dutch National Flag problem
 * 
 */
public class DNF {
	public int[] threeWaySort(int[] a){
		int i=0;
		int j=0;
		int temp;
		int n=a.length-1;
		while(j<=n){
			if(a[j]<2){
				temp=a[j];
				a[j++]=a[i];
				a[i++]=temp;	
			}
			else if(a[j]>2){
				temp=a[j];
				a[j]=a[n];
				a[n--]=temp;	
			}
			else{
				j++;
			}
			//printIntArray(a);
			//System.out.println();
		}
		return a;
	}
	public void threeWaySort2(int[] a){
		int count1=0;
		int count2=0;
		int count3=0;
		for(int x:a)
		if(x==1){
			count1++;
		}
		else if(x==2){
			count2++;
		}
		else if(x==3){
			count3++;
		}
		for(int i=0;i<count1;i++){
			System.out.print(1+ "  ");
		}
		for(int i=0;i<count2;i++){
			System.out.print(2+ "  ");
		}
		for(int i=0;i<count3;i++){
			System.out.print(3+ "  ");
		}
		
	}
	
	
	public static void printIntArray(int[] intArray){
		for(int x:intArray){
			System.out.print(x+ "  ");
		}
	}
	public static void main(String[] args) {
		DNF d1=new DNF();
		int[] a1={3,2,1,2,3,2,1,3,1,2,1,1,1,1,3,3,2,3,3,1,2,3,2,3,1,2};
		int[] b1={3,2,1,2,3,2};
		printIntArray(d1.threeWaySort(a1));
		System.out.println("DONE!");
		d1.threeWaySort2(a1);

	}

}
