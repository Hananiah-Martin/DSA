public class recursion {
    public static void subsequences(String str,String ans){
        if(str.isEmpty()){
            if(ans.isEmpty()){
                System.out.print("empty string");
            }
            System.out.print(ans+" ");
            return;
        }
        subsequences(str.substring(1),ans+str.charAt(0));
        subsequences(str.substring(1), ans);
    }
    public static void main(String[] args) {
        subsequences("abcd","");
    }
}
