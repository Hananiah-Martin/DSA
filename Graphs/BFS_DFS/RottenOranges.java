package Graphs.BFS_DFS;
import java.util.*;
import java.util.LinkedList;

public class RottenOranges {
    static class pair{
        int row;
        int col;
        int time;
        public pair(int row,int col,int steps){
            this.row=row;
            this.col=col;
            this.time=steps;
        }
    }
    public static int minimumTime(int [][]grid){
        //2 represents that it is rotten orange
        Queue<pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        boolean [][]vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int time=q.peek().time;
            q.remove();
            ans=time;
            int []delrow={-1,0,1,0};
            int []delcol={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&& !vis[nrow][ncol]){
                    vis[nrow][ncol]=true;
                    q.add(new pair(nrow,ncol,time+1));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][]grid={{2,1,1},{1,1,0},{0,1,1}};
        int ans=minimumTime(grid);
        System.out.println(ans);
    }
}
