import java.util.ArrayList;

public class pairsum {
    // public static boolean pairsum1(ArrayList<Integer>arr,int target){
    //     int lp=0;
    //     int rp=arr.size()-1;
    //     while(lp<rp){
    //         if(arr.get(lp)+arr.get(rp)==target){
    //             return true;
    //         }
    //         if(arr.get(lp)+arr.get(rp)<target){
    //             lp++;
    //         }
    //         else{
    //             rp++;
    //         }
    //     }
    //     return false;
    // }
    public static boolean pairsum2(ArrayList<Integer>list,int target){
        int bp=-1;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){
                bp=i;
                break;
            }
        }
        int lp=bp+1;
        int rp=bp;
        int n=list.size();
        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1) % n;
            }
            else{
                rp=(n+rp-1) % n;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer>arr=new ArrayList<>();
        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        int target=21;
        System.out.println(pairsum2(arr,target));
    }
}
