import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityqueue {
    static class Student implements Comparable<Student>{
        Character name;
        int rank;
        public Student(Character name,int rank){
            this.name=name;
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.name-s2.name==0?s2.rank-this.rank:this.name-s2.name;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student>pq=new PriorityQueue<>();
        pq.add(new Student('a',22));
        pq.add(new Student('b',33));
        pq.add(new Student('c',10));
        pq.add(new Student('d',12));
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }

    }
}
