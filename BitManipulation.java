import java.util.ArrayList;

public class BitManipulation {
    public static void swap2Numbers(int a, int b){
        a=a^b;
        b=a^b;//b=(a^b)^b=>a^(b^b)=>a
        a=a^b;//a=>a^b^(b)=>a^b^a=>b
        System.out.println("a : "+a);
        System.out.println("b : "+b);
    }
    public static boolean isSet(int n,int i){
        //by left shift operator
        int y=n&1<<i;
        if(y==0){
            return false;
        }
        return true;
    }
    public static void isSet2(int n,int i){
        //by right shift operator
        int y=n>>i&1;
        if(y==0){
            System.out.println("not set");
        }
        else System.out.println("set");
    }
    public static int set_ith_bit(int n,int i){
        int y=n|1<<i;
        return y;
    }
    public static int clear_ith_bit(int n,int i){
        //inution is that if we and any digit with zero the resultant will be zero and 
        //the problem is asking to find to clear the ith bit
        //and if we and any digit with 1 the number will be same which make sures that other digits are not changed
        int x=~(1<<i);
        return n&x;
    }
    public static int toggle(int n,int i){
        int x=(1<<i);
        return n^x;
    }
    public static int removeRightMostSetBit(int n){
        return n&(n-1);
    }
    public static int noOfSetBits(int n){
        int count=0;
        for(int i=0;i<31;i++){
            int y=n>>i&1;
            if(y==1){
                count++;
            }
        }
        return count;
    }
    public static boolean isPowerOf2(int n){
        int res=noOfSetBits(n);
        if(res==1){
            return true;
        }
        return false;
    }
    public static int minimum_no_of_flips(int curr,int goal){
        //intuition is that if we observe or we can calculate how many bits are different in both
        //the numbers we can easily find out the answer.
        //for that we can easily xor because if the bits are same then no change if bits are different
        //the answer will be one and if we count the no of set bits in the tresultant we can easilt find out the answer
        int res=curr^goal;
        return noOfSetBits(res);
    }
    public static ArrayList<ArrayList<Integer>> printSubsets(int arr[]){
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        int subsetLength=(int)Math.pow(2,arr.length);
        int n=arr.length;
        for(int i=0;i<subsetLength;i++){
            ArrayList<Integer>temp=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(isSet(i, j)){
                   temp.add(arr[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
   public static void main(String[] args) {
        int arr[]={1,2,3};
      ArrayList<ArrayList<Integer>>list=new ArrayList<>();
      list=printSubsets(arr);
      System.out.println("aba".compareTo("ab"));
   } 
}
