import java.util.*;
public class spiralmatrix{
    public static void main(String args[]){
        System.out.print("Enter number of rows : ");
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        System.out.print("Enter number of Columns : ");
        int n=sc.nextInt();
        int top=0,down=m-1,left=0,right=n-1;
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int dir=0;
        while(top<=down&&left<=right){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    System.out.print(a[top][i]);
                }
                top=top+1;
            }
            else if(dir==1){ 
                for(int i=top;i<=down;i++){
                    System.out.print(a[i][right]);
                }
                right=right-1;
            }
            else if(dir==2){
                for(int i=right;i>=left;i--){
                    System.out.print(a[down][i]);
                }
                down=down-1;
            }
            else if(dir==3){
                for(int i=down;i<=top;i++){
                    System.out.print(a[i][left]);
                }
                left=left+1;
            }
            dir=(dir+1)%4;
        }
    }
}