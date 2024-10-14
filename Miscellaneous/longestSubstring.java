import java.util.*;
public class longestSubstring {
    public static int helper(String str,int k){
        HashMap<Character,Integer>map=new HashMap<>();
        int n=str.length();
        int j=0;
        int i=0;
        int ans=0;
        while(j<n){
            char ch=str.charAt(j);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else map.put(ch,map.get(ch)+1);
            if(map.size()==k){
                ans=Math.max(ans,j-i+1);
                j++;
            }
            else if(map.size()<k){
                j++;
            }
            else{
                while(map.size()>k){
                    map.put(str.charAt(i),map.get(str.charAt(i))-1);
                    if(map.get(str.charAt(i))==0) map.remove(str.charAt(i));
                    i++;
                }
            }
        }
        return ans;
    }
     public static void main(String[] args) {
        System.out.println(helper("aabacbebebe",3));
    }
}
