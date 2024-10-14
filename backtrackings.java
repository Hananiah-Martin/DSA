public class backtrackings {
    public static int ways(int i,int j,int m,int grid[][]){
        if(i==m-1&&j==m-1) return 1;
        if(i>=m||j>=m) return 0;
        if(i<m&&j<m&&grid[i][j]==0) return 0;
        int down=ways(i+1, j, m,grid);
        int right=ways(i, j+1, m,grid);
        int diag=ways(i+1,j+1,m,grid);
        return down+right+diag;
    }
    public static int fourdirections(int i,int j,int m,int vis[][]){
        if(i<m&&j<m){
            if(i==m-1&&j==m-1) vis[i][j]=0;
            else vis[i][j]=1;
        }
        if(i==m-1&&j==m-1) return 1;
        if(i>=m||j>=m) return 0;
        int down=0,right=0,up=0,left=0;
        if(i+1<m&&j<m&&vis[i+1][j]==0) down=fourdirections(i+1, j, m, vis);     
        if(i<m&&j+1<m&&vis[i][j+1]==0) right=fourdirections(i, j+1, m, vis);
        if(i-1>=0&&j<m&&vis[i-1][j]==0) up=fourdirections(i-1, j, m, vis);
        if(i<m&&j-1>=0&&vis[i][j-1]==0) left=fourdirections(i, j-1, m, vis);
        vis[i][j]=0;
        return down+right+up+left;
    }
    public static void paths(int i,int j,int m,String ans){
        if(i==m-1&&j==m-1){
            System.out.println(ans);
            return;
        }
        if(i>=m||j>=m) return;
        paths(i+1,j,m,ans+'D');
        paths(i,j+1,m,ans+'R');
    }
    public static void main(String[] args){
        int m=3;
        int vis[][]=new int[m][m];
        System.out.println(fourdirections(0, 0, 3,vis));
    }
}
