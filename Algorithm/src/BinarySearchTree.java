
public class BinarySearchTree<T extends Comparable<T>>  {
		   
	    private Node root;
	    private int size;
	    //store size of BST
	    
	    private class Node{
	        
	        Node left;
	        Node right;
	        T data; 
	        Node(T data){
	            this.data=data;
	        }
	    }
	    public boolean isEmpty(){
	        return size==0;
	    }
	 
	    public void insert(T item){
	        root=insert(root,item);
	    }
	    
	    private Node insert(Node x,T item){
	        if(x==null){
	             size++;
	             return new Node(item);
	             }
	        int cpmr= item.compareTo(x.data);
	        if(cpmr<0)    x.left=insert(x.left,item);
	        else if(cpmr>0)  x.right=insert(x.right,item);   
	        else{
	             System.out.println("Data item already exists in BST");
	            }
	        return x;
	        } 
	   public void inorder(){
	       inorder(root);
	   }
	   private void inorder(Node x){
	    if(x!=null){
	        inorder(x.left);
	        System.out.println(x.data);
	        inorder(x.right);
	    }
	}
	   public void preorder(){
		   preorder(root);
	   }
	   
	   private void preorder(Node x){
		if(x!=null){   
		   System.out.println(x.data);
		   preorder(x.left);
		   preorder(x.right);
		}
	   }
	   public void postorder(){
		   postorder(root);
	   }
	   
	   private void postorder(Node x){
		if(x!=null){   
		   preorder(x.left);
		   preorder(x.right);
		   System.out.println(x.data);
		}
	   }
	   
	   public boolean isBst(){
		   return isBst(root,null,null);
	   }
	   private boolean isBst(Node x,T min, T max){
		   if(x==null) return true;
		   if(min!=null && x.data.compareTo(min)<=0) 
		   {
			   System.out.println("In Min: " + min );
			   return false;
		   }
		   if(max!=null && x.data.compareTo(max)>=0) {
			   System.out.println("In Max" + max );
			   return false;
		   }
		   System.out.println("Min:  "+ min+  "    Max:  "+ max);
		   return isBst(x.left,min,x.data) && isBst(x.right,x.data,max);
	   }
	   
	   public int height(){
		   return height(root);
	   }
	   private int height(Node x){
		   if(x==null) return -1;
		   //return 1 + Math.max(height(x.left), height(x.right));
		   //Following without using max function
		   int hleft=height(x.left);
		   int hright=height(x.right);
		   if(hleft>hright){
			   return 1 + hleft;
		   }
		   else{
			   return 1+ hright;
		   }		  
	   }
	   
	   
	   
	   
}
	   

