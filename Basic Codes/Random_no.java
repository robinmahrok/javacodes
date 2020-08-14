import java.util.Random;
import java.util.Scanner;

public class Random_no {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();

    public static void main(String[] args)
    {
      Random_no rn=new Random_no();
      Random r=new Random();
      System.out.println(rn.n+" Random numbers are: ");
      for(int i=0;i<rn.n;i++)
      {

        int  j=r.nextInt();
        if (j>0)
        System.out.println(j);
        else System.out.println(j*(-1));
      }
    }
  }


