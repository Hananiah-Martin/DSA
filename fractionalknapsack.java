public class fractionalknapsack {
    public static void main(String args[]){
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int W=50;
        int ratio[]=new int[val.length];
        for(int i=0;i<val.length;i++){
            ratio[i]=val[i]/weight[i];
        }
        int capacity=W;
        int finalval=0;
        for(int i=0;i<val.length;i++){
            if(capacity>=weight[i]){
                 finalval+=val[i];
                 capacity-=weight[i];
            }
            else{
                finalval+=capacity*ratio[i];
                capacity=0;
                break;
            }
        }
        System.out.println(finalval);
    }
}
