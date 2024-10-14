import java.util.ArrayList;

public class cherrypickup{
    static int countz=0;
    public static void count(int n){
        if(n==0){
            return;
        }
        if(n%10==0){
            countz++;
        }
        count(n/10);
    }
    public static ArrayList<Integer> findIndex(int arr[],int i,int target){
        ArrayList<Integer>list=new ArrayList<>();
        if(i==arr.length-1) return list;
        if(arr[i]==target) list.add(i);
        ArrayList<Integer>ansFromBelowCalls=findIndex(arr, i+1, target);
        list.addAll(ansFromBelowCalls);
        return list;
    }
    public static String skip(String s){
        if(s.isEmpty()){
            return "";
        }
        char temp=s.charAt(0);
        if(temp=='a'){
            return skip(s.substring(1));
        }
        else return temp+skip(s.substring(1));

    }
    public static void main(String[] args) {
        System.out.println(skip("hananiah"));
    }
}