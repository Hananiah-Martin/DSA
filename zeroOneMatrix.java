import java.util.*;
public class zeroOneMatrix {
    static class trio{
        int row;
        int col;
        int dist;
        public trio(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public static int[][] helper(int mat[][]){
        int rows=mat.length;
        int cols=mat[0].length;
        int res[][]=new int[rows][cols];
        int vis[][]=new int[rows][cols];
        Queue<trio>q=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0){
                    q.add(new trio(i,j,0));
                    vis[i][j]=1;
                    res[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int dist=q.peek().dist;
            q.remove();
            int delrow[]={-1,0,+1,0};
            int delcol[]={0,+1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0&&nrow<rows&&ncol>=0&&ncol<cols&&vis[nrow][ncol]==0&&mat[nrow][ncol]==1){
                    vis[nrow][ncol]=1;
                    q.add(new trio(nrow, ncol, dist+1));
                    res[nrow][ncol]=dist+1;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int mat[][]={{0,0,0},{0,1,0},{1,1,1}};
        int res[][]=helper(mat);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
