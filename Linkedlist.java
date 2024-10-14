  import java.util.*;
  public class Linkedlist{
    public class Node{
        int data;
        Node next;
    }
    public static Node head;
    public static Node tail;
    public static Node temp;
    public static Node newnode;
    public static int size; 
    public static Node secondNode;
    public static Node thirdNode;
     
    public void addFirst(int data){
        Node newnode=new Node();
        size++;
        if(head==null){
            head=tail=newnode;
            head.data=data;
            return;
        }
        else{
            newnode.data=data;
            newnode.next=head;
            head=newnode;
        }
    }
    public void addLast(int data){
        Node newnode=new Node();
        size++;
        if(head==null){
            head=tail=newnode;
            head.data=data;
        }
        else{
            tail.next=newnode;
            newnode.data=data;
            tail=newnode;
        }
    }
    public void addAtIndex(int data,int index){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newnode=new Node();
        size++;
        newnode.data=data;
        int i=0;
        temp=head;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public static int removefirst(){
        if(head==null){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        if(head==tail){
            int val=head.data;
            head=tail=null;
            return val;
        }
        int val=head.data;
        head=head.next;
        return val;
    }
    public static int removelast(){
        if(head==null){
            System.out.println("Linked list is empty");
        }
        if(head==tail){
            int val=head.data;
            head=tail=null;
            return val;
        }
        int val=tail.data;
        temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        return val;
    }
    public static void print(){
        temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    }
    //Finding the key using iteration
    public int itrsearch(int key){
        temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            else{
                i++;
                temp=temp.next;
            }
        }
        return -1;
    }
    //Finding the key using recursion
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int index=helper(head.next, key);
        if(index==-1){
            return -1;
        }
        return index+1;
    }
    //reversing the linked list
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public int recsearch(int key){
        return helper(head,key);
    }
    //remove nth node from end(important)
    public void removenthfromend(int n){
        int sz=0;
        Node temp=head;
        Node prev=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next;
            return;
        }
        int i=1;
        int itofind=sz-n;
        while(i<itofind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    //find mid node using slow-fast method
    public Node midnode(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(){
        if(head==null||head.next==null){
            return true;
        }
        Node prev=null;
        Node mid=midnode(head);
        Node curr=mid;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void removecycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

    }
    public Node getmid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public Node merge(Node head1,Node head2){
        Node mergedLL=new Node();
        Node temp=mergedLL;
        while(head1!=null&&head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }

    public Node mergesort(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node mid=getmid(head);
        Node righthead=mid.next;
        mid.next=null;
        Node newleft=mergesort(head);
        Node newright=mergesort(righthead);
        return merge(newleft,newright);
    }
    public void zigzag(){
        //find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        //reverse second half;
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //alternate merging
        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        while(left!=null&&right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;
            right=nextR;
            left=nextL;
        }
    }
    public void deleteNNodes(Node head,int m, int n){
       Node curr=head,t;
       while(curr!=null){
            for(int count=1;curr!=null&&count<m;count++){
                curr=curr.next;
            }
            if(curr==null){
                return;
            }
            t=curr.next;
            for(int count=1;count<=n&&t!=null;count++){
                t=t.next;
            }
            curr.next=t;
            curr=t;
       }
    }
    public void swap_nodes(int x,int y){
        if(x==y){
            return;
        }
        Node prevX=null,currX=head;
        while(currX!=null&&currX.data!=x){
            prevX=currX;
            currX=currX.next;
        }
        Node prevY=null,currY=head;
        while(currY!=null&&currY.data!=y){
            prevY=currY;
            currY=currY.next;
        }
        if(currX==null||currY==null){
            return;
        }
        if(prevX!=null){
            prevX.next=currY;
        }
        else{
            head=currY;
        }
        if(prevY!=null){
            prevY.next=currX;
        }
        else{
            head=currX;
        }
        Node temp=currX.next;
        currX.next=currY.next;
        currY.next=temp;
    }
    public static void main(String args[]){
        Linkedlist ll=new Linkedlist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);
        ll.print();
        System.out.println();
        ll.swap_nodes(3,6);
        ll.print();

    }
}