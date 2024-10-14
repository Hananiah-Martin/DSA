import java.util.Deque;
import java.util.LinkedList;

public class deque {
    public static void main(String args[]){
        System.out.println("Hello world");
        Deque<Integer>dq=new LinkedList<>();
        dq.addLast(10);
        dq.addLast(20);
        dq.addLast(30);
        dq.addLast(40);
        dq.addLast(50);
        dq.addLast(60);
        dq.addLast(70);
        dq.addLast(80);
        dq.addLast(90);
        dq.addLast(100);
        System.out.print("Queue before reversing : ");
        System.out.println(dq);
        Deque<Integer>dq1=new LinkedList<>();
        for(int k=0;k<5;k++){
            int m=dq.removeFirst();
            dq1.addFirst(m);
        }
        int size=dq.size();
        for(int j=0;j<size;j++){
            int n=dq.removeFirst();
            dq1.addLast(n);
        }
        System.out.print("Queue after reversing : ");
        System.out.println(dq1);
    }
}
