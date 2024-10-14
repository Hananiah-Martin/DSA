package Graphs.BFS_DFS;
import java.util.*;
import java.util.Objects;

public class Surrounded_Regions {

    static class pair{
        int first;
        int second;
        public pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void main(String[] args) {
        String[][] grid={{"X","X","X","X"},{"X","O","O","X"},{"X","X","O","X"},{"X","O","X","X"}};
        String [][]ans=grid;
        int m=grid.length;
        int n=grid[0].length;
        int [][]vis=new int[m][n];
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0||i==m-1||j==m-1){
                    continue;
                }
                else{
                    if(Objects.equals(grid[i][j], "O")){
                        q.add(new pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            ans[row][col]="X";
            int []delrow={-1,0,1,0};
            int []delcol={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0&& Objects.equals(grid[nrow][ncol], "O")){
                    vis[nrow][ncol]=1;
                    q.add(new pair(nrow,ncol));
                }
            }
        }
        System.out.println(Arrays.deepToString(ans));
    }
}
