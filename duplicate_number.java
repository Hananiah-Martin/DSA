import java.util.Arrays;
public class duplicate_number{
    public static void main(String args[]){
        int a[]={2,3,3,5,1};
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}