public class sum_subarray{
    public static void main(String args[]){
        int sum=0;
        int num[]={2,4,6};
        int maxsum=0;
        for(int i=0;i<=num.length;i++){
            int start=i;
            for(int j=0;j<=num.length;j++){
                int end=j;
                for(int k=start;k<end;k++){
                    System.out.print(num[k]+" ");
                    sum=sum+num[k];
                    if(maxsum<sum){
                        maxsum=sum;
                    }
                }
                System.out.println();
            }
            System.out.print(sum);
            System.out.println();
        }
        System.out.print(sum);
    }
}
    