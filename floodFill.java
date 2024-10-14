import java.util.*;
public class floodFill{
    static class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public static void bfs(int matrix[][],int sr,int sc,int color){
        Queue<pair>q=new LinkedList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        q.add(new pair(sr,sc));
        int vis[][]=new int[m][n];
        vis[sr][sc]=1;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    if(delrow==-1&&delcol==-1||delrow==1&&delcol==1||delrow==1&&delcol==-1||delrow==1&&delcol==-1){
                        continue;
                    }
                    int nrow=row+delrow;
                    int ncol=col+delcol;
                    if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&matrix[nrow][ncol]==1&&vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new pair(nrow,ncol));
                        if(matrix[nrow][ncol]==color) continue;
                        else matrix[nrow][ncol]=color;
                    }
                }
            }
        }
    }
    public static void main(String args[]){
        int sr=1,sc=1,color=2;
        int image[][]={{0,0,1},{0,1,0}};
        if(image[sr][sc]!=color){
            image[sr][sc]=color;
            bfs(image,1,1,2);
        }
        
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}