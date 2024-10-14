import java.util.*;
class solution {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        long ans=0;
        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->
            a[1]-b[1]);
        for(int i=0;i<nums1.length;i++){
            pq.add(new int[]{nums1[0],nums2[0]});
        }
        System.out.println(pq.size());
        for(int i=0;i<nums1.length-k;i++) pq.remove();
        int min=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            min=Math.min(min,pq.peek()[1]);
            ans+=pq.peek()[0];
            pq.remove();
        }
        System.out.println(min);
        return ans*min;
    }
    public static void main(String[] args) {
        int nums1[]={4,2,3,1,1};
        int nums2[]={7,5,10,9,6};
        System.out.println(maxScore(nums1, nums2, 1));
    }
}