
public class Fibonacci {
	public int simpleFib(int n){
		if(n<2)
			return n;
		return simpleFib(n-1) + simpleFib(n-2);
	}
	public int fib(int n){
		int[] recordFib=new int[n+1];
		return calcFib(recordFib,n);
	}
	
	public int calcFib(int[] fibArray,int n){
		if(n<2){
			return n;
		}
		if(fibArray[n]>0){
			return fibArray[n]; 
		}
		else{
		fibArray[n]= calcFib(fibArray,n-1) + calcFib(fibArray,n-2);
		return fibArray[n];
		}
	}
	public int fibMatrix(int n){
		int[][] f={{1,1},{1,0}};
		int[][] m={{1,1},{1,0}};
		int w,x,y,z;
		for(int i=1;i<n-1;i++){
			w= (f[0][0]*m[0][0])+(f[0][1]*m[1][0]);
			x= (f[0][0]*m[0][1])+(f[0][1]*m[1][1]);
			y= (f[1][0]*m[0][0])+(f[1][1]*m[1][0]);
			z= (f[1][0]*m[0][1])+(f[1][1]*m[1][1]);	
			
			f[0][0]=w;
			f[0][1]=x;
			f[1][0]=y;
			f[1][1]=z;
			}
		return f[0][0];
	}
	
	public int fastFib( int n){
		int[][] f={{1,1},{1,0}};
		f=power(f,n-1);
		return f[0][0];
	}
	
	public int[][] power(int[][] F,int n){
		if(n==0 || n==1){
			return F;
		}
		int M[][]={{1,1},{1,0}};
		F=power(F,n/2);
		F=multiplyTwoD(F,F);
		if(n%2 !=0 )
			F=multiplyTwoD(F,M);
		return F;
	}
	
	public int[][] multiplyTwoD(int f[][],int m[][]){
		int w,x,y,z;
		w= (f[0][0]*m[0][0])+(f[0][1]*m[1][0]);
		x= (f[0][0]*m[0][1])+(f[0][1]*m[1][1]);
		y= (f[1][0]*m[0][0])+(f[1][1]*m[1][0]);
		z= (f[1][0]*m[0][1])+(f[1][1]*m[1][1]);	
		
		f[0][0]=w;
		f[0][1]=x;
		f[1][0]=y;
		f[1][1]=z;
		return f;
	}
	
	
	public void printArray(int[] a){
		for(int x:a){
			System.out.println(x+ "  ");
		}
	}
	
	public void printArrayTwoD(int[][] a){
		for(int x[]:a){
			for(int y:x){
				System.out.print(y +" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		Fibonacci f1=new Fibonacci();
		long startTime,endTime;
		startTime = System.currentTimeMillis();
		System.out.println(f1.fibMatrix(55));
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
		
		startTime = System.currentTimeMillis();
		System.out.println(f1.fib(55));
		 endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
		
		startTime = System.currentTimeMillis();
		System.out.println(f1.fastFib(55));
		 endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
	}

}
