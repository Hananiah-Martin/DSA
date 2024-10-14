package Graphs.BFS_DFS;
import java.io.PrintWriter;
import java.util.*;
public class make_large_island {
    class Disjoint{
        ArrayList<Integer>size=new ArrayList<>();
        ArrayList<Integer>parent=new ArrayList<>();
        public Disjoint(int v){
            for(int i=0;i<=v;i++){
                size.add(1);
                parent.add(i);
            }
        }
        public int findParent(int node){
            if(node==parent.get(node)){
                return node;
            }
            int up=findParent(parent.get(node));
            parent.set(node,up);
            return parent.get(node);
        }
        public void unionBysize(int u,int v){
            int pu=findParent(u);
            int pv=findParent(v);
            if(pu==pv) return;
            if(size.get(pu)<size.get(pv)){
                parent.set(u,v);
                size.set(pv,size.get(pu)+size.get(pv));
            }
            else{
                parent.set(v,u);
                size.set(pu,size.get(pu)+size.get(pv));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        PrintWriter writer=new PrintWriter(System.out);
        writer.println("hello");
    }
}
