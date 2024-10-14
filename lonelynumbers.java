import java.util.ArrayList;
public class lonelynumbers {
    public static void main(String args[]){
        ArrayList<Integer>list=new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        for(int i=0;i<list.size()-1;i++){
            int x=1;
            for(int j=i+1;j<list.size()-1;j++){
                if(list.get(i)==list.get(j)||list.get(i)==list.get(j)-1||list.get(i)==list.get(j)+1){
                    x=0;
                }
            }
            if(x==1){
                System.out.println(list.get(i));
            }
        }
    }
}
