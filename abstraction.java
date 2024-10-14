public class abstraction {
    public static void main(String args[]){
       //Abstration-hides unnecessary parts and display only important parts to the user 
       //we cannot create objects of abstract class
       //can have abstraction/non abstraction methods
       //can have constructors
       horse h=new horse();
       h.eats();
       h.walks();
       System.out.println(h.color);
       Student s1=new Student();
       s1.scname="hfems";
       Student s2=new Student();
       System.out.print(s2.scname);
       teacher t1=new teacher();
    }
}
abstract class animal{
    String color;
    animal(){
        color="brown";
    }
    void eats(){
        System.out.println("eats");
    }
    //In abstract method we cannot implement what we have to do but we can give an idea
    abstract void walks();
}
class horse extends animal{
    void walks(){
        System.out.println("walks with four legs");
    }
}
//Interface is blueprint of class
//This is used for total abstraction and applicable for multiple inheritance
//Interface keyword is used , implements is used instead of extend to get the properties of parent class
//All methods are public,abstract and without implementation
//variables in interface are final,static and public 

//Static keyword - static keyword is used to share the same variable and it saves our memory also.
//super keyword is used to call the immediate parent class
class Student{
    Student(){
        System.out.println("I love u mam");
    }
    static String scname;
    String name;
    int roll;
}
class teacher extends Student{
    teacher(){
        super();
    }
}
