import java.util.*;
public class functions{
    public static void printhelloworld(){
        System.out.println("hello world");
    }
    public static void calculatesum(int a,int b){
        int sum=a+b;
        System.out.println("sum is "+ sum);
    }
    public static int product(){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int product=a*b;
        return product;
    }
    public static void main(String args[]) {
        printhelloworld();
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        calculatesum(a, b);
        int x=product();
        System.out.println("product is :"+x);
        int factors=0;
        for(int i=1;i<=a;i++){
            if(a%i==0){
                factors=factors+1;
            }
        }
        if(factors==2){
            System.out.println("Number is prime");
        }
        else{
            System.out.println("number is not prime");
        }
        for(int i=2;i<=a;i++){
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    factors=factors+1;
                }
            }
            if(factors==2){
                System.out.println(i);
            }
            boolean isPrime=true;
            for(int k=2;k<=a-1;k++){
                if(a%k==0){
                    isPrime=false;
                    break;
                }
            System.out.println(isPrime);
            }
        }
    }
}

