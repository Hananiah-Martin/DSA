package Dynamic_Programming;
import java.util.*;
public class MinimumNoOfBalancedStrings{
    public static  boolean check(int []freq){
        int minFreq = 1001, maxFreq = 0;
        for (int Freq : freq) {
            if (Freq > 0) {
                minFreq = Math.min(minFreq , Freq);
                maxFreq = Math.max(maxFreq , Freq);
            }
        }
        return minFreq == maxFreq;
    }
    public static void main(String[] args) {
        String s="fabccddg";
        int n=s.length();
        int []dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=1;
        for(int i=1;i<n;i++){
            int []freq=new int[26];
            for(int j=i;j>=0;j--){
                freq[s.charAt(j)-'a']++;
                if(check(freq)){
                    dp[i]=j>0?Math.min(dp[i],dp[j-1]+1):1;
                }
            }
        }
        for(int x:dp){
            System.out.print(x+" ");
        }
        System.out.println(dp[n-1]);
    }
}
