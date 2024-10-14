public class missingnum {
    public static int[] findMissingRepeatingNumbers(int []a) {
        // Write your code here
        int res[]=new int[2];
        int n=a.length;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            temp[a[i]-1]++;
        }
        for(int i=0;i<n;i++){
            if(temp[i]==2){
                res[0]=i+1;
            }
            if(temp[i]==0){
                res[1]=i+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int a[]={8,4, 1, 6,7,2 ,5, 8};
        int ans[]=findMissingRepeatingNumbers(a);
        for(int i:ans){
            System.out.println(i+" ");
        }
    }
}
