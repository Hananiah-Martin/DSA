import java.util.*;
class legs{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int temp= sc.nextInt();
            int count=0;
            while(temp>0){
                if(temp>=4){
                    temp-=4;
                }
                else{
                    temp-=2;
                }
                count++;
            }
            System.out.println(count);
            t--;
        }
    }
}