public class olutioncodiingnija{
        public static int minimumRateToEatBananas(int []v, int h,int max) {
            int low=1;
            int high=max;
            while(low<high){
                int mid=(low+high)/2;
                int count=0;
                for(int i=0;i<v.length;i++){
                    
                }
                if(count>h) low=mid+1;
                else high=mid-1;
            }
            return low;
        }
        public static void main(String[] args) {
            int h=8;
            int v[]={7,15,6,3};
            int max=0;
            for(int num:v) max=Math.max(num,max);
            System.out.println(minimumRateToEatBananas(v, h,max));
        }
}