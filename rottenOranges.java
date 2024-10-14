import java.util.LinkedList;
import java.util.*;
public class rottenOranges {
    static  class trio{
        int first;
        int second;
        int third;
        public trio(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public static int helper(int grid[][]){
        int ans=0;
        Queue<trio>q=new LinkedList<>();
        int rows=grid.length;
        int cols=grid[0].length;
        int vis[][]=new int[rows][cols];
        int freshOranges=0,rottenOranges=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.add(new trio(i, j, 0));
                    vis[i][j]=1;
                }
                else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int time=q.peek().third;
            q.remove();
            ans=time;
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    if(delrow==-1&&delcol==-1||delrow==1&&delcol==1||delrow==1&&delcol==-1||delrow==1&&delcol==-1){
                        continue;
                    }
                    int nrow=row+delrow;
                    int ncol=col+delcol;
                    if(nrow>=0&&nrow<rows&&ncol>=0&&ncol<cols&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1){
                        q.add(new trio(nrow,ncol,time+1));
                        vis[nrow][ncol]=1;
                        rottenOranges++;
                    }
                }
            }
        }
        if(freshOranges==rottenOranges){
            return ans;
        }
        return -1;
    }
    public static void main(String[] args) {
        int grid[][]={{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(helper(grid));
    }
}
