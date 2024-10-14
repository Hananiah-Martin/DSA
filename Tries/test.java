package Tries;

public class test {
    static class Node{
        Node []children;
        boolean eow;
        public Node(){
            for(int i=0;i<26;i++){
                children=new Node[26];
                children[i]=null;
            }
            eow=false;
        }
    }
    static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];
        }
    }
    public static boolean Search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            if(i==word.length()-1&& !curr.children[idx].eow){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static boolean wordBreak(String []words,String key){
        if(key.isEmpty()) return true;
        for(int i=1;i<=key.length();i++){
            String firstpart=key.substring(0,i);
            String second=key.substring(i);
            if(Search(firstpart)&&wordBreak(words,second)){
                return true;
            }
        }
        return false;
    }
    public static boolean startsWith(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static int countNodes(Node root){
        if(root==null) return 0;
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }
    public static int countUniqueSubstring(String word){
        for(int i=0;i<word.length();i++){
            String suffix=word.substring(i);
            insert(suffix);
        }
        return countNodes(root);
    }
    public static void main(String[] args) {
        int ans=countUniqueSubstring("ababa");
        System.out.println(ans);
    }
}
