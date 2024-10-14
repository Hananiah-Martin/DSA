import java.util.*;
public class graphsown {
    static int n=7;
    public static void hello(){
        System.out.println("hello world");
    }
    public static ArrayList<ArrayList<Integer>> createGraph(){
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
         //vertex 0 has directional outgoing edge towards 1
        //vertex may contain any number of edges with other vertexes
        adj.get(0).add(1);
        //edge between zero and three
        adj.get(0).add(3);
        //vertex 1 containing edge with 0
        adj.get(1).add(2);
        //edge between 1 and 2
        adj.get(1).add(4);
        //edge between 2 and 3
        // adj.get(2).add(1);
        //edge between 3 and 5
        adj.get(3).add(5);
        //edge between 3 and 6
        adj.get(3).add(6);
        //edge between 4 and 1          
        // adj.get(4).add(1);
        //edge between 5 and 3;
        // adj.get(5).add(3);
        //edge between 6 and 3;
        // adj.get(6).add(3);
        return adj;
    }
    public static void BFS(ArrayList<ArrayList<Integer>>adj){
        int vis[]=new int[n];
        Queue<Integer>q=new LinkedList<>();
        ArrayList<Integer>res=new ArrayList<>();
        q.add(0);
        vis[0]=1;
        while(!q.isEmpty()){
            int node=q.remove();
            res.add(node);
            vis[node]=1;
            //traversing through neighbours of the node
            for(int i=0;i<adj.get(node).size();i++){
                //getting the neighbours of node
                int j=adj.get(node).get(i);
                //if it is not visited then only add it in the queue
                if(vis[j]==0){
                    q.add(j);
                }
            }
        }
        System.out.println(res);
    }
    public static void DFS(ArrayList<ArrayList<Integer>>adj,int curr,int vis[],ArrayList<Integer>res){
        vis[curr]=1;
        res.add(curr);
        for(int i=0;i<adj.get(curr).size();i++){
            int j=adj.get(curr).get(i);
            if(vis[j]==0){
                DFS(adj,j,vis,res);
            }
        }
    }
    public static void convertToMatrix(ArrayList<ArrayList<Integer>>adj){
        int adjMat[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int k=adj.get(i).get(j);
                adjMat[i][k]=1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(adjMat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void convertToList(int adjMat[][]){
        int outerSize=adjMat.length;
        int innerSize=adjMat[0].length;
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<outerSize;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<outerSize;i++){
            for(int j=0;j<innerSize;j++){
                if(adjMat[i][j]==1){
                    adjList.get(i).add(j);
                }
            }
        }
        System.out.println(adjList);
    }
    public static void main(String args[]){
        int adjMat[][]={
            {0,1,0, 1, 0, 0, 0},
            {0,0 ,1 ,0 ,1 ,0 ,0 },
            {0,1 ,0 ,0 ,0 ,0 ,0 },
            {0 ,0 ,0 ,0 ,0 ,1 ,1},
            {0 ,1 ,0 ,0 ,0 ,0 ,0},
            {0 ,0 ,0 ,1 ,0 ,0 ,0},
            {0 ,0 ,0 ,1 ,0 ,0 ,0}};
            ArrayList<ArrayList<Integer>>adj=createGraph();
            System.out.println(adj);
    }
}
