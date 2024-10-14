public  class InBuiltFunctions {
    public static void printIntegerArr(int arr[]){
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
    public static void printIntegerArr(int arr[][]){
        for (int[] i : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(i[j] + " ");
            }
            System.out.println();
        }
    }
    public static void printStringArr(String arr[]){
        for(String x:arr){
            System.out.print(x+" ");
        }
    }

    public static void main(String[] args) {
        int arr[][]={{1,0},{5,6}};
        printIntegerArr(arr);
    }

}
