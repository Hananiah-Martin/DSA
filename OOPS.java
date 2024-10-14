public class OOPS{
    public static void main(String args[]){
        // Pen p1= new Pen();
        // p1.setColor("blue");
        // p1.setTip(5);
        // System.out.println(p1.getColor());
        // System.out.println(p1.getTip());
        //Constructor overloading
        Student s1=new Student();
        s1.name="aman";
        Student s2= new Student("MArtin");
        Student s3= new Student(456);
        System.out.println(s2.name);
        System.out.println(s3.rollnum);
        Student s4 = new Student(s1);
        System.out.println(s4.name);

    }
}
class Pen{
     private String color;
     private int tip;

     String getColor(){
        return this.color;
     }
     int getTip(){
        return this.tip;
     }

    void setColor(String newcolor){
        this.color=newcolor;
    }
    void setTip(int newtip){
        this.tip=newtip;
    }
}
class Student{
    String name;
    int rollnum;
    //constructor overloading 
    Student(){
        System.out.println("My name is hananiah Martin...");
    }
    Student(String naam){
        this.name=naam;
    }
    Student(int roll){
        this.rollnum=roll;
    }
    //copy constructor
    Student(Student s1){
        this.name=s1.name;
    }
}