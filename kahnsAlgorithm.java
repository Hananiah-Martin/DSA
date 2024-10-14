import java.util.*;
public class kahnsAlgorithm {
    public static void helper(ArrayList<ArrayList<Integer>>adj){
        int v=7;
        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            for(Integer it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int topo[]=new int[v];
        int i=0;
        while(!q.isEmpty()){
            int node=q.remove();
            topo[i++]=node;
            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }          
        }
        for(int num:topo){
            System.out.print(num+" ");
        }
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>>adj=graphsown.createGraph();
        helper(adj);
    }
}
