public class inherit{
    public static void main(String args[]){
        // Animal lion = new Animal();
        // lion.eat();
        // Fish shark=new Fish();
        // shark.eat();
        dog rocky=new dog();
        rocky.breed="germanshepherd";
        System.out.println(rocky.breed);
        System.out.println(rocky.legs);
        rocky.eat();
    }
}
class Animal{
    String name;
    void eat(){
        System.out.print("eats food according to its sorroundigs");
    }
}
class Fish extends Animal{
    int fins;
}
// multilevel inheritance

class mammal extends Animal{
    int legs=4;
}
class dog extends mammal{
    String breed;
}
