import java.util.ArrayList;

public class merge_two_binary_trees {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void inorder(Node root,ArrayList<Integer>list_1){
        if(root==null){
            return;
        }
        inorder(root.left, list_1);
        list_1.add(root.data);
        inorder(root.right, list_1);
    }
    public static void merge(ArrayList<Integer>list1,ArrayList<Integer>list2,ArrayList<Integer>final_arr){
        int i=0;
        int j=0;
        while(i<list1.size()&&j<list2.size()){
            if(list1.get(i)<=list2.get(j)){
                final_arr.add(list1.get(i));
                i++;
            }else{
                final_arr.add(list2.get(j));
                j++;
            }
        }
        while(i<list1.size()){
            final_arr.add(list1.get(i));
            i++;
        }
        while(j<list2.size()){
            final_arr.add(list2.get(j));
            j++;
        }
    }
    public static Node createBST(ArrayList<Integer>list,int st,int end){
        if(st>end){
            return null;
        }
            int mid=st+(end-st)/2;
            Node root=new Node(list.get(mid));
            root.left=createBST(list, st, mid-1);
            root.right=createBST(list, mid+1, end);
            return root;
    }
    public static Node mergetwoBST(Node root1,Node root2){
        ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        ArrayList<Integer>final_arr=new ArrayList<>();
        //inorder sequence
        inorder(root1,list1);
        inorder(root2, list2);
        merge(list1, list2, final_arr);
        return createBST(final_arr, 0, final_arr.size()-1);
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]){
        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);

        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);
        Node root3=mergetwoBST(root1, root2);
        preorder(root3);
    }
}
