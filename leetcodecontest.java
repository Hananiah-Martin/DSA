public class leetcodecontest{
    public static int one(int arr[],int nums[]){
        int k=0;
        int m=nums.length;
        int count=0;
        int n=arr.length;
        for(int i=0;i+m<n;i++){
            for(int j=i+1;j<n;j++){
                if(k==m){
                    count++;
                    k=0;
                    break;
                }
                else if(j<n){
                    if(arr[j]-arr[j-1]>0&&nums[k]>0) k++;
                    else if(arr[j]-arr[j-1]==0&&nums[k]==0) k++;
                    else if(arr[j]-arr[j-1]<0&&nums[k]<0) k++;
                    else{
                        k=0;
                        break;
                    }
                }
            }
        }
        if(k==m) count++;
        return count;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int nums[]={1,1};
        System.out.print(one(arr,nums));
    }
}