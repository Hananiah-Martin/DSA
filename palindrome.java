public class palindrome {
    public static boolean isPalindrome(String str){
        int n=str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        String str="shradha";
        System.out.print(isPalindrome(str));
       
    }   
}
