import java.util.*;
public class queues{
    static class Queue {
        static Stack<Integer>s1=new Stack<>();
        static Stack<Integer>s2=new Stack<>();
        public static boolean iskhaali(){
            return s1.isEmpty();
        }
        public void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public int remove(){
            if(iskhaali()){
                System.out.println("Queue is Empty");
                return -1;
            }
            else{
                return s1.pop();
            }
        }
        public static void peek(){
            if(iskhaali()){
                System.out.println("Queue is Empty");
            }
            else{
                System.out.println(s1.peek());
            }
        }
        public boolean isEmpty() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
        }

    }
    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println();
            q.remove();
        }
    }
}