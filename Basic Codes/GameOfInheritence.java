import java.util.Scanner;

class Foo
{
  int a;
  float b;
  String c;
}

class JFoo extends Foo
{
   int d;
   float e;
   String f;
  Scanner s=new Scanner(System.in);
   void Input_Integers()
   {

     System.out.println("Enter first integer:");
     a=s.nextInt();
     System.out.println("Enter second integer:");
     d=s.nextInt();
   }
   void Input_Float()
   {
     System.out.println("Enter first Float value:");
     b=s.nextFloat();
     System.out.println("Enter second Float value:");
     e=s.nextFloat();
   }
   void Input_String()
   {
     System.out.println("Enter first String:");
     c=s.next();
     System.out.println("Enter second String:");
     f=s.next();
   }
   void Show_Integer()
   {
     System.out.println("First Integer is: "+a);
     System.out.println("Second Integer is: "+d);
   }
   void Show_Float()
   {
     System.out.println("First float is: "+b);
     System.out.println("Second Float is: "+e);
   }
   void Show_String()
   {
     System.out.println("First String is: "+c);
     System.out.println("Second String is: "+f);
   }
   void Add_Integers()
   {
     System.out.println("Sum of integers is: "+(a+d));
   }
   void Sub_Float()
   {
     System.out.println("Subtraction of float is: "+(b-e));
   }
   void Compare_Strings()
   {
     System.out.println("Comparison of Strings is: "+c.compareTo(f));
   }
   void Swap_Integers()
   {
     int temp=0;
     temp=a;
     a=d;
     d=temp;
     System.out.println("Integers are swapped! ");
   }
   void Swap_Float()
   {
     float temp=0.0f;
     temp=b;
     b=e;
     e=temp;
     System.out.println("Float numbers are swapped! ");
   }
   void Swap_String()
   {
     String temp="";
     temp=c;
     c=f;
     f=temp;
     System.out.println("Strings are swapped! ");
   }
}
public class GameOfInheritence
{
  public static void main(String[] args) {
    JFoo j=new JFoo();
    j.Input_Integers();
    j.Show_Integer();
    j.Input_Float();
    j.Show_Float();
    j.Input_String();
    j.Show_String();
    j.Add_Integers();
    j.Sub_Float();
    j.Compare_Strings();
    j.Swap_Integers();
    j.Show_Integer();
    j.Swap_Float();
    j.Show_Float();
    j.Swap_String();
    j.Show_String();
  }
}
