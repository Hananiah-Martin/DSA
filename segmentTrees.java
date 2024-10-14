public class segmentTrees {
    static int tree[]=new int[15];
    public static void build(int node,int arr[],int start,int end){
        if(start==end){
            tree[node]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        build(node*2+1,arr,start,mid);
        build(node*2+2,arr,mid+1,end);
        tree[node]=Math.max(tree[node*2+1],tree[node*2+2]);
    }
    public static int query(int node,int tree[],int startInterval,int endInterval,int l,int r){
        if(startInterval>r||endInterval<l) return Integer.MIN_VALUE;
        if(startInterval>=l&&endInterval<=r){
            return tree[node];
        }
        int mid=(startInterval+endInterval)/2;
        int leftq1=query(2*node+1, tree, startInterval,mid, l, r);
        int rightq1=query(2*node+2, tree, mid+1,endInterval, l, r);
        return Math.max(leftq1,rightq1);
    }
    public static void main(String[] args) {
        int arr[]={5,3,2,4,1,8,6,10};
        build(0, arr, 0, arr.length-1);
         for(int num:tree) System.out.print(num+" ");
        int ans=query(0, tree, 0, arr.length-1, 5, 7);
         System.out.println(ans);
    }
}
