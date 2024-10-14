class Solution {
    public static long helper(int row,int col,int sum,int [][]points){
        if(row==points.length) return sum;
        long ans=0;
        for(int j=0;j<points[0].length;j++){
            ans=Math.max(ans,helper(row+1,j,sum+points[row][j]-Math.abs(col-j),points));
        }
        return ans;
    }
    public static long maxPoints(int[][] points) {
        return helper(0,0,0,points);
    }
    public static void main(String[] args) {
        int [][]points={{1,2,3},{1,5,1},{3,1,1}};
        System.out.println("hana"+0);
        System.out.println(maxPoints(points));
    }
}