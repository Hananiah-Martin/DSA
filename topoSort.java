import java.util.*;
public class topoSort {
    public static void  helper(ArrayList<ArrayList<Integer>>adj,Stack<Integer>s,int vis[],int node){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                helper(adj,s,vis,it);
            }
        }
        s.push(node);
    }
    public static void main(String[] args) {
        Stack<Integer>s=new Stack<>();
        ArrayList<ArrayList<Integer>>adj=graphsown.createGraph();
        int vis[]=new int[adj.size()];
        helper(adj,s,vis,0);
        while(!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }
}
