public class sum{
    public static void main(String args[]){
        int a[]={-2,-1,4,5,3};
        int min=a[0];
        int max=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
            else{
                min=a[i];
            }
        }
        if(a[0]>a[1]){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }
        System.out.print(max);
        System.out.print(min);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}