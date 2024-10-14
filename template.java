import java.util.*;
public class template {
     ArrayList<Integer>res=new ArrayList<>();
     HashMap<Integer,Integer>map=new HashMap<>();
     HashSet<Integer>set=new HashSet<>();
     PriorityQueue<Integer>pq=new PriorityQueue<>();
     PriorityQueue<int []>pq2=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
     ArrayList<ArrayList<Integer>>list=new ArrayList<>();
     Stack<Integer>st=new Stack<>();
     StringBuilder sb=new StringBuilder();
     int mod=(int)(1e9);
     int ans[];
     int max=Integer.MIN_VALUE;
     int min=Integer.MAX_VALUE;
     class pair{
        int first;
        int second;
        public pair(int f,int s){
            this.first=f;
            this.second=s;
        }
     }
    public  void print(int a){
        System.out.println(a);
    }
    public  void prints(String s){
        System.out.println(s);
    }
    public int[] sort(int []a){
         Arrays.sort(a);
         return a;
    }
    public int sieve(boolean primes[],int n){
        for(int i=2;i*i<n;i++){
            if(!primes[i]){
                for(int j=i*2;j<=n;j=j+i){
                    primes[j]=true;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(primes[i]==false) count++;
        }
        return count;
    }
    public static int max(int a,int b){
        return Math.max(a,b);
    }
    public static int min(int a,int b){
        return Math.min(a,b);
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
        }
        public static  long binpow(long  a, long  b) {
             long res = 1;
            while (b > 0) {
                if ((b & 1)==1)
                    res = res * a;
                a = a * a;
                b >>= 1;
            }
            return res;
        }
    static int answ=Integer.MAX_VALUE;
    public static void solve(int num,int n,int k){
        if(num>n) return;
        // list.add(num);
        if(k==1) answ=Math.min(answ,num);
        for(int i=0;i<=9;i++){
            int newnum=(num*10)+i;
            if(newnum>n) return;
            solve(newnum,n,k-1);
        }
    }
    static TreeSet<int[]> books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);

    public static boolean book(int s, int e) {
        int[] book = new int[] { s, e }, floor = books.floor(book), ceiling = books.ceiling(book);
        if (floor != null && s < floor[1]) return false; // (s, e) start within floor
        if (ceiling != null && ceiling[0] < e) return false; // ceiling start within (s, e)
        books.add(book);
        return true;
    }
    public static void main(String[] args) {
        for(int i=1;i<=9;i++){
            solve(i,13,2);
        }
        System.out.println(answ);
       books.add(new int[]{10,20});
       int book[]=new int[]{15,25};
       int floor[]=books.floor(book);
       int ceiling[]=books.ceiling(book);
        System.out.println(floor[1]);
    }
}
