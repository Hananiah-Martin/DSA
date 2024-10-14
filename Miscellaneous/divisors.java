public class divisors {
    static int no_of_divisors(int[] nums1, int[] nums2, int k){
        int n1=nums1.length;
        int n2=nums2.length;
        int mx= (int) 1e6;
        int []count=new int[mx+1];
        int []map=new int[mx+1];
//        for(int i=0;i<=mx;i++){
//            count[i]=0;
//            map[i]=0;
//        }
        //we have to find the divisors of the numbers in num2 array multiplied by k
        //to reduce more iteration we are using map to store the frequency
        for(int x:nums2){
            if(x*k<=mx){
                map[x*k]++;
            }
        }
        //so start from 1 and go till the maximum limit
        //we can see obviously that multiples start from the number itself, so it incremented
        //by the times of number itself that is what we are doing inside the j loop,
        //so we are adding the no of times it has occurred
        for(int i=1;i<=mx;i++){
            int ct=map[i];
            if(ct==0) continue;
            for(int j=i;j<=mx;j=j+i) {
                count[j] += ct;
            }
        }
        int ans=0;
        //since we have to find the divisors for num1 array we are looping through num1 array
        //and add no of divisors which we found through above loop
        for(int i=0;i<n1;i++){
            ans+=count[nums1[i]];
        }
        return ans;
    }
    public static void main(String[] args) {
        int []nums1={1,2,4,12};
        int []nums2={2,4,4};
        int k=3;
        int ans=no_of_divisors(nums1,nums2,k);
        System.out.println(ans);
    }
}
