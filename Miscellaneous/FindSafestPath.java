import java.util.*;
public class FindSafestPath  extends InBuiltFunctions{
    static class Trio{
        int row;
        int col;
        int dist;
        public Trio(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    static class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row=row;
            this.col=col;
        }

    }
    static boolean pathExists(int sf,int res[][]){
        Queue<Pair>q=new LinkedList<>();
        int m=res.length;
        int n=res[0].length;
        int [][]vis=new int[m][n];
        q.add(new Pair(0,0));
        vis[0][0]=1;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.remove();
            if(row==m-1&&col==n-1){
                return true;
            }
            int[] delrow={-1,0,+1,0};
            int[] delcol ={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=delrow[i]+row;
                int ncol=delcol[i]+col;
                if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    if(res[nrow][ncol]>=sf){
                        q.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
        return false;
    }
    static void calculateManhattan(int[][] grid, int[][] res){
        Queue<Trio>q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Trio(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int dist=q.peek().dist;
            q.remove();
            int[] delrow={-1,0,+1,0};
            int[] delcol ={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=delrow[i]+row;
                int ncol=delcol[i]+col;
                if(nrow>=0&&nrow<m&&ncol>=0&&ncol<n&&vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Trio(nrow,ncol,dist+1));
                    res[nrow][ncol]=dist+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int grid[][]= {{0,0,0,1},{0,0,0,0},{0,0,0,0},{1,0,0,0}};
        int res[][]=new int[grid.length][grid[0].length];
        calculateManhattan(grid,res);
        //perform binary search
        int left=0;
        int right=400;
        int result=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(pathExists(mid,res)){
                result=mid;
                left=mid+1;
            }
            else right=mid-1;
        }
        System.out.println(result);
    }
}
