import java.util.HashMap;
import java.util.Scanner;

public class wordCombinations {
    static class TrieNode{
        TrieNode children[]=new TrieNode[26];
        boolean isEnd;
        TrieNode(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            isEnd=false;
        }
    }
    static TrieNode root=new TrieNode();
    public static void insertString(String s){
        TrieNode curr=root;
        int n=s.length();
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr=curr.children[idx];
        }
        curr.isEnd=true;
    }
    public static boolean search(String str){
        TrieNode curr=root;
        int n=str.length();
        for(int i=0;i<n;i++){
            int idx=str.charAt(i)-'a';
            if(curr.children[idx]==null) return false;
            curr=curr.children[idx];
        }
        return curr.isEnd;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        int k=sc.nextInt();
        for(int i=0;i<k;i++){
            
        }
       String arr[]={"ab","abab","c","cb"};
       String str="ababc";
        for(int i=0;i<arr.length;i++){
            insertString(arr[i]);
        }
        int mod=(int)(1e9+7);
        int n=str.length();
        int []dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            TrieNode curr=root;
            for(int j=i;j<n;j++){
                int idx=str.charAt(j)-'a';
                if(curr.children[idx]==null) break;
                curr=curr.children[idx];
                if(curr.isEnd==true){
                    dp[i]=dp[i]%mod+dp[j+1]%mod;
                    dp[i]=dp[i]%mod;
                }
            }
        }
        System.out.println(dp[0]);
    }
}
