import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class distinctnumbers {
    public static void main(String[] args) {
        HashSet<Integer>map=new HashSet<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        int arr[]=new int[n];
        for(int i=0;i<n;i++) {
            int x = sc.nextInt();
            arr[i] = x;
            map.add(arr[i]);
        }
        System.out.println(map.size());
    }
}
