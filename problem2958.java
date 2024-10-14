import java.util.HashMap;

public class problem2958 {
    public static void main(String[] args) {
        int nums[] = {1,4,4,3};
        int  k = 1;
        HashMap<Integer,Integer>map=new HashMap<>();
        int i=0,j=0,n=nums.length,ans=0,currSize=0;
        while(j<n){
            if(!map.containsKey(nums[j])){
                map.put(nums[j],1);
            }
            else map.put(nums[j],map.get(nums[j])+1);
            if(map.get(nums[j])<=k){
                ans=Math.max(ans,j-i+1);
            }
            else{
                while(map.get(nums[j])>k){
                    map.put(nums[i],map.get(nums[i])-1);
                    if(map.get(nums[i])==0){
                        map.remove(nums[i]);
                    }
                    i++;
                }
            }
            j++;
        }
        System.out.println(map);
        System.out.println(ans);
    }
}
