import java.util.*;
public class prime{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        boolean isPrime=true;
        for(int i=2;i<=a-1;i++){
            if(a%i==0){
                isPrime=false;
                break;
            }
        }
        System.out.println(a+"is a prime number :"+isPrime);

    }
}
