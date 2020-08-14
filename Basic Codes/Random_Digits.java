import java.util.Random;
import java.util.Scanner;

public class Random_Digits {

  Scanner s = new Scanner(System.in);
  int n = s.nextInt();


  public static void main(String[] args)
  {
    int i, j,k;
    int []arr=new int[100];
    Random_Digits rn = new Random_Digits();
    Random r = new Random();
    System.out.println(rn.n + " Random numbers are: ");
   for(k=0;k<rn.n;k++)
   {
     j = r.nextInt();
     for (i = 0; i < 4; i++)
     {
       arr[i] = j % 10;
       j = j / 10;
     }
     for (i = 0; i < 4; i++)
     {
       if (arr[i] >= 0)
       {
         System.out.print(arr[i]);
       }
     }
    System.out.print("");
    for (i = 0; i < 4; i++)
    {
     if (arr[i] < 0)
     {
         arr[i] = arr[i] * -1;
         System.out.print(arr[i]);
     }
    }
      System.out.print(" ");
   }

  }
}

