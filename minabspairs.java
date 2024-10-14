import java.util.*;
public class minabspairs {
    public static void main(String args[]){
        int A[]={4,1,3,5};
        int B[]={7,4,9,10};
        Arrays.sort(A);
        Arrays.sort(B);
        int min=0;
        for(int i=0;i<A.length;i++){
            min+=Math.abs(A[i]-B[i]);
        }
        System.out.println(min);
    }
}
