import java.lang.*;
public class Car
{
 String name,maker,engine,color,type;
 float price;
 int model;

  public static void main(String[] args) {
    Car c1 = new Car();
    Car c2 = new Car();
    Car c3 = new Car();
    c1.name = "Swift";
    c1.maker = "Maruti";
    c1.engine = "1500cc";
    c1.color = "White";
    c1.type = "Diesel";
    c1.price = 7.8f;
    c1.model = 2019;
    c2.name = "Duster";
    c2.maker = "Renault";
    c2.engine = "2500cc";
    c2.color = "Brown";
    c2.type = "Diesel";
    c2.price = 9.72f;
    c2.model = 2019;
    c3.name = "Alto";
    c3.maker = "Maruti";
    c3.engine = "1200cc";
    c3.color = "Black";
    c3.type = "Petrol";
    c3.price = 4.5f;
    c3.model = 2018;

  if(c1.price>c2.price&&c1.price>c3.price)
  {
    System.out.println("C1 is most expensive and name = \"Swift\"\n" +
        "    maker = \"Maruti\"\n" +
        "    engine = \"1500cc\"\n" +
        "    olor = \"White\"\n" +
        "    type = \"Diesel\"\n" +
        "    price = 7.8f\n" +
        "    model = 2019");
  }
  else if(c2.price>c3.price&&c2.price>c1.price)
  {
    System.out.println("C2 is most expensive and name = \"Duster\"\n" +
        "    maker = \"Renault\"\n" +
        "    engine = \"2500cc\"\n" +
        "    color = \"Brown\"\n" +
        "    type = \"Diesel\"\n" +
        "    price = 9.72f\n" +
        "    model = 2019");
  }
  else {
    System.out.println("C3 is most expensive and name = \"Alto\"\n" +
        "    maker = \"Maruti\n" +
        "    engine = \"1200cc\n" +
        "    color = \"Black\"\n" +
        "    type = \"Petrol\"\n" +
        "    price = 4.5f\n" +
        "    model = 2018");
  }
    System.out.println("Prices of all the cars \n1. C1="+c1.price +"lacs\n2. C2="+c2.price+"lacs\n3. C3="+c3.price+"lacs\n");
  }
}
