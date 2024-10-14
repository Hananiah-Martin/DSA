import java.util.ArrayList;

public class binary_search_trees {
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=insert(root.left,val);
        }
        else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        else{
            return search(root.right,key);
        }

    }
    public static Node deletNode(Node root,int val){
        if(root.data<val){
            root.right=deletNode(root.right, val);
        }
        else if(root.data>val){
            root.left=deletNode(root.left, val);
        }
        else{
            //case-1(No child)
            if(root.left==null&&root.right==null){
                return null;
            }
            //case-2(one-child)
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //case 3(two children)
            else{
                Node IS=InorderSuccessor(root.right);
                root.data=IS.data;
                root.right=deletNode(root.right,IS.data);
            }
        }
        
        return root;
        
    }
    public static void  printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>k1&&root.data>k2){
            printInRange(root.left,k1,k2);
        }
        else if(root.data<k1&&root.data<k2){
            printInRange(root.right,k1,k2);
        }
        else{
            printInRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printInRange(root.right,k1,k2);
        }
    }
    public static void printR(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data<k1){
            printR(root.right, k1, k2);
        }
        if(root.data>k1&&root.data<k2){
            System.out.print(root.data+" ");
        }
        if(root.data>k1){
            printR(root.left, k1, k2);
        }
    }
    public static void printpath(ArrayList<Integer>path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("NULL");
    }
    public static void printroot2leaf(Node root,ArrayList<Integer>path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null&&root.right==null){
            printpath(path);
        }
        printroot2leaf(root.left,path);
        printroot2leaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static Node InorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static boolean isValidBst(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null&&root.data<=min.data){
            return false;
        }
        if(max!=null&&root.data>=max.data){
            return false;
        }
        return isValidBst(root.left, min,root)&&isValidBst(root.right,root,max);
    }
    public static void main(String[] args) {
      int values[]={8,5,3,1,4,6,10,11,14};
      Node root=null;
      for(int i=0;i<values.length;i++){
        root=insert(root, values[i]);
      }
      ArrayList<Integer>path=new ArrayList<>();
    //   printroot2leaf(root,path);
      printInRange(root, 1, 8);
    }
}
