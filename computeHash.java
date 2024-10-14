public class computeHash {
    static long mod=(int)1e9+7;
    public static long calculteHash(String s){
        int p=31;
        long hash=0;
        long p_pow=1;
        for(char c:s.toCharArray()){
            hash=(hash+(c-'a'+1)*p_pow)%mod;
            p_pow=(p*p_pow)%mod;
        }
        return hash;
    }
    public static long substringHash(String s,int i,int j){
        return (calculteHash(s.substring(0,j))-calculteHash(s.substring(0,i)));
    }
    public static void main(String[] args) {
        long prevHash=calculteHash("hananiah");
        System.out.println(calculteHash("han"));
        System.out.println(substringHash("hananiah",0,3));
    }
}
