import java.util.*;
public class wordLadder {
    static class pair{
        String first;
        int second;
        public pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static int helper(String beginWord, String endWord, String string){
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(beginWord, 1));
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<string.length();i++){
            set.add(string.charAt(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            if(word.equals(endWord)){
                return steps;
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
        return 0;
    }
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<>();
        
        System.out.println(helper("hit","cog","h"));
    }
}
