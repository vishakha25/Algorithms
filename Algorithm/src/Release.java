import java.util.ArrayList;
public class Release {
	String compareRelease(String rel1, String rel2){
		int[] r1= splitOnDot(rel1);
		int[] r2=  splitOnDot(rel2);
		int i=0;
		while(i<r1.length && i<r2.length){
			if(r1[i]>r2[i]){
				return rel1;
			}
			else if(r2[i]>r1[i]){
				return rel2;
			}
			i++;
		}
		if(i<r1.length){
			return rel1;
		}
		else if(i<r2.length){
			return rel2;
		}
		else return "Both versions are equal";
	}
	
	int[] splitOnDot(String word){
		char[] chArray=word.toCharArray();
		ArrayList<String> result=new ArrayList<>(); // assuming release can't have more than 9 dots
		StringBuilder sb1=new StringBuilder();
		for(char c:chArray){
			if(c!='.'){
				sb1.append(c);
				//System.out.println(c);
			}
			else{
				result.add(sb1.toString());
				sb1=new StringBuilder();
			}
		}
		result.add(sb1.toString());
		int[] res=new int[result.size()];
		for(int i=0;i<result.size();i++){
			res[i]= Integer.parseInt(result.get(i));
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Release r1=new Release();
		System.out.println(r1.compareRelease("1.0.2.5", "10.2.4"));
		System.out.println(r1.compareRelease("1.0.2.5", "1.2.4"));
		System.out.println(r1.compareRelease("1.2.5", "1.2.5"));
		System.out.println(r1.compareRelease("1.0.0.0.1", "1.0.0.0.2"));

	}

}
