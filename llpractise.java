public class llpractise {
    //declaration of Node
    class node{
        int data;
        node next;
    }
    public static node head;
    public static node tail;
    public static node temp;
    public static node newnode;

    public void addFirst(int data){
        node newnode=new node();
        if(head==null){
            head=tail=newnode;
            head.data=data;
            return;
        }
        else{
            newnode.data=data;
            newnode.next=head;
            return;
        }
    }
    public void addLast(int data){
        node newnode=new node();
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
    public void print(){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    
    }
    public void addAtIndex(int idx,int data){
        node newnode=new node();
        if(idx==0){
            addFirst(data);
            return;
        }
        node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }
    public void removefirst(){
        if(head==null){
            System.out.println("linked list is empty : ");
        }
        if(head==tail){
            head=tail=null;
        }
        else{
            head=head.next;
        }
    }
    public void removelast(){
        if(head==null){
            System.out.println("linked list is empty : ");
        }
        if(head==tail){
            head=tail=null;
        }
        else{
            temp=head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
        }
    }
    public int iterativesearch(int key){
        int index=0;
        temp=head;
        while(temp!=null){
            if(temp.data==key){
                return index;
            }
            else{
                temp=temp.next;
                index++;
            }
            
        }
        return -1;
    }
    public void reverse(){
        node temp=head;
        node prev=null;
        node curr=head=tail;
        node next;
        while(temp!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
    }
    public void removenthfromend(int index){
        temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int i=0;
        int ifromstart=size-index;
        while(i<ifromstart){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
    }
    public node midnode(){
        node slow=head;
        node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args){
        Linkedlist ll=new Linkedlist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addAtIndex(7, 2);
        ll.print();
        System.out.println();
        // ll.reverse();
        ll.removenthfromend(3);
        ll.print();
        
    }
}
