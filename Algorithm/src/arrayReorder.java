import java.util.Stack;


public class arrayReorder {

	public static void main(String[] args) {
		int[] a={1,2,3,4,5,6,7,8,9,100,200,300,400,500,600,700,800,900};
		//int[] a={1,2,3,4,10,20,30,40};
		a=alternate(a);
		printIntArray(a);
		}
	
	public static int[] alternate(int[] a){
		Stack<Integer> s1=new Stack<>();
		int mid=a.length>>1;
		System.out.println(a.length + "  "+ mid);
		for(int i=mid-1;i>=0;i--){
			s1.push(a[i]);
		}
		for(int i=0;mid<a.length;){
			System.out.println("I: "+ i + "   Mid: "+mid);
			a[i++]=s1.pop();
			a[i++]=a[mid++];
		}
		return a;
	}
	
	
	public static void alternate(int[] a, int n){
		if(n==1){
			a=swap(a,n,n+1);
			return;
		}
		int d=n*2;
		int mid=n/2;
		if(n%2==1){
			//if half of number of elements is odd 
			int temp=a[n];
			for(int i=n+1;i<d;i++)
			{
				a[i-1]=a[i];
			}
			a[d]=temp;
			--n;
		}
		for (int i = mid + 1; i <= n; ++i)
		{
			a=swap(a,i,i+mid);
		}
		alternate(a,mid);
		alternate(a,mid);
	}
	public static int[] swap(int[] a, int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		return a;
	}
	
	public static void printIntArray(int[] intArray){
		for(int x:intArray){
			System.out.print(x+ "  ");
		}
		System.out.println();
	}
	

}
