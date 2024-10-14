public class subarrays {
    public static void main(String args[]){
        int num[]={2,4,6,8,10};
        for(int i=0;i<=num.length-1;i++){
            int start=i;
            for(int j=0;j<=num.length-1;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    System.out.print(num[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
