public class KthAncestor {
    static class Node{
        Node right;
        Node left;
        int data;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int kthAnc(Node root,int k,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left=kthAnc(root.left, k, n);
        int right=kthAnc(root.right, k, n);
        int x=Math.max(left,right);
        if(x+1==k){
            System.out.println(root.data);
        }
        return x+1;
    }
    public static boolean isUnivalTree(Node root) {
        int val=root.data;
        if(root.data!=val){
            return false;
        }
        isUnivalTree(root.left);
        isUnivalTree(root.right);
        return true;
    }
    public static void main(String args[]){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        kthAnc(root, 2, 5);
        System.out.println(isUnivalTree(root));
    }
}
