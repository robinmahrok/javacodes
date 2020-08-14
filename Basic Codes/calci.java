import java.util.Scanner;

public class calci {
    public static void main(String args[])
    {
        int i,n,k,j,l,m,sum,diff,mul;
        float div;
        Scanner s= new Scanner(System.in);
        for(i=0;i<100;i++)
        {
            System.out.println("Enter first number");
            n=s.nextInt();
            System.out.println("What you want to do?");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            j=s.nextInt();
            System.out.println("Enter second number");
            k=s.nextInt();
            {
                if(j==1)
                {sum=n+k;
                    System.out.println("Sum is "+sum);
                }
                else if (j==2)
                {
                    diff=(n-k);
                    System.out.println("Difference is "+diff);
                }
                else if(j==3)
                {
                    mul=(n*k);
                    System.out.println("Multiply is "+mul);
                }
                else if(j==4)
                {
                    div=(n/k);
                    System.out.println("Division is "+div);
                }
                else if(j==5)
                {
                    break;
                }
            }
        }

    }
}
