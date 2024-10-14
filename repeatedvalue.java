public class repeatedvalue { 
    public static void main(String args[]){
        int a=0;
        int b[]={1,2,3,4,1};
        for(int i=0;i<b.length;i++){
            for(int j=i+1;j<b.length;j++){
                if(b[i]==b[j]){
                    a=a+1;
                }
            }
        }
        if(a>=1){
            System.out.println("true");
        }
        else{
            System.out.println("False");
        }
    }
 }

