import java.lang.reflect.Array;
import java.util.ArrayList;

public class nqueenspractise {
    public static boolean isSafe(boolean board[][],int row,int col){
        //checking for vertical row
        for(int i=0;i<row;i++){
            if(board[i][col]==true) return false;
        }
        //for checking right diagonals
        int maxRight=Math.min(row,board.length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]==true) return false;
        }
        //for checking left diagonals
        int maxleft=Math.min(row,col);
        for(int i=1;i<=maxleft;i++){
            if(board[row-i][col-i]==true) return false;
        }
        return true;
    }
    public static ArrayList<String> display(boolean board[][]){
        ArrayList<String>temp=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String res=new String();
            for(int j=0;j<board.length;j++){
                if(board[i][j]){
                    res+='Q';
                }
                else{
                    res+='.';
                }
            }
            temp.add(res);
        }
        return temp;
    }
    public static int work(boolean board[][],int row){
        if(row==board.length){
            System.out.println("new chess board");
            return 1;
        }
        int count=0;
        int cols=board[0].length;
        for(int i=0;i<cols;i++){
            if(isSafe(board, row, i)){
                board[row][i]=true;
                count+=work(board,row+1);
                board[row][i]=false;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n=4;
        ArrayList<ArrayList<String>>ans=new ArrayList<>();
        boolean board[][]=new boolean[n][n];
        System.out.println(work(board,0));
    }
}
