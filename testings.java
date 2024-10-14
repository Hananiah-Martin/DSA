import java.util.Arrays;
import java.util.HashMap;

public class testings {
    public static void main(String[] args) {
        String s="abcdefghijklmnopqrstuvwxy??";
        String str = "";
        HashMap<Character, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        char temp = 'a';
        boolean found = false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '?') {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (!map.containsKey(ch)) {
                        map.put(ch, 1);
                        str += ch;
                        found = true;
                        break;
                    } else {
                        map.put(ch, map.get(ch) + 1);
                        if (map.get(ch) < min) {
                            temp = ch;
                        }
                    }
                }
                if (!found) {
                    str += temp;
                }
            } else {
                str += s.charAt(i);
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), 1);
                } else
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

            }
        }
        System.out.println(s);
    }
}