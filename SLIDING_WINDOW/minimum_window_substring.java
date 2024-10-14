package SLIDING_WINDOW;

import java.awt.*;
import java.util.HashMap;

public class minimum_window_substring {
    static int function(String big,String small){
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<small.length();i++){
            char ch=small.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int j=0,i=0;
        int count=map.size();
        int ans=Integer.MAX_VALUE;
        int start=0;
        while(j<big.length()){
//            System.out.println("inside j loop "+map);
            char ch=big.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }
            if(count>0){
                j++;
            }
            if(count==0){
                //reduce the size
                while(count==0){
                    char ch2=big.charAt(i);
                    if(map.containsKey(ch2)){
                        map.put(ch2,map.get(ch2)+1);
                        if(map.get(ch2)==1){
                            count++;
                        }
                    }
                    if(j-i+1<ans){
                        ans=j-i+1;
                        start=i;
                    }
                    i++;
                }
                j++;
            }
        }
        if(ans==Integer.MAX_VALUE) System.out.println("empty answer found");
        else System.out.println(big.substring(start,start+ans));
        return ans;
    }
    public static void main(String[] args) {
        int ans=function("cabwefgewcwaefgcf","cae");
        System.out.println(ans);
    }
}
