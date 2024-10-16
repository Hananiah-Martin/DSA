public class nqueens{
    static int count=0;
    public static boolean isSafe(char board[][],int row,int col){
        //checking for the rows
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //checking for the columns
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //checking for the diagonals
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void queen(char board[][],int row){
        if(row==board.length){
            count++;
            System.out.println("----chess board---");
            printboard(board);
            return;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                queen(board, row+1);
                board[row][j]='X';
            }
        }
        
    }
    public static void printboard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int n=4;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }
        queen(board,0);
        System.out.println("No of ways in "+n+" queens can arranged without attacking each other is "+ count);
    }
}