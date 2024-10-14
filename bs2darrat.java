public class bs2darrat {
    public static boolean findIndex(int mat[][],int target){
       int row=0;
       int col=mat[0].length-1;
       while(row<mat.length&&col>=0){
            if(mat[row][col]==target){
                return true;
            }
            else if(mat[row][col]<target){
                row++;
            }
            else{
                col--;
            }
       }
       return false;
    }
    public static void main(String[] args) {
        int mat[][]={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(findIndex(mat, 11));
    }
}
