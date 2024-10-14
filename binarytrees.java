import java.util.*;
public class binarytrees {
    static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node buildtree(int Nodes[]){
            idx++;
            if(Nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(Nodes[idx]);
            newNode.left=buildtree(Nodes);
            newNode.right=buildtree(Nodes);

            return newNode;
        }
        public static void preorder(Node root){
            if(root==null){
                System.out.print("-1"+" ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelorder(Node root){
            if(root==null){
                return;
            }
            Queue<Node>q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static void leftView(Node root){
            Queue<Node>q=new LinkedList<>();
            q.add(root);
            q.add(null);
            boolean starting=true;
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                        starting=true;
                    }
                }
                else{
                    if(starting){
                        System.out.print(currNode.data+" ");
                    }
                    starting=false;
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(lh, rh)+1;
        }
        public static int count(Node root){
            if(root==null){
                return 0;
            }
            int lc=count(root.left);
            int rc=count(root.right);
            return lc+rc+1;
        }
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int leftDiam=diameter(root.left);
            int rightDiam=diameter(root.right);
            int leftHt=height(root.left);
            int rightHt=height(root.right);
            int selfDiam=leftHt+rightHt+1;
            return Math.max(Math.max(rightDiam,leftDiam),selfDiam);

        }
    }
    public static void main(String args[]){
        int Nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildtree(Nodes);
        tree.levelorder(root);
        tree.leftView(root);

    }
}
