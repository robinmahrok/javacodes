import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {

        int count, num1 = 0, num2 = 1;
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the number upto which you wish to find sequence");
        count = s.nextInt();
        System.out.print("Fibonacci Series of "+count+" numbers:");

        for (int i = 1; i <= count; ++i)
        {
            System.out.print(num1+" ");
            int sumOfPrevTwo = num1 + num2;
            num1 = num2;
            num2 = sumOfPrevTwo;
        }
    }

}
