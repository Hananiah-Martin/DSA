import java.util.*;
class leetcode451 {
    public static String frequencySort(String s) {
        int min = 1;
        int max = 0;
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        for(char chars:ch){
            System.out.print(chars+" ");
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
                min = Math.min(map.get(s.charAt(i)), min);
                max = Math.max(map.get(s.charAt(i)), max);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                min = Math.min(map.get(s.charAt(i)), min);
                max = Math.max(map.get(s.charAt(i)), max);
            }
        }
        String ans = "";
        int i=max;
        for(int j=0;j<ch.length;j++){
            if(map.get(ch[j])==max){
                ans+=ch[j];
                if(j==map.get(ch[i])&&map.get(ch[j+1])!=max){
                    max--;
                }
            }
            else{
                j=j+map.get(ch[j]);
            }
        }
        return ans;
    }
    public static void main(String[] args){ 
        System.out.println(frequencySort("loveleetcode"));
    }
}