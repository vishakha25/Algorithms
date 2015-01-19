
public class rotatedArray {

	public boolean search(int[] arr, int num){
		int hi=arr.length-1;
		int lo=0;
		int mid;
		boolean flag=false;
		while(!flag){
			mid=(hi+lo)/2;
		if(arr[mid]==num){
			System.out.println("Element found at pos.:"+mid);
			flag=true;
		}
		else if(arr[mid]>num){
			if(num<arr[hi]){
				lo=mid;
			}
			else{
				hi=mid;
			}
			continue;
		}
		else if(arr[mid]<num ){
			if(num>arr[lo]){
				hi=mid;
		}
			else{
				lo=mid;
			}
			continue;
		}
		else{
			break; 
		}
		
		}
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rotatedArray ra1=new rotatedArray();
		int[] a={3,4,5,6,7,8,1,2}; 
		int[] b={7,8,9,1,2,3,4,5,6}; 
		System.out.println(ra1.search(b,4));

	}

}
