import java.util.*;
public class frequency{
    public static void main(String args[]){
        int a[][]={{1,2,3,},{5,5,5},{7,8,9}};
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        int x=5;
        int frq=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(a[i][j]==x){
                    frq=frq+1;
                }
            }
        }
        System.out.print(frq);
    }
}