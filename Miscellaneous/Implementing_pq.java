import java.util.*;
class Implementing_pq {
    static class Char implements Comparable<Char>{
        char c;
        int occ;

        public Char(char c, int occ) {
            this.c = c;
            this.occ = occ;
        }

        @Override
        public int compareTo(Char that) {
            return this.c - that.c == 0 ? that.occ - this.occ : this.c - that.c;
        }
    }
    public static String clearStars(String s) {
        PriorityQueue<Char> pq = new PriorityQueue();
        for(int i=0; i<s.length(); i++) {
            if(!pq.isEmpty()){
                System.out.println(pq.peek().c+"->"+pq.peek().occ);
            }
            if(s.charAt(i) == '*') {
                pq.poll();
            } else {
                pq.offer(new Char(s.charAt(i), i));
            }
        }
        char[] ans = new char[s.length()];
        while(!pq.isEmpty()) {
            ans[pq.peek().occ] = pq.poll().c;
        }
        return new String(ans).replaceAll("\0", "");
    }

    public static void main(String[] args) {
        PriorityQueue<Char>pq=new PriorityQueue<>();
        pq.add(new Char('a',22));
        pq.add(new Char('b',33));
        pq.add(new Char('c',10));
        pq.add(new Char('d',12));
        while(!pq.isEmpty()){
            System.out.println(pq.peek().c+"->"+pq.peek().occ);
            pq.remove();
        }

        String ans=clearStars("aaba*");
        System.out.println(ans);
        System.out.println(10%5);
        int []arr1={2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int []arr2={2,42,38,0,43,21};
        int []res=new int[arr1.length];
        TreeMap<Integer, Integer> map
                = new TreeMap<Integer, Integer>();
        for(int i=0;i<arr1.length;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        int index=0;
        for(int i=0;i<arr2.length;i++){
            int num=arr2[i];
            if(map.containsKey(num)){
                for(int j=0;j<map.get(num);j++){
                    res[index]=num;
                    index++;
                }
                map.remove(num);
            }
        }
        for(Integer x:map.keySet()){
            for(int j=0;j<map.get(x);j++) {
                res[index] = x;
                index++;
            }
        }
    }
}