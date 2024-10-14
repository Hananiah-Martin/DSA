public class leetcode2109 {
    public static void main(String[] args) {
        int nums[]={3,-5,4,-6,10,11,-8,-10};
        int n=nums.length;
        int odd=0;
        int even=1;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                if(odd<n) res[odd]=nums[i];
                odd=odd+2;
            }
            else{
                if(even<n) res[even]=nums[i];
                even=even+2;
            }
        }
        if(res[n-1]==0){
            res[n-1]=nums[n-1];
        }
        for(int x:res){
            System.out.print(x+" ");
        }
    }
}
