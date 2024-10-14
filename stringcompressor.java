public class stringcompressor{
    public static StringBuilder compressed(String str){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            Integer count=1;
            while(i<str.length()-1&&str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb;
    }
    public static void main(String args[]){
        System.out.println(compressed("aaabbcccdd"));
    }
}