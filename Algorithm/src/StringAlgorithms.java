import java.util.Arrays;
import java.util.HashMap;

//import java.util.LinkedHashMap;

public class StringAlgorithms {

	public String longestSubstring(String word){
		//LinkedHashMap<String,Integer> map1=new LinkedHashMap();
		return "Hello";
	}
	
	public boolean isAnagram(String word1,String word2){
		if(word1.length()!=word2.length()){
			return false;
		}
		else{
			word1=word1.toLowerCase();
			word2=word2.toLowerCase();
		}
		char[] wordA=word1.toCharArray();
		char[] wordB=word2.toCharArray();
		HashMap<Character,Integer> map1=new HashMap<>();
		for(char x:wordA){
			if(map1.containsKey(x)){
				map1.put(x, map1.get(x)+1);
			}
			else{
				map1.put(x, 1);
			}
		}
		for(char y:wordB){
			if(map1.containsKey(y)){
				if(map1.get(y)==1){
					map1.remove(y);
				}
				else{
					map1.put(y, map1.get(y)-1);
				}	
			}
			else{
				return false;
			}
		}
		return map1.isEmpty();
	}
	
	
	public String toUpperCase(String s){
		char[] c=s.toCharArray();
		for(int i=0;i<c.length;i++){
			if(c[i]>96 && c[i]<123){
				c[i]=(char)(c[i]-32);
			}
		}
		return new String(c);
	}
	
	public String toLowerCase(String s){
		char[] c=s.toCharArray();
		for(int i=0;i<c.length;i++){
			if(c[i]>64 && c[i]<91){
				c[i]=(char)(c[i]+32);
			}
		}
		return new String(c);
	}
	
	public int len(String word){
		char[] c=word.toCharArray();
		//int count=0;
		int i=0;
		try{
			while(true){
				c[i]=c[i];
				i++;
				//count++;
			}
		}
		catch(IndexOutOfBoundsException e){
			//System.out.println("Count is "+ i);
			
		}
		return i;
	}
	
	public String wordsReverse(String sentence){
		char[] wordsArray=sentence.toCharArray();
		int wordBegin=0;
		int i=0;
		while(i<sentence.length()){
				if(sentence.charAt(i)==' '){
					wordsArray= reverse(wordsArray,wordBegin,i-1);
					wordBegin=i+1;
				}
				i++;
		}
		wordsArray= reverse(wordsArray,wordBegin,i-1); //for last word that doesn't end in space. 
	
		return new String(wordsArray);
	}
	
	public char[] reverse(char[] wA,int start,int end){
	
		char temp;
		while(start<end){
			temp=wA[start];
			wA[start]=wA[end];
			wA[end]=temp;
			start++;
			end--;
		}	
		return wA;
	}
	
	public String sentenceReverse(String sentence){
		StringBuffer sb1=new StringBuffer();
		String[] stringArray=sentence.split(" ");
		for(int i=stringArray.length-1;i>=0;i--){
			sb1.append(stringArray[i]+" ");
		}
		return new String(sb1);
	}
	
	public boolean unique(String word){
		word=word.toLowerCase();
		char[] wordArray=word.toCharArray();
		int[] bitSet= new int[26];
		for(char a:wordArray){
			if(bitSet[a-97]!=0){
				return false;
			}
			else{
				bitSet[a-97]=1;
			}
		}
		return true;
	}
	public boolean uniqueBits(String word){
		int bitSet=1;
		char[] wordArray=word.toCharArray();
		for(char a:wordArray){
			int val=(char)a;
			if((bitSet & 1<<val)>0){
				return false;
			}
			else{
				bitSet|= 1<<val;
			}
		}
		System.out.println(bitSet);
		return true;
	}
	
	public String compress(String word) throws IllegalArgumentException{
		if(word==null){
			throw new IllegalArgumentException();
		}
		if(word.length()<2){
			return word;
		}
		StringBuffer result=new StringBuffer();
		int i=0;
		char[] wordArray=word.toCharArray();
		int counter=1;
		for(int pointer=1;pointer<wordArray.length;pointer++){
			if(pointer<wordArray.length && wordArray[i]==wordArray[pointer]){
				counter++;
			}
			else{
				result.append(wordArray[i]);
				result.append(counter);
				i=pointer;
				counter=1;
			}
		}
		String res=new String(result);
		if(res.length()>word.length()){
			System.out.println("Original String Smaller than commpressed version. Returning Original ..");
			return word;
		}
		else{
			return res;	
		}
			
	}
	
