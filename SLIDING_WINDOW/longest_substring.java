package SLIDING_WINDOW;

import java.util.HashMap;

public class longest_substring {
    static int function(String str,int k){
        HashMap<Character,Integer>map=new HashMap<>();
        int i=0;
        int j=0,ans=0;
        while(j<str.length()){
            char ch=str.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()<k){
                j++;
            }
            else if(map.size()==k){
                ans=Math.max(j-i+1,ans);
                j++;
            }
            else{
                while(map.size()>k){
                    char ch2=str.charAt(i);
                    if(map.containsKey(ch2)){
                        map.put(ch2,map.get(ch2)-1);
                    }
                    if(map.get(ch2)==0){
                        map.remove(ch2);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int ans=function("aabacbebebe",3);
        System.out.println(ans);
    }
}
