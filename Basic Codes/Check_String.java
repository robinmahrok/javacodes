import java.util.Scanner;

public class Check_String
{
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter two Strings: ");
    String str1=s.nextLine();
    String str2=s.nextLine();
    int count=0;
    String [] str3=str2.split("");
    for (int i=0;i<str3.length;i++) {
      if (str1.contains(str3[i])) {
        count++;
      } else {
        System.out.println("Data is not present");
        System.exit(0);
      }
    }
    if (count==str3.length)
    {
      System.out.println("Data is present.");
    }
  }
}
