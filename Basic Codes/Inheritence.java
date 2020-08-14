//	Write a Java program to show that private member of a super class cannot be accessed from derived classes. 
class A
{
  private  int a=12,b=20;

  public  void fun1()
  {
    System.out.println(a + " " + b);
  }

}



class B extends A
{

  public static void fun()
  {

    A ob=new A();
    ob.fun1();

  }

  public static void main(String arg[])
  {
    B ob1=new B();

    ob1.fun();

  }
}


