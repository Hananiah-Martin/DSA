public class generateallsubsequences {
    public static void main(String[] args) {
        String str="abc";
        int n=3;
        for(int i=0;i<(1<<n);i++){
            String s="";
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    s=s+str.charAt(i);
                }
            }
            System.out.println(s);
        }
    }
}
