import java.util.*;
public class anagrams {
    public static void main(String args[]){
        String str1="tree";
        String str2="reet";
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char ch=str1.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }
            else{
                hm.put(ch,1);
            }
        }
        for(int i=0;i<str2.length();i++){
            char ch=str2.charAt(i);
            if(hm.containsKey(ch)){
                if(hm.get(ch)==1){
                    hm.remove(ch);
                }
                else{
                    hm.put(ch,hm.get(ch)-1);
                }
            }
            else{
                System.out.println(false);
            }
        }
        if(hm.isEmpty()){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }

}
