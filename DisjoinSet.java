import java.util.*;
public class DisjoinSet {
    List<Integer>rank=new ArrayList<>();
    List<Integer>parent=new ArrayList<>();
    List<Integer>size=new ArrayList<>();
    public DisjoinSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUpar(int node){
        if(parent.get(node)==node) return node;
        int ulp=findUpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void UnionByRank(int u,int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
    public static void main(String[] args) { 
        DisjoinSet ds = new DisjoinSet(7);
        ds.UnionByRank(1, 2);
        ds.UnionByRank(2, 3);
        ds.UnionByRank(4, 5);
        ds.UnionByRank(6, 7);
        ds.UnionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUpar(3) == ds.findUpar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.UnionByRank(3, 7);
        if (ds.findUpar(3) == ds.findUpar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
