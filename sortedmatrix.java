import java.util.*;
public class sortedmatrix{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a[][]=new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                a[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.print("Enter the key you want to find in the matrix : ");
        int x=sc.nextInt();
        int i=0;
        int j=3;
        while(i<a.length&&j>=0){
            if(a[i][j]==x){
                System.out.print("Key is found at" + i + j);
            }
            else if(x<a[i][j]){
                j--;
            }
            else{
                i++;
            }
        }
    }
}