import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
public class levelorder {
    
     
     public  static class Node {
          int data;
          Node left;
          Node right;
          Node(int data){
               this.data = data;
               this.left = null;
               this.right = null;
          }   
     }
     static HashMap<Integer,Integer>list=new HashMap<>();
     public static void leftview(Node root){
            if(root==null){
                return;
            }
            Queue<Node>q=new LinkedList<>();
            q.add(root);
            q.add(null);
            boolean starting  = true;
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.print(" ");
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                        starting = true;
                    }
                }
                else{
                    if(starting){
                        list.put(currNode.data,1);
                         System.out.print(currNode.data+" ");
                    }
                    starting = false;
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
          public static void leafNodes(Node root){
               if(root==null){
                    return;
               }
               if(root!=null&&root.left==null&&root.right==null){
                    if(!list.containsKey(root.data)){
                         list.put(root.data,1);
                         System.out.print(root.data+" ");
                         return;
                    }
               }
               leafNodes(root.left);
               leafNodes(root.right);
          }
          public static void rightView(Node root){
               if(root==null){
                    return;
                }
                Queue<Node>q=new LinkedList<>();
                q.add(root);
                q.add(null);
                while (!q.isEmpty()) {
                    Node currNode=q.remove();
                    if(q.peek()==null&&currNode!=null){
                        if(!list.containsKey(currNode.data)){
                            list.put(currNode.data,1);
                        }
                        System.out.print(currNode.data+" ");
                    }
                    if(currNode==null){
                        System.out.print(" ");
                        if(q.isEmpty()){
                            break;
                        }
                        else{
                            q.add(null);
                        }
                    }
                    else{
                        if(currNode.left!=null){
                            q.add(currNode.left);
                        }
                        if(currNode.right!=null){
                            q.add(currNode.right);
                        }
                    }
                }
                }
          public static void BoundaryTraversal(){
               System.out.println(list);
          }
        public static void main(String[] args){
          Node root = new Node(1);
           root.left = new Node(2);
           root.right=new Node(3);
           root.left.left=new Node(4);
           root.left.right=new Node(5);
           root.right.left=new Node(8);
           root.right.right=new Node(9);
           root.left.left.left=new Node(6);
           root.left.left.right=new Node(7);
           root.right.left.left=new Node(10);
           leftview(root);
           leafNodes(root);
           rightView(root);
           System.out.println(list);
        //   System.out.println("boundary traversal: ");
        //   BoundaryTraversal();
        }
}