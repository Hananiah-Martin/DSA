
//  * Definition for singly-linked list.

import java.util.ArrayList;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1=0;
        int num2=0;
        ListNode temp1=l1;
        ListNode temp2=l2;
        while(temp1!=null){
            num1=num1*10+temp1.val;
            temp1=temp1.next;
        }
        while(temp2!=null){
            num2=num2*10+temp2.val;
            temp2=temp2.next;
        }
        int res=num1+num2;
        ArrayList<Integer>list=new ArrayList<>();
        if(list.size()==0){
            return l1;
        }
        while(res>0){
            int num=res%10;
            list.add(num);
            res=res/10;
        }
        ListNode root=new ListNode();
        root.val=list.get(list.size()-1);
        root.next=null;
        for(int i=list.size()-2;i>=0;i--){
            ListNode prev=root;
            ListNode newnode=new ListNode();
            prev.next=newnode;
            newnode.val=list.get(i);
            newnode.next=null;
            prev=newnode;
        }
        return root;
    }
}