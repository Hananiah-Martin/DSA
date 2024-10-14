public class quicksort{
    public static void quicksorts(int arr[],int s,int e){
        if(s<e){
            int p=partition(arr,s,e);
            quicksorts(arr,s,(p-1));
            quicksorts(arr,(p+1),e);
        }
    }
    public static int partition(int arr[],int s,int e){
        int pivot=arr[e];
        int pIndex=s;
        for(int i=s;i<e;i++){
            if(arr[i]<=pivot){
                int temp=arr[i];
                arr[i]=arr[pIndex];
                arr[pIndex]=temp;
                pIndex++;
            }
        }
       int temp=arr[e];
        arr[e]=arr[pIndex];
        arr[pIndex]=temp;
        return pIndex;
    }
    public static void main(String args[]){
        int arr[]={8,3,10,21,1,7};
    System.out.println("after qucik sort"+" ");
    quicksorts(arr,0,5);
    for(int i=0;i<=5;i++){
        System.out.print(arr[i]+" ");
    }
    }
}