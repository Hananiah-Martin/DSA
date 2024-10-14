public class path {
        public static float getpath(String str){
            int x=0;
            int y=0;
            int n=str.length();
            for(int i=0;i<n;i++){
                int dir=str.charAt(i);
                if(dir=='W'){
                    x=x-1;
                }
                else if(dir=='E'){
                    x=x+1;
                }
                else if(dir=='N'){
                    y=y+1;
                }
                else if(dir=='S'){
                    y=y-1;
                }
            }
            float X2=x*x;
            float Y2=y*y;
            return (float)Math.sqrt(X2+Y2);

        }
        public static void main(String args[]){
        String path="WNEENESENNN";
        System.out.println(getpath(path));
        String s1="Martin";
        String s2="MarTin";
        if(s1.equals(s2)){
            System.out.print("Strings are equal");
        }
        else{
            System.out.print("Strings are not equal");
        }
    }
}
