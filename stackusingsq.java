import java.util.Deque;
import java.util.LinkedList;

public class stackusingsq {
    static class Stack{
        Deque<Integer>dq=new LinkedList<>();
        public void push(int data){
            dq.addLast(data);
        }
        public int pop(){
            return dq.removeLast();
        }
        public int peek(){
            return dq.getLast();
        }

    }
    public static void main(String args[]){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
    }
}
