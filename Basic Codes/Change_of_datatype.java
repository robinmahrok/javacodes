import java.util.Scanner;

public class Change_of_datatype
{
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter a String of type: ");
    String i=s.nextLine();
   int j=Integer.parseInt(i);

    long l=Long.parseLong(i);

    float f=Float.parseFloat(i);
    System.out.println(f);
  }
}
