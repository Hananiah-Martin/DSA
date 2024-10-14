package Graphs.BFS_DFS;
import java.util.*;
public class practise {
    static class Disjoint{
        ArrayList<Integer>rank=new ArrayList<>();
        ArrayList<Integer>parent=new ArrayList<>();
        public Disjoint(int V){
            for(int i=0;i<=V;i++){
                rank.add(0);
                parent.add(i);
            }
        }
        public int findParent(int node){
            if(node==parent.get(node)){
                return node;
            }
            int ulp=findParent(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
        public void unionByRank(int u,int v){
            int pu=findParent(u);
            int pv=findParent(v);
            if(pu==pv) return;
            if(rank.get(pu)<rank.get(pv)){
                parent.set(pu,pv);
            }
            else if(rank.get(pv)<rank.get(pu)){
                parent.set(pv,pu);
            }
            else{
                parent.set(pv,pu);
                rank.set(pu,rank.get(pu)+1);
            }
        }
    }
    static class sol{
        static List<List<String>>merge(List<List<String>> details){
            int n=details.size();
            Disjoint ds=new Disjoint(n);
            HashMap<String,Integer>map=new HashMap<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<details.get(i).size();j++){
                    String mail=details.get(i).get(j);
                    if(!map.containsKey(mail)){
                        map.put(mail,i);
                    }
                    else{
                        ds.unionByRank(i,map.get(mail));
                    }
                }
            }
            System.out.println(map);
            ArrayList<String>[] mergedMail = new ArrayList[n];
            for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();
            for (Map.Entry<String, Integer> it : map.entrySet()) {
                String mail = it.getKey();
                int node = ds.findParent(it.getValue());
                mergedMail[node].add(mail);
            }
            List<List<String>> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (mergedMail[i].isEmpty()) continue;
                Collections.sort(mergedMail[i]);
                List<String> temp = new ArrayList<>();
                temp.add(details.get(i).get(0));
                temp.addAll(mergedMail[i]);
                ans.add(temp);
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };

        sol obj = new sol();
        List<List<String>> ans = sol.merge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }
}