	public String replace(String word,char replaceChar,String replacement){
		StringBuffer newWord=new StringBuffer();
		int i=0;
		while(i<word.length()){
			if(word.charAt(i)==replaceChar){
				newWord.append(replacement);
			}
			else{
				newWord.append(word.charAt(i));
			}
			i++;
		}
		return new String(newWord);
	}
	
	public String inPlaceReplace(String word, char replaceChar, String replacement){
		char[] wordArray=word.toCharArray();
		int replacementChars=countReplace(wordArray,replaceChar);
		int len=replacement.length();
		int extraChars=replacementChars*(replacement.length());
		int newLen= word.length()-replacementChars+extraChars;
		//System.out.println("new length is"+ newLen);
		char[] newWord=new char[newLen];
		char[] replacementWord=replacement.toCharArray();
		for(int i=newLen-1;i>=0;){
			printArray(newWord);
			if(wordArray[i-extraChars]==replaceChar){
				int j=len-1;
				while(j>=0){
					newWord[i]=replacementWord[j];
					i--;
					j--;
				}
			}
			else{
				newWord[i]=wordArray[i-extraChars];
				i--;
			}
		}
		return new String(newWord);
	}
	public boolean isSubString(String mainString, String word){
		/*Takes in 2 strings
		 * returns true if all characters of word are in mainString 
		 */
		HashMap<Character,Integer> map1=new HashMap<>();
		char[] ms=mainString.toCharArray();
		for(char x:ms){
			if(map1.containsKey(x)){
				map1.put(x,map1.get(x)+1);
			}
			else{
				map1.put(x,1);
			}
		}
		char[] sub=word.toCharArray();
		for(char x:sub){
			if(map1.containsKey(x)){
				if(map1.get(x)==1){
					map1.remove(x);
				}
				else{
					map1.put(x,map1.get(x)-1);
				}
			}
			else{
				return false;
			}
		}
		return true;
	}


	public String initials(String sentence){
		StringBuilder initial=new StringBuilder();
		String[] words=sentence.split(" ");
		for(String x:words){
			if(x.charAt(0)!=' '){
				initial.append(x.charAt(0));
			}
		}
		
		//printArray(words);
		return new String(initial);
		
	}
	
	public int countReplace(char[] wordArray,char replaceChar){
		int count=0;
		for(char x: wordArray){
			if(x==replaceChar){
				count++;
			}
		}
		return count;
	}
	
	public void printArray(char[] StringArray){
		for(char x:StringArray){
			System.out.print(x+ "  ");
		}
	}
	
	public String removeVowels(String word){
		//word=word.toLowerCase();
		StringBuilder sb1=new StringBuilder();
		char[] a=word.toCharArray();
		for(char c:a){
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U'){
				continue;
			}
			else{
				sb1.append(c);
			}
		}
		return new String(sb1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringAlgorithms sa1=new StringAlgorithms();
		System.out.println(sa1.compress("aaaabbbfyeaeyeyyyyyyyyrrrrrr"));
		System.out.println(sa1.unique("hedabcfgw"));
		System.out.println(sa1.uniqueBits("hedabbcfgw"));
		System.out.println(sa1.toUpperCase("aBcDefGhIjKlmnopQrstUvWXyZ"));
		System.out.println(sa1.toLowerCase("aBcDefGhIjKlmnopQrstUvWXyZ"));
		System.out.println(sa1.wordsReverse("My name is Vishakha Gupta"));
		System.out.println(sa1.sentenceReverse("My name is Vishakha Gupta"));
		System.out.println(sa1.inPlaceReplace("My name is Vishakha Gupta", 'a', "%love%"));
		System.out.println(sa1.replace("My name is Vishakha Gupta", 'a', "%love%"));
		System.out.println(sa1.initials("My name is Vishakha Gupta"));
		System.out.println(sa1.bigInt(987654321));
		System.out.println(sa1.isSubString("My name is Vishakha Gupta","GGames"));
		System.out.println(sa1.isAnagram("hello", "Holel"));
		System.out.println(sa1.len("aBXyZ"));
		System.out.println(sa1.removeVowels("My name is Vishakha Gupta"));
	}

}
