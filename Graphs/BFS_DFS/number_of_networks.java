package Graphs.BFS_DFS;
import java.util.*;
public class number_of_networks {
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
        public static int makeConnected(int n, int[][] e) {
            for(int i=0;i<n;i++){
                rank.add(0);
                parent.add(i);
            }
            int extraEdges=0;
            for(int i=0;i<e.length;i++){
                int node=e[i][0];
                int neigh=e[i][1];
                if(findParent(node)==findParent(neigh)){
                    extraEdges++;
                }
                else{
                    unionByRank(node,neigh);
                }
            }
            int countC=0;
            for(int i=0;i<n;i++){
                if(parent.get(i)==i){
                    countC++;
                }
            }
            System.out.println(countC);
            System.out.println(extraEdges);
            int ans=countC-1;
            System.out.println(ans);
            if(extraEdges>=ans){
                return ans;
            }
            return -1;
        }

    public static void main(String[] args) {
        int n = 6;
        int [][]connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int ans=makeConnected(n,connections);
        System.out.println(ans);
    }
}
