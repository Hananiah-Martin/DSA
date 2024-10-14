import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean canBeAnswer(int heights[],int index,int bricks,int ladder){
        int temp[]=Arrays.copyOfRange(heights,0,index+1);
        Arrays.sort(temp);
        int count=ladder;
        int start=temp.length-1-count;
        long sum=0;
        while(start>=0){
            if(temp[start]>=0){
                sum=sum+temp[start];
            }
            start--;
        }
        if(sum<=bricks) return true;
        return false;
    }
    public static int solve(int arr[],int bricks,int ladder){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=Integer.MIN_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(canBeAnswer(arr,mid,bricks,ladder)){
                ans=Math.max(ans,mid);
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        // for(int i=n-1;i>=0;i--){
        //     if(canBeAnswer(arr,i,bricks,ladder)){
        //         return i+1;
        //     }
        // }
        if(ans==Integer.MIN_VALUE) return -1;
        return ans+1;
    }
    public static void main(String[] args) {
        int arr[]={14,3,19,3};
        int heights[]=new int[arr.length-1];
        for(int i=0;i<arr.length-1;i++){
            heights[i]=arr[i+1]-arr[i];
        }
        System.out.println(solve(heights, 17, 0));
    }
}