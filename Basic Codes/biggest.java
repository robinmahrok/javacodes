
import java.util.Scanner;
public class biggest{
    public static void main(String args[])
    { int x,y,z;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first number ");
        x=s.nextInt();
        System.out.print("Enter the second number ");
        y=s.nextInt();
        System.out.print("Enter the third number ");
        z=s.nextInt();
        if(x>y && x>z)
        { System.out.print("largest number is "+x);
        }
        else if(y>x && y>z)
        {System.out.print("largest number is "+y);
        }
        else if(z>x && z>y)
        {System.out.print("largest number is "+z);
        }



    }
}