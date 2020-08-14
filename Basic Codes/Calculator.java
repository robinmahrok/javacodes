import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
  void calc(String opcode, int... operand) {
    if (operand.length == 2) {
      if (opcode.startsWith("Add") || opcode.startsWith("add")) {
        System.out.println("Addition of operands is: " + (operand[0] + operand[1]));
      }
      if (opcode.startsWith("Sub") || opcode.startsWith("sub")) {
        System.out.println("Subtraction of operands is: " + (operand[0] - operand[1]));
      }
      if (opcode.startsWith("Mul") || opcode.startsWith("mul")) {
        System.out.println("Multiplication of operands is: " + (operand[0] * operand[1]));
      }
      if (opcode.startsWith("Div") || opcode.startsWith("div")) {
        if (operand[1] != 0)
          System.out.println("Division of operands is: " + (operand[0] / operand[1]));
        else System.out.println("second operand can not be 0");
      }
      if (opcode.startsWith("Mod") || opcode.startsWith("mod")) {
        if (operand[1] != 0)
          System.out.println("Modulus of operands is: " + (operand[0] % operand[1]));
        else System.out.println("second operand can not be 0");
      }
    } else if ((operand.length > 2 && operand.length < 5) || operand.length < 2) {
      System.out.println("Wrong no. of inputs for operands! ");
    } else if (operand.length >= 5) {
      if (opcode.equalsIgnoreCase("sum")) {
        int temp = 0;
        for (int i = 0; i < operand.length; i++) {
          temp = temp + operand[i];
        }
        System.out.println("Sum of given operands is "+temp);
      } else if (opcode.equalsIgnoreCase("Max")) {
        Arrays.sort(operand);
        System.out.println(operand[operand.length - 1]);
      } else if (opcode.equalsIgnoreCase("Min")) {
        Arrays.sort(operand);
        System.out.println(operand[0]);
      } else System.out.println("Wrong opcode!");
    } else System.out.println("There should more than 5 operands");
  }

  public static void main(String[] args)
  {
    Scanner s=new Scanner(System.in);
    Calculator c=new Calculator();
    System.out.println("Enter opcode: ");
    String str=s.next();
    System.out.println("Enter number of operands: ");
    int v=s.nextInt();
    System.out.println("Enter "+v+" operands: ");
    int []arr=new int[v];
    for (int i = 0; i <v ; i++) {
      arr[i]=s.nextInt();
    }
    c.calc(str,arr);
  }
}
