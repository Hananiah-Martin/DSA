import java.util.*;
public class binarysearch {
    public static void main(String args[]){
        int numbers[]={2,4,6,8,10,12,14};
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the key you want to find");
        int key=sc.nextInt();
        int start=0,end=numbers.length-1;
        while(start<=end){
            
            int mid=(start+end)/2;
            if(numbers[mid]==key){
                System.out.println(mid);
            }
            if(numbers[mid]<key){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
    }
}
