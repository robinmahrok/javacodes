import java.util.Random;
import java.util.Scanner;

public class Random_only {
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
      System.out.println(j);
    }
  }
}
