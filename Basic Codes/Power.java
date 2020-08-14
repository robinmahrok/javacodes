public class Power
{
  public static void main(String[] args)
  {
    int n = 10, i, j;
    int []arr = new int[100];         //array is made

    for (i = 1,j=2; i <= n; i++)      //j=2 because we are not taking 2^0
    {
      if (i % 2 != 0)                 //for odd values
      {
        arr[i] = i;
      }
      else                            //for even values
        {
        arr[i]=1<<i/2;
                               //for power of 2
        }
    }
    for (i = 1; i <= n; i++)
    System.out.print(arr[i]+" ");          //print new array
    System.out.println("");
    System.out.println("last digit is "+arr[n]);
  }
}
