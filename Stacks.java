import java.util.Stack;
public class Stacks {
    public static void pushAtBottom(Stack<Integer>s,int data){
    if(s.isEmpty()){
        s.push(data);
        return;
    }
    int top=s.pop();
    pushAtBottom(s,data);
    s.push(top);
}
    public static String reverseString(String str){
        Stack<Character>s=new Stack<>();
        int idx=0;
        while(idx<str.length()){
            char ch=str.charAt(idx);
            s.push(ch);
            idx++;
        }
        StringBuilder str2=new StringBuilder("");
        while(!s.isEmpty()){
            char curr=s.pop();
            str2.append(curr);
        }
        return str2.toString();
    }
    public static void reversestack(Stack<Integer>s){
        if(s.isEmpty()){
            return;
        }
        int top=s.pop();
        reversestack(s);
        pushAtBottom(s, top); 
    }
     public static void main(String[] args) {
        int temperatures[]={73,74,75,71,69,72,76,73};
        var stack = new Stack<Integer>();
        var ans = new int[temperatures.length];
    
        for (var i=0; i < temperatures.length; i++) {
          while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
            var a = stack.pop();
            ans[a] = i-a;
          }
          stack.push(i);
        }
       for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
       }
    }
}
