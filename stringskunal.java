import java.lang.reflect.Array;
import java.util.Arrays;

public class stringskunal {
    public static void main(String[] args) {
        String a="hananiah";
        String b="hananiah";
        //String pool
        //special memory allocated for same type of objects
        //here hananiah is stored in string pool
        // System.out.println(a==b);
        //strings are immutable because two different variables 
        //are pointing to same string and changes in one string
        //effect the other which is not possible.

        // String Comparisions
        //to create two different objects with same value we use
        //new keyword
        // String x=new String("hananiah");
        // String y=new String("hananiah");
        // System.out.println(x.equals(y));

        //tostring method
        // int m[]={1,2,3,4,5};
        // String n=Arrays.toString(m);
        // System.out.println(n.charAt(3));
        // for(int i=0;i<n.length();i++){
        //     System.out.print(n.charAt(i));
        // }
        
        //pretty printing
        // float z=431.2378f;
        // System.out.printf("Formatted string is %.10f",z);

        //when we concatenate the string with the number number will be converted
        //to INTEGER wrapper class.

        //System.out.println('a'-'b');

        // for(char ch='a';ch<'z';ch++){
        //     System.out.print(ch);
        // }

        StringBuilder str=new StringBuilder("hananiah");
        str.replace(0, 1, "b");
        System.out.println(str);
        str.delete(0, 1);
        System.out.println(str);
        str.reverse();
        System.out.println(str);
    }
}
