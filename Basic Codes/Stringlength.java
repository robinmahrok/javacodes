import java.util.Scanner;

public class Stringlength {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int i = 0, count = 0;
    System.out.println("Enter a String: ");
    String a = s.nextLine();
    //add null character at the end of String
    a = a + "\0";
    while(a.charAt(i)!='\0')
    { count++;
    i++;
    }
    System.out.println(count);
  }
}
