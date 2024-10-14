import java.util.ArrayList;

public class subsets {
    public static ArrayList<ArrayList<Integer>> helper(int nums[]){
        ArrayList<ArrayList<Integer>>outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num:nums){
            int n=outer.size();
            for(int i=0;i<n;i++){
                ArrayList<Integer>internal=new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        ArrayList<ArrayList<Integer>>res=helper(nums);
        for(ArrayList<Integer>list:res){
            System.out.println(list);
        }
    }
}
