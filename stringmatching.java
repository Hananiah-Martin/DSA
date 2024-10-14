import java.util.*;
public class stringmatching {
    static final int prime=101;
    public static long calculateHash(String s){
        long hash=0;
        for(int i=0;i<s.length();i++){
            hash=hash+(long)(s.charAt(i)*Math.pow(prime,i));
        }
        return hash;
    }
    public static long updateHash(long prevHash,char oldChar,char newChar,int patternLength){
        long newHash=(prevHash-oldChar)/prime;
        newHash=newHash+(long)(newChar*Math.pow(prime,patternLength-1));
        return newHash;
    }
    public static void search(String text,String pattern){
        int n=pattern.length();
        long textHash=calculateHash(text.substring(0,n));
        long patternHash=calculateHash(pattern);
        int count=0;
        for(int i=0;i<=text.length()-pattern.length();i++){
            if(textHash==patternHash){
                if(text.substring(i, i+pattern.length()).equals(pattern)){
                   count++;
                }
            }
            if(i<text.length()-n){
                textHash=updateHash(textHash, text.charAt(i),text.charAt( i+pattern.length()) ,n);
            }
        }
        if(count==0) System.out.println(count);
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text="abab";
        String pattern="bababaaabbbbaabb";
        search(text, pattern);
    }
}
