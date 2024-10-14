import java.util.HashMap;
import java.util.*;
public class LSRepeating {
    public  static int helper(String str){
        int n=str.length();
        int i=0,j=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int ans=0;
        int start=0,end=0;
        while(j<n){
            char ch=str.charAt(j);
            if(!map.containsKey(ch)) map.put(ch,1);
            else map.put(ch,map.get(ch)+1);
            if(map.size()==j-i+1){
//                ans=Math.max(ans,j-i+1);
                if(j-i+1>ans){
                    ans=j-i+1;
                    start=i;
                    end=j;
                }
                j++;
            }
            else{
                while(map.size()!=j-i+1){
                    map.put(str.charAt(i),map.get(str.charAt(i))-1);
                    if(map.get(str.charAt(i))==0){
                        map.remove(str.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        for(int k=start;k<=end;k++){
            System.out.print(str.charAt(k));
        }
        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(helper("abcabcbb"));
    }
}
