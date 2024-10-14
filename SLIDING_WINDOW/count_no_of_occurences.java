package SLIDING_WINDOW;

import java.util.*;
public class count_no_of_occurences{
    static ArrayList<Integer>list=new ArrayList<>();
    static int function(String str1, String str2, HashMap<Character,Integer>map){
        int i=0,j=0;
        int n=str1.length();
        int k=str2.length();
        int count=map.size();
        int ans=0;
        while(j<n){
            System.out.println(map);
            char ch=str1.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(count==0){
                    list.add(i);
                    ans++;
                }
                char ch2=str1.charAt(i);
                if(map.containsKey(ch2)){
                    map.put(ch2,map.get(str1.charAt(i))+1);
                    if(map.get(str1.charAt(i))==1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str1="cbaebabacd";
        String str2="abc";
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<str2.length();i++) {
            char ch = str2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
    }
}
