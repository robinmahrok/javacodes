import java.util.Scanner;

public class sum {
    public static void main(String args[]) {
        int x, y, z;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first number ");
        x = s.nextInt();
        System.out.print("Enter the second number ");
        y = s.nextInt();

        z = x + y;
        {
            System.out.print("sum is " + z);
        }
    }
}
