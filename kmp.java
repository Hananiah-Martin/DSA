import java.util.ArrayList;

public class kmp {
    public static int[] lpsfun(String pattern){
        int lps[]=new int[pattern.length()];
        lps[0]=0;
        int i=1;
        int m=pattern.length();
        int length=0;
        while (i<m) {
            if(pattern.charAt(i)==pattern.charAt(length)){
                length++;
                lps[i]=length;
                i++;
            }
            else{
                if(length!=0){
                    length=lps[length-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String str="geeksforgeeks";
        String pat="geek";
        int m=str.length();
        int n=pat.length();
        int lps2[]=lpsfun(pat);
        int i=0;
        int j=0;
        ArrayList<Integer>res=new ArrayList<>();
        while(i<m){
            if(str.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            else if(str.charAt(i)!=pat.charAt(j)){
                if(j!=0){
                    j=lps2[j-1];
                }
                else{
                    i++;
                }
            }
            if(j==n){
                res.add(i-j);
                j=lps2[j-1];
            }
           
        }
        for(int num:res){
            System.out.print(num+" ");
        }
    }
}
