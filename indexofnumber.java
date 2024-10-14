import java.util.*;
public class indexofnumber {
    public static void main(String args[]){
       int a[]={2,3,4,5,7,8};
       System.out.println("Enter the number you want to find index :");
       Scanner b=new Scanner(System.in);
       int c=b.nextInt();
       //to find index of 4
       for(int i=0;i<a.length;i++){
            if(a[i]==c){
                System.out.println(i);
            }
       }
    }
}
