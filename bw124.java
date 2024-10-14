import java.util.*;
public class bw124 {
    public static int solve(int arr[]){
        int x=arr.length;
        int n=arr.length;
        int ans1=0,ans2=0,ans3=0;
        int sum1=arr[0]+arr[1];
        int sum2=arr[n-1]+arr[n-2];
        int sum3=arr[0]+arr[n-1];
        for(int i=0;i<n;i++){
            if(i!=n-i+1&&n-i+1<n-1&&arr[i]+arr[x-i+1]==sum1){
                ans1++;
                n=n-2;
            }
            else if(i+1<n&&arr[i]+arr[i+1]==sum1){
                ans1++;
                i++;
                n=n-2;
            }
            else if(n-i-2>=0&&arr[x-i-1]+arr[x-i-2]==sum1){
                ans1++;
                n=n-2;
            }
            else break;
        }
        for(int i=0;i<n;i++){
            if(i!=n-i+1&&n-i+1<n-1&&arr[i]+arr[x-i+1]==sum2) {
                ans2++;
                n=n-2;
            }
            else if(i+1<n&&arr[i]+arr[i+1]==sum2) {
                ans2++;
                i++;
                n=n-2;
            }
            else if(n-i-2>=0&&arr[x-i-1]+arr[x-i-2]==sum2){
                ans2++;
                n=n-2;
            }
            else break;
        }
        for(int i=0;i<n;i++){
            if(i!=n-i+1&&n-i+1<n-1&&arr[i]+arr[x-i+1]==sum3){
                ans3++;
                n=n-2;
            }
            else if(i+1<n&&arr[i]+arr[i+1]==sum3) {
                ans3++;
                i++;
                n=n-2;
            }
            else if(n-i-2>=0&&arr[x-i-1]+arr[x-i-2]==sum3) {
                ans3++;
                n=n-2;
            }
            else break;
        }
        return Math.max(ans1,Math.max(ans2,ans3));
    }
    public static int maxEqualSum(int[] nums) {

            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : nums) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
            
            int maxOperations = 0;
            for (int frequency : frequencyMap.values()) {
                maxOperations = Math.max(maxOperations, frequency / 2);
            }
            return maxOperations;
    }
    public static String  helper(String s,String ans){
        int n=s.length();
        int freq[]=new int[26];
        boolean freq2[]=new boolean[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        String temp="";
        for(int i=0;i<n;i++){
                if(freq[s.charAt(i)-'a']>=1&&freq2[s.charAt(i)-'a']==false){
                    freq[s.charAt(i)-'a']--;
                    freq2[s.charAt(i)-'a']=true;
               }
               else{
                temp=temp+s.charAt(i);
               }
        }
        boolean ans2=true;
        for(int i=0;i<26;i++){
            if(freq[i]>1) ans2=false;
        }
        if(ans2==true) return temp;
        return helper(temp,"");
    }
    public static void main(String[] args) {
        // String s="aabcbbca";
        // int freq[]=new int[26];
        // for(int i=0;i<s.length();i++){
        //     freq[s.charAt(i)-'a']++;
        // }
        // int count=0;
        // for(int i=0;i<26;i++){
        //     if(freq[i]==1) count++;
        // }
        // if(count==s.length()) System.out.println(s);
        // else{
        //     System.out.println(helper(s,""));
        // }
        int arr[]={3,2,6,1,4};
        System.out.println(maxEqualSum(arr));
    }
}
