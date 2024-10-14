import java.util.Deque;
import java.util.LinkedList;

public class qusingsq {
    static class queue{
        Deque<Integer>dq=new LinkedList<>();
        public void add(int data){
            dq.addLast(data);
        }
        public int remove(){
            return dq.removeFirst();
        }
        public int peek(){
            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
        queue q=new queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
    }
}
