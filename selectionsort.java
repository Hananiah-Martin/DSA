public class selectionsort{
    public static void main(String args[]){
        int arr[]={5,4,2,3,1};
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(max);
    }
}