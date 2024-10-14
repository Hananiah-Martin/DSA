import java.util.*;
public class wordLadder2 {
    static class pair{
        String first;
        int second;
        public pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void helper(String beginWord, String endWord, List<String> wordList){
        Queue<pair>q=new LinkedList<>();
        ArrayList<String>res=new ArrayList<>();
        q.add(new pair(beginWord, 1));
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            if(word.equals(endWord)){
                res.add(word);
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char charInit[]=word.toCharArray();
                    charInit[i]=ch;
                    String replaced=charInit.toString();
                    if(set.contains(replaced)){
                        q.add(new pair(replaced,steps+1));
                        set.remove(replaced);
                    }
                }
            }
        }

    }
    public static void main(String args[]){
      
    }
}
