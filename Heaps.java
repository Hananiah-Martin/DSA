import java.util.*;
public class Heaps {
    static class heap{
        ArrayList<Integer>arr=new ArrayList<>();

        public void add(int data){
            arr.add(data);
            int child=arr.size()-1;
            int par=(arr.size()-1)/2;
            while(arr.get(child)<arr.get(par)){
                int temp=arr.get(child);
                arr.set(child,arr.get(par));
                arr.set(par,temp);
                child=par;
                par=(child-1)/2;
            }
        }
        public int peek(){
           return arr.get(0);
        }
        public void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;
            if(left<arr.size()&&arr.get(minIdx)>arr.get(left)){
                minIdx=left;
            }
            if(right<arr.size()&&arr.get(minIdx)>arr.get(right)){
                minIdx=right;
            }
            if(minIdx!=i){
                int temp=arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                heapify(minIdx);
            }
        }
        public int remove(){
            //swap first and last index
            int data=arr.get(0);
            int temp=arr.get(arr.size()-1);
            arr.set(0,temp);
            arr.set(arr.size()-1,arr.get(0));
            //remove the element which is in last index
            arr.remove(arr.size()-1);
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String[] args) {
       heap h=new heap();
       h.add(3);
       h.add(4);
       h.add(1);
       h.add(5);
    //    while(!h.isEmpty()){
    //     System.out.print(h.peek()+" ");
    //     h.remove();
    //    }
        h.heapify(0);
    }
}
