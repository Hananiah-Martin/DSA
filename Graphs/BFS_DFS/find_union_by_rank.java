package Graphs.BFS_DFS;

import java.util.ArrayList;

public class find_union_by_rank {
    static ArrayList<Integer>rank=new ArrayList<>();
    static ArrayList<Integer>parent=new ArrayList<>();
    public static int findParent(int node){
        if(node==parent.get(node)) return node;
        int ulp=findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public static void unionByRank(int u,int v){
        int p_u=findParent(u);
        int p_v=findParent(v);
        if(p_u==p_v) return;
        if(rank.get(p_u)<rank.get(p_v)){
            parent.set(p_u,p_v);
        }
        else if(rank.get(p_v)<rank.get(p_u)){
            parent.set(p_v,p_u);
        }
        else{
            parent.set(p_v,p_u);
            int ranku=rank.get(p_u);
            rank.set(p_u,ranku+1);
        }
    }
    public static void main(String[] args) {
        int n=7;
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
        unionByRank(1, 2);
        unionByRank(2, 3);
        unionByRank(4, 5);
        unionByRank(6, 7);
        unionByRank(5, 6);
        unionByRank(3,7);
        if(findParent(3)==findParent(7)){
            System.out.println("same");
        }
        else{
            System.out.println("not same");
        }
    }
}
