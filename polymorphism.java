public class polymorphism {
    public static void main(String args[]){
        //There are two types of polymorphism 
        //Run time polymorphism
        //compile time polymorphism 
        //Method overloading-Multiple functions with same name with different parameters
        //Method overloading
        calculator calc=new calculator();
        System.out.println(calc.sum(45,57,78));
        System.out.println(calc.sum((float)1.56, (float)35.89));
        System.out.println(calc.sum(78,98));
        //Method oveeriding-having same function but in different classess
        deer d=new deer();
        d.eats();
        //



    }
}
class calculator{
    int sum(int a, int b){
        return a+b;
    }
    float sum(float a,float b){
        return a+b;
    }
    int sum(int a,int b,int c){
        return a+b+c;
    }
}
class Animal{
    void eats(){
        System.out.println("eats");
    }
}
class deer extends Animal{
    void eats(){
        System.out.println("eats grass");
    }
}