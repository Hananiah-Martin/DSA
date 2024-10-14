public class cyclicsort{
    public static void main(String args[]){
        int a[]={3,5,2,1,4};
        int i=0;
        while(i<a.length){
            int correct_index=a[i]-1;
            if(a[i]!=correct_index){
                int temp=a[i];
                a[i]=a[correct_index];
                a[correct_index]=temp;
            }
            else{
                i++;
            }
        }
        for(int j=0;j<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
