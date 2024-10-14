import java.util.Stack;

public class stackpractise {
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
        StringBuilder newstring=new StringBuilder("");
       int idx=0;
       while(idx<str.length()){
        char ch=str.charAt(idx);
        s.push(ch);
        idx++;
       }
       while(!s.isEmpty()){
            char curr=s.pop();
            newstring.append(curr);
       }
       return newstring.toString();
    }
    public static boolean validParenthesis(String str){
        Stack<Character>s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                else{
                    if(ch=='}'&&s.peek()=='{' || ch==')'&&s.peek()=='('||ch==']'&&s.peek()=='['){
                        s.pop();
                    }
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        else{
             return false;
        }
    }
    public static void main(String args[]){
        Stack<Integer>s=new Stack<>();
        int arr[]={14,15,67,2,4};
        int newarray[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!s.empty()&&arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                newarray[i]=-1;
            }
            else{
                newarray[i]=arr[s.peek()];
            }
            s.push(i);
        }
        // for(int i=0;i<newarray.length;i++){
        //     System.out.print(newarray[i]+" ");
        // }
        String str="{([{}])}";
        System.out.println(validParenthesis(str));
    }
}
