import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class concerttickets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] weightsStr = sc.nextLine().split(" ");
        Integer[] tickets = new Integer[n];
        for (int i = 0; i < n; i++) {
            tickets[i] = Integer.parseInt(weightsStr[i]);
        }
        sc.nextLine();
        String[] customerstr = sc.nextLine().split(" ");
        Integer[] customers=new Integer[m];
        for (int i = 0; i < m; i++) {
            customers[i] = Integer.parseInt(customerstr[i]);
        }
        Arrays.sort(tickets);
        int temp=0;
        int curr=0;
        int i=0;
        int j=0;
        while(i<n&&j<m){
            if(temp>=n) System.out.println(-1);
            else if(tickets[temp]<customers[j]){
                curr=tickets[i];
                temp++;
            }
            else if(Objects.equals(tickets[i], customers[j])) {
                System.out.println(tickets[temp]);
                j++;
                i++;
            }
            else{
                j++;
                i++;
                System.out.println(curr);
            }
        }
    }
}
