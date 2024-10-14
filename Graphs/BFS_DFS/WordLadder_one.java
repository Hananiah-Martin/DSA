package Graphs.BFS_DFS;
import java.util.*;
public class WordLadder_one {
    static class pair{
        String first;
        int second;
        public pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static int helper(String beginWord, String endWord, List<String> wordList){
        //create queue to implement level order
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(beginWord,1));
        //to search and delete operations in constant time
        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        while(!q.isEmpty()){
            String first=q.peek().first;
            int second=q.peek().second;
            q.remove();
            if(first.equals(endWord)){
                return second;
            }
            for(int i=0;i<first.length();i++){
                for(char j='a';j<='z';j++){
                    char []initChar=wordList.get(i).toCharArray();
                    initChar[i]=j;
                    String replaced= new String(initChar);
                    if(set.contains(replaced)){
                        q.add(new pair(replaced,second+1));
                        set.remove(replaced);
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        List<String>list=new ArrayList<>(List.of(new String[]{"hot","dot","dog","lot","log","cog"}));
        int ans=helper("hit","cog",list);
        System.out.println(ans);
    }
}
