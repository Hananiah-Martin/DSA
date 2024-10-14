public class gcd {
    public static int gcdt(int a,int b){
        if(a==0) return b;
        int ans=gcdt(b%a,a);
        return ans;
    }
    public static void main(String[] args) {
        int ans=gcdt(3,27);
        System.out.println(ans);
    }
}
