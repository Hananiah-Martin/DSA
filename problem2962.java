public class problem2962 {
    public static void main(String args[]){
        int nums[]={1,3,2,3,3};
        int k=2;
        int max=0;
        for(int num:nums){
            max=Math.max(num,max);
        }
        int i=0,j=0,n=nums.length;
        long ans=0;
        int count=0;
        while(j<n){
            if(nums[j]==max){
                count++;
            }
            if(count>=k){
                ans+=n-j;
                break;
            }
            j++;
        }
        j++;
        while(i<=j&&j<n){
            if(nums[i]==max){
                count--;
                i++;
            }
            else i++;
            if(count>=k){
                ans+=n-j+1;
            }
            j++;
        }
        System.out.println(ans);
    }
}
