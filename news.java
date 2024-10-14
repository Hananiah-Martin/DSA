public class news{
    public static void main(String[] args){
        int num[]={45,8,90,86,4};
        int largest=num[0];
        for(int i=1;i<=num.length;i++){
            if(num[i]>num[i-1]){
                largest=num[i];
            }
        }
    }
}
