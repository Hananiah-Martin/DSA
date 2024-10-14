import java.util.*;
public class noOfIslands {
    static class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public static boolean isVisitedAndExists(int adjMat[][],int row,int col,int vis[][]){
        if(adjMat[row][col]==1&&vis[row][col]==0){
            return true;
        }
        return false;
    }
    public static boolean check(int row,int rows,int col,int cols){
        if(row>=0&&row<rows&&col>=0&&col<cols){
            return true;
        }
        return false;
    }
    public static void bfs(int row,int col,int vis[][],int adjMat[][]){
        vis[row][col]=1;
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(row,col));
        int rows=adjMat.length;
        int cols=adjMat[0].length;
        while(!q.isEmpty()){
            int qrow=q.peek().row;
            int qcol=q.peek().col;
            q.remove();
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    if(delrow==-1&&delcol==-1||delrow==1&&delcol==1||delrow==1&&delcol==-1||delrow==1&&delcol==-1){
                        continue;
                    }
                    int nrow=delrow+qrow;
                    int ncol=delcol+qcol;
                    if(check(nrow,rows,ncol,cols)&&isVisitedAndExists(adjMat,nrow,ncol,vis)){
                        vis[nrow][ncol]=1;
                        q.add(new pair(nrow,ncol));
                    }
                }
            }
        }
    }
    public static void helper(int adjMat[][]){
        int rows=adjMat.length;
        int cols=adjMat[0].length;
        int vis[][]=new int[rows][cols];
        int count=0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(vis[row][col]==0&&adjMat[row][col]==1){
                    count++;
                    bfs(row,col,vis,adjMat);
                }
            }
        }
        System.out.print(count);
    }
    public static void main(String args[]){
        int adjMat[][]={
            {1,1,1,1,0},
  {1,1,0,1,0},
  {1,1,0,0,0},
  {0,0,0,0,0}};
        helper(adjMat);
    }
}
