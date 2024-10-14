package SegmentTrees;

public class RangeUpdate {
    static int []lazy;
    static int []arr;
    private static void build(int node,int start,int end){
        if(start==end){
            lazy[node]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        build(node*2,start,mid);
        build(node*2+1,mid+1,end);
    }
    public static void update(int node,int start,int end,int l,int r,int val){
        if(end<l||r<start) return;
        if(start==end){
            lazy[node]+=val;
        }
        else if(l<=start&&end<=r){
            lazy[node]+=val;
        }
        else{
            int mid=(start+end)/2;
            update(node*2,start,mid,l,r,val);
            update(node*2+1,mid+1,end,l,r,val);
        }
    }
    public static void propagate(int node){
        int left=node*2;
        int right=node*2+1;
        lazy[left]+=lazy[node];
        lazy[right]+=lazy[node];
        lazy[node]=0;
    }
    public static int query(int index,int start,int end){
        if(start!=end) propagate(index);
        if(start==end){
            return arr[index];
        }
        else{
            int mid=(start+end)/2;
            if(start<=index&&index<=mid){
                return query(index,start,mid);
            }
            else return query(index,mid+1,end);
        }
    }

    public static void main(String[] args) {
        arr= new int[]{1,2,3,4,5};
        lazy=new int[4*arr.length+1];
        build(1,0,arr.length-1);
        for(int x:lazy){
            System.out.print(x+" ");
        }
        System.out.println();
        update(1,0,arr.length-1,1,3,4);
        System.out.println(query(1,0,arr.length-1));
        for(int x:lazy){
            System.out.print(x+" ");
        }
    }
}
