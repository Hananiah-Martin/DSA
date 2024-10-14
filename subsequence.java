public class subsequence {
    public static void subsequences(String p,String up){
        if(up.isEmpty()){
            if(p.isEmpty()){
                System.err.println("emptystring");
            }
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subsequences(p+ch, up.substring(1));
        subsequences(p, up.substring(1));
    }
    public static void main(String[] args) {
        subsequences("", "abc");
    }
}
