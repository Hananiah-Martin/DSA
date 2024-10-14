package Graphs.BFS_DFS;

import java.util.PriorityQueue;
import java.util.Scanner;

public class threeactivites {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            int []a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int []b=new int[n];
            for(int i=0;i<b.length;i++){
                b[i]=sc.nextInt();
            }
            int []c=new int[n];
            for(int i=0;i<n;i++){
                c[i]=sc.nextInt();
            }
            t--;
        }
    }
}
