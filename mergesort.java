public class mergesort {
    public static void mergesorts(int arr[],int si,int ei){
       if(si<ei){
        int mid=(si+ei)/2;
        mergesorts(arr,0,mid);//left part
        mergesorts(arr,mid+1,ei);
        merge(arr,si,mid,ei);
       }
       
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int [4];
        int i=si;
        int j=mid+1;
        int k=si;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                k++;
                i++;
            }
            else{
                temp[k]=arr[j];
                k++;
                j++;
            }
            
        }
        while(i<=mid){
            temp[k]=arr[i];
            k++;
            i++;
        }
        while(j<=ei){
            temp[k]=arr[j];
            k++;
            j++;
        }
        for(k=si;k<temp.length;k++){
            temp[k]=arr[k];
        }
    }
    public static void main(String args[]){
        int arr[]={5,6,3,2,8};
        mergesorts(arr, 0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
