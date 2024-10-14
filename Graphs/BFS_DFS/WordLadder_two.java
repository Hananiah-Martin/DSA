package Graphs.BFS_DFS;
import java.util.*;
public class WordLadder_two {
    static void printq(Queue<List<String>>q){
        for(int i=0;i<q.size();i++){
            System.out.println(q.peek()+" ");
        }
    }
    public static void helper(String beginWord,String endWord,List<String>wordList){
        Queue<List<String>>q=new LinkedList<>();
        q.add(new ArrayList<>(List.of(new String[]{beginWord})));
        List<List<String>>ans=new ArrayList<>();
        while(!q.isEmpty()){
//            printq(q);
            List<String>temp=q.peek();
            String word=temp.get(temp.size()-1);
            q.remove(temp);
            if(word.equals(endWord)&&!ans.contains(temp)){
                ans.add(temp);
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char []initArray=word.toCharArray();
                    initArray[i]=ch;
                    String replaced=new String(initArray);
                    if(wordList.contains(replaced)){
                        ArrayList<String>curr=new ArrayList<>(temp);
                        if(!curr.contains(replaced)){
                            curr.add(replaced);
                        }
                        q.add(curr);
//                        System.out.println("inside transformation");
//                        printq(q);
                    }
                }
                wordList.remove(word);
            }
        }
        System.out.print(ans);
    }
    public static void main(String[] args) {
        List<String>list=new ArrayList<>(List.of("hot","dot","dog","lot","log","cog"));
        helper("hit","cog",list);
    }
}
