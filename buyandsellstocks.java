public class buyandsellstocks{
    public static void main(String args[]){
        int []prices={1,2,3,4,5};
        int n=prices.length;
        int[] new_array=new int[50];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                new_array[j]=prices[i]+prices[j];
            }
        }
        System.out.print(new_array);
    }
}