public class noOfEnclaves {
    public static void dfs(int row,int col,int grid[][],int vis[][]){
        vis[row][col]=1;
        int rows=grid.length;
        int cols=grid[0].length;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0&&nrow<rows&&ncol>=0&&ncol<cols&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1){
                vis[nrow][ncol]=1;
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
    public static int helper(int grid[][]){
        int rows=grid.length;
        int cols=grid[0].length;
        int vis[][]=new int[rows][cols];
        //dfs on the first row
        for(int i=0;i<cols;i++){
            if(vis[0][i]==0&&grid[0][i]==1){
                dfs(0,i,grid,vis);
            }
        }
        for(int i=0;i<cols;i++){
            if(vis[rows-1][i]==0&&grid[rows-1][i]==1){
                dfs(0,i,grid,vis);
            }
        }
        for(int i=0;i<rows;i++){
            if(vis[i][0]==0&&grid[i][0]==1){
                dfs(i,0,grid,vis);
            }
        }
        for(int i=0;i<rows;i++){
            if(vis[i][cols-1]==0&&grid[i][cols-1]==1){
                dfs(i,cols-1,grid,vis);
            }
        }
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1&&vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}
