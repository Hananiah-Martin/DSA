public class LinkedListtwo {
    public class Node{
        int data;
        Node next;
    }
    public static Node head;
    public static Node first;
    public static void main(String args[]){
        head=first;
        head.data=5;
        // head.next=first;
        System.out.println(head.data);
    }
}
