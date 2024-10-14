import java.util.ArrayList;

public class bsttobalancedtree {
    static class Node{
        Node left;
        Node right;
        int val;
        
        public Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static void inorder(Node root,ArrayList<Integer>values){
        if(root==null){
            return;
        }
        inorder(root.left,values);
        values.add(root.val);
        inorder(root.right,values);
    }
    public static void print(ArrayList<Integer>values){
        for(int i=0;i<values.size();i++){
            System.out.print(values.get(i)+" ");
        }
    }
    public static Node createBst(ArrayList<Integer>values,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(values.get(mid));
        root.left=createBst(values, start,mid-1);
        root.right=createBst(values,mid+1, end);
        return root;
    }
    public static Node balancedbst(Node root){
        ArrayList<Integer>values=new ArrayList<>();
        inorder(root, values);
        return createBst(values, 0, values.size()-1);
    }
    public static void main(String args[]){
        Node root=new Node(8);
        root.left=new Node(6);
        root.right=new Node(10);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);
        root=balancedbst(root);
        
    }
}
