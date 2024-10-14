import java.util.HashMap;

public class Minimumwindowsubstring {
    public static int helper(String str,String t){
        HashMap<Character,Integer>tmap=new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i),1);
            }
            else tmap.put(t.charAt(i),tmap.get(t.charAt(i))+1);
        }
        int n=str.length();
        int i=0,j=0;
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=Integer.MAX_VALUE,count=0;
        int start=0,end=0;
        while(j<n){
            char ch=str.charAt(j);
            if(tmap.containsKey(ch)){
                count++;
            }
            if(count==t.length()){
                ans=Math.min(ans,j-i+1);
                if(tmap.containsKey(str.charAt(i))){
                    count--;
                }
                i++;
            }
            j++;
        }
//        for(int k=start;k<=end;k++){
//            System.out.print(str.charAt(k));
//        }
//        System.out.println();
        return ans;
    }

    public static void main(String[] args) {
        System.out.print(helper("adobecodebanc","abc"));
    }
}
