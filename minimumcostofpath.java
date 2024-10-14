public class minimumcostofpath {
    public static void main(String[] args) {
        int arr[][]={{31,100,65,12,18},{10,13,47,15,6},{100,113,174,11,33},
        {88,124,41,20,140},{99,32,111,41,20}};
        int sum=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i==0||j==0){
                    sum+=arr[i][j];
                    int min=Math.min(arr[i][j+1],arr[i+1][j]);
                    if(min==arr[i][j+1]){
                        j++;
                        i--;
                    }else{
                        i++;
                        j--;
                    }
                    sum+=min;
                }
                else if(j==4){
                    int min=Math.min(arr[i][j-1],arr[i+1][j]);
                    if(min==arr[i][j-1]){
                        j--;
                    }
                    else{
                        i++;
                    }

                }
                else{
                    int min=Math.min(Math.min(arr[i][j+1],arr[i-1][j]),arr[i+1][j]);
                    if(min==arr[i][j+1]){
                        j++;
                    }
                    else if(min==arr[i-1][j]){
                        i--;
                    }
                    else{
                        i++;
                    }
                    sum=sum+min+arr[i][j];
                }
            }
        }
        System.out.println(sum);
    }
}
