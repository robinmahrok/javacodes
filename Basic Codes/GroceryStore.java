import java.sql.SQLOutput;
import java.util.Scanner;

public class GroceryStore
{  int pi=0,np=0;
 double gst=0,tc=0;
  int []pid={101,102,103,104,105,106,107,108,109,110,111,112};
  String []pname={"Chips","Cold Drink","Cake","Apple","Banana","Chocolate","Toffee","Mango","Biscuit","Namkeen","Kurkure"
  ,"Red Bull","Toothpaste","Brush","Copy"};
  String []weight={"10gm","600ml","1 pound","1kg","1Dozen","5gm","20mg","1kg","10gm","500 gm","20gm","200ml","10gm"
      ,"5gm","20gm"};
  int []cost={15,40,200,80,40,20,1,50,40,50,10,100,20,20,40};
  String []expiry={"Aug-2020","May-2021","Aug-2019","Aug-2019","Aug-2019","Dec-2019","Dec-2020","Aug-2019"
  ,"May-2021","May-2020","Sept-2019","Aug-2019","Aug-2019","Aug-2019","Unlimited"};

  void everything()
  {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter Product Id between 101 and 112: ");
    pi=s.nextInt();
    // if no product or negative product is selected
    if(pi<1)
    {
      System.out.println("Wrong product id! ");
      System.exit(0);
    }
    System.out.println("Enter no. of products: ");
    np=s.nextInt();
    for(int i=0;i<12;i++)
    {
      if(pid[i]==pi)
      {
        System.out.println("Your Selected item is: "+pname[i]+"\nAnd no. of products is: "+np);
        System.out.println("Weight of one item: "+weight[i]);
        System.out.println("Expiry Date of Product is: "+expiry[i]);
        double v=cost[i]*np;
        gst=v*(.12);
        tc=(v+gst);
        System.out.println("Cost of product: "+cost[i]);
        System.out.println("Total cost of "+np+" products"+v);
        System.out.println("12% GST on "+np+" Products: "+gst);
        System.out.println("Total price with GST: "+tc);
      }
    }

  }

  public static void main(String[] args) {
    GroceryStore g=new GroceryStore();
    g.everything();
  }


}
