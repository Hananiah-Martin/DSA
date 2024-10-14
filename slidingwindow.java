class slidingwindow {
    public static int secondsToRemoveOccurrences(String s) {
        int time=0;
        char[] ch = s.toCharArray();
        int count=1;
        while(count>=1){
            for(int i=0;i<ch.length;i++){
                if(i+1<ch.length){
                    if(ch[i]=='0'&&ch[i+1]=='1'){
                        ch[i]='1';
                        ch[i+1]='0';
                        i++;
                        time++;
                    }
                }
                if(i>1){
                    if(ch[i]=='1'&&ch[i-1]=='0'){
                        count++;
                    }
                }
            }
            if(count==1) break;
        }
        return time;
    }
    public static void main(String[] args) {
        System.out.println(secondsToRemoveOccurrences("0110101"));
    }
}