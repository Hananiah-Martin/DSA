public class surroundedRegions {
    public static void dfs(int row,int col,char board[][],int vis[][]){
        int rows=board.length;
        int cols=board[0].length;
        vis[row][col]=1;
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,1,0,1};
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0&&nrow<rows&&ncol>=0&&ncol<cols&&vis[nrow][ncol]==0&&board[nrow][ncol]=='O'){
                dfs(nrow,ncol,board,vis);
            }
        }
    }
    public static void helper(char board[][]){
        int rows=board.length;
        int cols=board.length;
        int vis[][]=new int[rows][cols];
        //perform the dfs on the borders
        //dfs on first row 
        for(int i=0;i<cols;i++){
            if(board[0][i]=='O'&&vis[0][i]==0){
                dfs(0,i,board,vis);
            }
        }
        //dfs on last row
        for(int i=0;i<cols;i++){
            if(board[rows-1][i]=='O'&&vis[rows-1][i]==0){
                dfs(rows-1,i, board, vis);
            }
        }
        //dfs on first column
        for(int i=0;i<rows;i++){
            if(board[i][0]=='O'&&vis[i][0]==0){
                dfs(i,0,board,vis);
            }
        }
        //dfs on last column
        for(int i=0;i<rows;i++){
            if(board[i][cols-1]=='O'&&vis[i][cols-1]==0){
                dfs(i,cols-1,board,vis);
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(vis[i][j]==0&&board[i][j]=='O'){
                    board[i][j]='X';
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
