
public class binarytodecimal {
    public static void bintodec(int n){
        int num=n;
        int binary=0;
        int pow=0;
        while(n>0){
            int lastdigit=n%10;
            binary=binary+(lastdigit*(int)Math.pow(2,pow));
            pow++;
            n=n/10;
        }
        System.out.println("decimal number of "+num+"is"+binary);
    }
    public static void dectobin(int n){
        int bin=0;
        int pow=0;
        while(n>0){
            bin=n%2+(int)Math.pow(10,pow);
            pow++;
        }
        System.out.println(bin);
    }

        
    public static void main(String args[]) {
        bintodec(101);
    }
}
