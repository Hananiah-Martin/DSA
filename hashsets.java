import java.util.HashSet;

public class hashsets {
    public static int[] intersection(int arr1[],int arr2[]){
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        int new_arr[]=new int[arr1.length];
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                new_arr[i]=arr2[i];
                set.remove(arr2[i]);
            }
        }
        return new_arr;
    }
    public static int distinct(int arr[]){
        HashSet<Integer>num=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            num.add(arr[i]);
        }
        return num.size();
    }
    public static void main(String[] args) {
       int arr1[]={4,9,5};
       int arr2[]={9,4,9,8,4};
       int res[]=intersection(arr1, arr2);
       for(int i=0;i<res.length;i++){
        System.out.print(res[i]+" ");
       }
    }
}
