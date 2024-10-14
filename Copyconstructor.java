public class Copyconstructor {
    public static void main(String args[]){
        Student s1=new Student();
        s1.name="Hananiah";
        s1.rollnumber=22;
        s1.rollnumber=24;
        s1.marks[0]=100;
        s1.marks[1]=200;
        s1.marks[2]=300;
        //shallow copy 
        //shollow copy refects changes
        Student s4=new Student(s1);
        s1.marks[0]=80;
        System.out.println(s4.name);
        System.out.println(s4.rollnumber);
        for(int i=0;i<=2;i++){
            System.out.println(s4.marks[i]);
        }        
    }
}
class Student{
    String name;
    int rollnumber;
    int marks[];
    Student(){
        marks=new int[3];
    }
    //shallow copy constructor
    // Student(Student s1){
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.rollnumber=s1.rollnumber;
    //     this.marks=s1.marks;
    // }
    //deep copy constructor
    //changes does not reflect
    Student(Student s1){
        marks=new int[3];
        this.name=s1.name;
        this.rollnumber=s1.rollnumber;
        for(int i=0;i<=2;i++){
            this.marks[i]=s1.marks[i];
        }
    }
}
