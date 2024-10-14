import java.util.*;
public class w385 {
    // public static int check(String num,String num2){
    //     int len=Math.min(num.length(),num2.length());
    //     int count=0;
    //     int j=0;
    //     for(int i=0;i<len;i++){
    //         if(num.charAt(i)==num2.charAt(j)){
    //             count++;
    //             j++;
    //         }
    //         else break;
    //     }
    //     return count;
    // }
    // public static int longestCommonPrefix(int[] arr, int[] arr2) {
    //     Arrays.sort(arr);
    //     Arrsy.sort(arr2);
    //     int n=arr.length;
    //     int ans=0;
    //     for(int i=0;i<n;i++){
    //         String num=String.valueOf(arr[i]);
    //         for(int j=0;j<arr2.length;j++){
    //             String num2=String.valueOf(arr2[j]);
    //             ans=Math.max(check(num,num2),ans);
    //         }
    //     }
    //     return ans;
    // }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0) return false;    
        }
        return true;
    }
    public static void traverse(int nums[][],int row,int col,HashMap<Integer,Integer>map){
        int m=nums.length;
        int n=nums[0].length;
        int num=nums[row][col];
        //traversing in the right direction
        for(int i=col+1;i<n;i++){
            num=num*10+nums[row][i];
            if(isPrime(num)){
               if(!map.containsKey(num)) map.put(num,1);
               else map.put(num,map.get(num)+1);
            }
        }
        //traversing in the downward direction
        num=nums[row][col];
        for(int i=row+1;i<m;i++){
            num=num*10+nums[i][col];
            if(isPrime(num)){
               if(!map.containsKey(num)) map.put(num,1);
               else map.put(num,map.get(num)+1);
            }
        }
        //traversing in leftward
        num=nums[row][col];
        for(int i=col-1;i>=0;i--){
            num=num*10+nums[row][i];
            if(isPrime(num)){
               if(!map.containsKey(num)) map.put(num,1);
               else map.put(num,map.get(num)+1);
            }
        }
        //traversing in up
        num=nums[row][col];
        for(int i=row-1;i>=0;i--){
            num=num*10+nums[i][col];
            if(isPrime(num)){
               if(!map.containsKey(num)) map.put(num,1);
               else map.put(num,map.get(num)+1);
            }
        }
        //travesing in the up left diagnoal
        num=nums[row][col];
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            num=num*10+nums[i][j];
            if(isPrime(num)){
               if(!map.containsKey(num)) map.put(num,1);
               else map.put(num,map.get(num)+1);
            }
        }
        num=nums[row][col];
        //traversing in the rightup diagonal
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            num=num*10+nums[i][j];
            if(isPrime(num)){
               if(!map.containsKey(num)) map.put(num,1);
               else map.put(num,map.get(num)+1);
            }
        }
        num=nums[row][col];
        //traversing in the rightdown diagonal
        for(int i=row+1,j=col+1;i<m&&j<n;i++,j++){
            num=num*10+nums[i][j];
            if(isPrime(num)){
               if(!map.containsKey(num)) map.put(num,1);
               else map.put(num,map.get(num)+1);
            }
        }
        num=nums[row][col];
        //traversing in the leftdown diagonal
        for(int i=row+1,j=col-1;i<m&&j>=0;i++,j--){
            num=num*10+nums[i][j];
            if(isPrime(num)){
               if(!map.containsKey(num)) map.put(num,1);
               else map.put(num,map.get(num)+1);
            }
        }
        // Set<Integer>keys=map.keySet();
        // for(int k:keys){
        //     System.out.print(k+" ");
        // }                    
    }
    public static int  third(int nums[][]){
        int m=nums.length;
        int n=nums[0].length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                traverse(nums,i,j,map);
            }
        }
        Set<Integer>keys=map.keySet();
        int max=0;
        int ans=0;
        for(int k:keys){
            if(map.get(k)>=max){
                ans=Math.max(ans,k);
                max=map.get(k);
            }
           System.out.print(k);
           System.out.print(" ");
           System.out.print(map.get(k));
           System.out.println();
        }         
        if(map.size()==0) return -1;
        return ans;
    }
    public static void main(String[] args) {
        int nums[][]={{1,3,4},{2,6,6}};
        System.out.println(third(nums));
    }
}
