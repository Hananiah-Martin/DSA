public class mounish {
    public static int count(String str1,String str2){
        int counts=0;
        int j=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            else if(str1.charAt(i)!=str2.charAt(j)){
                j=0;
            }
            if(j==str2.length()){
                if(str1.charAt(i)==str2.charAt(0)){
                    i=i-1;
                }
                counts++;
                j=0;
            }
        }
        return counts;
    }
    public static void main(String[] args) {
        System.out.println(count("ACAATCATCATACTATCATGAATCATCCT","ATCAT"));
    }
}
