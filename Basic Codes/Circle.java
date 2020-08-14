import java.util.Scanner;

public class Circle
{
double radius;
void inputRadius()
{
  Scanner s=new Scanner(System.in);
  System.out.println("Enter the radius of circle: ");
  radius=s.nextInt();

}
void showRadius()
{
  if (radius>0.0)
  {
    System.out.print("Radius is: ");
    System.out.println(radius+"cm");
  }
  else {
    System.out.println("Wrong Input");
    System.exit(0);
  }
}
void showDiameter()
{

  System.out.print("Diameter of circle is: ");
  System.out.println(radius*2+"cm");
}
void showCircumference()
{
  System.out.println("Circumference of circle is: ");
  System.out.println((2*3.14*radius)+"cm");
}
  void showArea()
  {
    System.out.println("Area of circle is: ");
    System.out.println((radius*3.14*radius)+"sqcm");
  }


  public static void main(String[] args) {
    Circle c=new Circle();
    c.inputRadius();
    c.showRadius();
    c.showDiameter();
    c.showCircumference();
    c.showArea();
  }



}
