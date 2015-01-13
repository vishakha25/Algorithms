import java.util.Arrays;

public class MatrixSum {
	
	public int sumMatrix(int[][] matrix)
	{
		int sum=0;
		for(int[] a: matrix){
			for(int b:a){
				System.out.print(b+ "  ");
				sum+=b;
			}
			System.out.println();
		}
		return sum;
	}
	
	public int[][] verticalSum(int[][] matrix){
		int[][] result=new int[matrix.length+1][matrix[0].length+1];
		int x=0,y=0;
		for(int[] a:matrix){
			for(int b:a){
				result[x][y]=b;
				y++;
			}
			y=0;
			x++;
		}
		int sumV=0;
		int sumH=0;
		int i=0;
		int j=0;
		for(;i<result.length-1;i++){
			for(;j<result[i].length-1; j++){
				sumH+=matrix[i][j];
				sumV+=matrix[j][i];
			}
			result[i][j]=sumH;
			result[j][i]=sumV;
		}
		return result;
	}
	
	public int[][] transpose(int[][] matrix)
	{
		int[][] trans=new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				trans[i][j]=matrix[j][i];
			}
			
		}
		return trans;
	}
	
	public boolean find(int[][] matrix,int n){
		int row=0; 
		int col=matrix[0].length-1;
		while(row<matrix.length-1 && col>=0){
			if(matrix[row][col]==n){
				return true;
			}
			else if(matrix[row][col]>n){
				col--;
			}
			else{
				row++;
			}
		}
		return false;

	}
	
	public void spiralPrint(int[][] a){
	    int i, rowStart = 0, colStart = 0;
	    int rowEnd=a.length ,colEnd= a[0].length;
	    System.out.print("Row End "+ rowEnd+ "  Col End  "+ colEnd);
	    while (rowStart < rowEnd && colStart < colEnd)
	    {
	        /* Print the first row from the remaining rows */
	        for (i = colStart; i < colEnd; ++i)
	        {
	            System.out.format("%d ", a[rowStart][i]);
	        }
	        rowStart++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = rowStart; i < rowEnd; ++i)
	        {
	        	 System.out.format("%d ", a[i][colEnd-1]);
	        }
	        colEnd--;
	 
	        /* Print the last row from the remaining rows */
	        if ( rowStart < rowEnd)
	        {
	            for (i = colEnd-1; i >= colStart; --i)
	            {
	            	 System.out.format("%d ", a[rowEnd-1][i]);
	            }
	            rowEnd--;
	        }
	 
	        /* Print the first column from the remaining columns */
	        if (colStart < colEnd)
	        {
	            for (i = rowEnd-1; i >= rowStart; --i)
	            {
	            	 System.out.format("%d ", a[i][colStart]);
	            }
	            colStart++;    
	        }        
	    }
	}

	

	public void printArray(int[][] matrix){
		for(int i=0;i<6;i++){
			for(int j=0;j<4;j++)
			{
				System.out.print(matrix[i][j]+ "   ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixSum ms1=new MatrixSum();
		int[][] x=new int[6][4];
		int count=1;
		for(int i=0;i<6;i++){
			for(int j=0;j<4;j++)
			{
				x[i][j]=count++;
			}
		}
		//System.out.println(ms1.sumMatrix(x));
		//int[][] x1=ms1.transpose(x);
		//System.out.println(ms1.find(x,18));
		//System.out.println(ms1.sumMatrix(x));
		//ms1.printArray(ms1.verticalSum(x));
		ms1.printArray(x);
		ms1.spiralPrint(x);
		//ms1.printArray(x);
		//ms1.printArray(x1);
	}

}
