import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class check {
    public static boolean isAnagram(String str1,String str2){
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
                return false;
            }
        }
        if(hm.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String arsg[]){
        String strs[]={"eat","tea","tan","ate","nat","bat"};
        List<List<String>>lists=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            if(strs[i]!="-1"){
                List<String>list_one=new ArrayList<>();
                String str1=strs[i];
                list_one.add(str1);
                for(int j=i+1;j<strs.length;j++){
                        String str2=strs[j];
                        if(isAnagram(str1,str2)){
                            list_one.add(str2);
                            strs[j]="-1";
                        }
                }
                lists.add(list_one);
        }
            }
           
        System.out.println(lists);
    }
}
