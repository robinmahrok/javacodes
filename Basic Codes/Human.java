import java.util.Scanner;

public class Human {


  Scanner c=new Scanner(System.in);
  int age=c.nextInt();

  public static void main(String[] args) {
    Human h=new Human();

      if (h.age < 0) {
        System.out.println("Yet to be delivered");
      } else if (h.age == 0) {
        System.out.println("Born");
      } else if (h.age >= 1 && h.age <= 2) {
        System.out.println("Infant");
      } else if (h.age >= 3 && h.age <= 5) {
        System.out.println("Toddler");
      } else if (h.age >= 6 && h.age <= 12) {
        System.out.println("Kid");
      } else if (h.age >= 13 && h.age < 19) {
        System.out.println("Teen");
      } else if (h.age >= 20 && h.age <= 45) {
        System.out.println("Adult");
      } else if (h.age >= 46 && h.age <= 55) {
        System.out.println("Middle aged");
      } else if (h.age >= 56 && h.age <= 75) {
        System.out.println("Old");
      } else if (h.age >= 76 && h.age <= 100) {
        System.out.println("Very Old");
      } else if (h.age > 100) {
        System.out.println("Delivered to God");
      }
    }
  }

