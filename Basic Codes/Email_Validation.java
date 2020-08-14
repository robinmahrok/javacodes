import java.util.Scanner;

public class Email_Validation
{
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter E-mail");
    String str=s.nextLine();
    // for presence of @
    if(str.lastIndexOf("@")>=0)
    {// last index of '.' should be before last index of 'com'
    if(str.lastIndexOf(".")<str.lastIndexOf("com"))
    { // there must be atleast 2 characters between last index of '@' and '.'
       if(str.lastIndexOf("@")+3<str.lastIndexOf("."))
      { //there must be atleast 1 character before last index of '@'
        if(str.lastIndexOf("@")>2)
        { //if all criteria's are met, print the verified e-mail
          System.out.println("You have cleared the E-mail verification and your e-mail is "+str);
        }
        else
          System.out.println("There must be 2 characters before @");
      }
      else
        System.out.println("There must be atleast 2 characters between '@' and '.'");
    }
    else System.out.println("There must be a valid domain");
  }
    else
      System.out.println("'@' must be present ");
  }
}
