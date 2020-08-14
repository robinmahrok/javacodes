import java.util.Scanner;

public class UI
{
  public static void main(String[] args) {
    String []email={"ajay1@abc.com","aman2@bcd.com","akash3@skc.com"};
    String []password={"Ajay@1","Aman@3","Akash@4"};
    String []name={"Ajay","Aman","Akash"};
    String []mob={"8529637412","7418529637","1234567896"};
    String []add={"Delhi","Noida","Gurgaon"};
    Scanner s=new Scanner(System.in);
    System.out.println("Input E-mail Address: ");
    String em=s.nextLine();
    int j=0;
    for(int i=0;i<3;i++)
    { // ignore case in email verification
      if (em.equalsIgnoreCase(email[i]))
      {
        System.out.println("Input Password: ");
        String pass=s.nextLine();
        // need to check cases as well in password verification
        if(pass.equals(password[i]))
        {
          System.out.println("Name: "+name[i]);
          System.out.println("Mobile number: "+mob[i]);
          System.out.println("Address: "+add[i]);
        }
        else
        {
          System.out.println("Wrong Password! ");
        }
        // break the loop if email and password is verified
      break;
      }
      else {
        j++;
      }
    }
    if (j==3)
      System.out.println("Wrong input!");
  }
}
