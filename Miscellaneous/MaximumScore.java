import java.util.*;

public class MaximumScore {
    static int maxscore=0;
    static void function(String words[],char letters[],int[] freq,int currscore,int i,int score[]){
        maxscore=Math.max(maxscore,currscore);
        if(i>=words.length){
            return;
        }
        //take
        int j=0;
        int tempscore=0;
        int[] tempFreq = Arrays.copyOf(freq, freq.length);
        while(j<words[i].length()){
            char ch = words[i].charAt(j);

            tempFreq[ch - 'a']--;
            tempscore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0)
                break;

            j++;
        }
        if(j==words[i].length()){
            function(words, letters,tempFreq,tempscore+currscore,i+1,score);
        }
        //nottake
        function(words, letters, freq, currscore, i+1, score);
    }
    public static void main(String[] args) {
        String words[]={"dog","cat","dad","good"};
        char letters[]={'a','a','c','d','d','d','g','o','o'};
        int score[]={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int[] freq = new int[26];
        for (char ch : letters) {
            freq[ch - 'a']++;
        }
        function(words,letters,freq,0,0,score);
        System.out.println(maxscore);
    }
}
