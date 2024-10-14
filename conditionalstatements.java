import java.util.Scanner;

public class conditionalstatements {
  public static void main(String[] args) {
    int age = 22;
    if (age > 18) {
      System.out.println("he is eligible to vote");

      int a = 16;
      if (a % 2 == 0) {
        System.out.println("Even number");
      }
      // Income tax calculator;
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter your annual income : ");
      int income = sc.nextInt();
      if ((income) < 500000) {
        System.out.println("you have to pay zero tax");
      } else if (income > 500000 && income < 1000000) {
        System.out.println("You have to pay 20% percent of your income as tax");
      } else if (income > 1000000) {
        System.out.println("you have to pay 30% of your income as tax");
        // switch statement
        int button = 2;
        switch (button) {
          case 1:
            System.out.println("Banana Juice");
            break;
          case 2:
            System.out.println("Grape juice");
            break;
          case 3:
            System.out.println("Mango juice");
            break;
          default:
            System.out.println("Wake up");
            break;
        }
        System.out.println("enter first number");
        System.out.println("enter second number");
        int b = sc.nextInt();
        System.out.println("enter operator");
        char operator = sc.next().charAt(0);
        switch (operator) {
          case '+':
            System.out.println(a + b);
            break;
          default:
            System.out.print("Wrong operator");
            break;
        }

      }
    }
  }
}
