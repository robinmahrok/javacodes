
public class digit
{
  public static void main(String[] args) {
    int n = 219;
    System.out.println(abc(n));

  }
  public static int abc(int n) {
    int sum = 0;
    while (n>0||sum>9)
    { if(n==0)
    {
      n=sum;
      sum=0;
    }
 else {
      sum = sum + n % 10;
      n = n / 10;
    }
    }

     return sum;
  }

}