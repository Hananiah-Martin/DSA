import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class Lowest_Common_Ancestor {
    static class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean getPath(Node root,int n,ArrayList<Node>path){
        if(root==null){
            return false;
        }
        else{
            path.add(root);
        }
        if(root.data==n){
            return true;
        }
         boolean fL=getPath(root.left, n, path);
         boolean fR=getPath(root.right, n, path);
         if(fL||fR){
            return true;
         }
         path.remove(path.size()-1);
         return false;

    }
    public static Node lowestCommonAncestor(Node root, int p, int q) {
        if(root==null||root.data==p||root.data==q){
            return root;
        }
        Node left=lowestCommonAncestor(root.left,p,q);
        Node right=lowestCommonAncestor(root.right,p,q);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;

    }
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node>path1=new ArrayList<>();
        ArrayList<Node>path2=new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i=0;
        for(;i<path1.size()&& i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca=path1.get(i-1);
        return lca;
    }
    public static int lcadist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftdist=lcadist(root.left, n);
        int rightdist=lcadist(root.right,n);
        if(leftdist==-1&&rightdist==-1){
            return -1;
        }
        else if(leftdist==-1){
            return rightdist+1;
        }
        else{
            return leftdist+1;
        }

    }
    public static int minDist(Node root,int n1,int n2){
        Node lca=lowestCommonAncestor(root, n1, n2);
        int dist_1=lcadist(lca,n1);
        int dist_2=lcadist(lca,n2);
        return dist_1+dist_2;
    }
    public static void main(String args[]){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        int n1=4;
        int n2=3;
        System.out.println("The minimum distance between " + n1 +" and "+ n2 +" is "+minDist(root, 4, 3));
    }
}
