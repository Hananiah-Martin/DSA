import java.util.*;
public class advancedpatterns{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        // System.out.println("Enter no of rows :");
        // int a=sc.nextInt();
        // System.out.println("Enter no of columns :");
        // int b=sc.nextInt();
        // for(int i=1;i<=a;i++){
        //     for(int j=1;j<=b;j++){
        //         if(i==1 || i==a || j==1 || j==b){
        //             System.out.print("*");
        //         }
        //         else{
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }
        System.out.print("Enter no of rows : ");
        int x=sc.nextInt();
        System.out.print("Enter no of columns : ");
        int y=sc.nextInt();
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                if(i==1 || i<=x-1 || j==1 || j<=y-1){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }



        
    }
}