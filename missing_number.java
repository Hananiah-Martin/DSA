import java.util.Arrays;
public class missing_number{
    public static void main(String args[]){
        int a=5;
        boolean x=false;
        int arr[]={0,1,3,4,2};
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i!=arr[i]){
                System.out.print(i);
                break;
            }
        
        }
    }
}