import java.util.Scanner;

public class String_Words
{
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter a String: ");
    String str=s.nextLine();
    String str2=" ";
    //split the string from spaces
    String []str3=str.split(str2);
    System.out.println("No. of words in given String is: "+str3.length);

  }
}
