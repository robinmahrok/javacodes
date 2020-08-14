import java.io.FileInputStream;
import java.util.Scanner;

public class Book_Store
{
  public static void main(String[] args)
  throws Exception
  {
    System.out.println("Enter a path: ");
    Scanner s=new Scanner(System.in);
    String path=s.nextLine();
    FileInputStream fi=new FileInputStream(path);
    byte[] b=new byte[fi.available()];
    fi.read(b);
    String str=new String(b,0,b.length);
    String []sr=str.split(",");
    System.out.println("#MENU#\n1. Show all books.\n2. Find book by ISBN\n3. Find book by price range\n4. Find book by topic and price range");
     int m=s.nextInt();
     int j=0;
     if(m==1) {
       for (int i = 0; i < sr.length; i++)
       {
         System.out.println("Book No: "+(i+1)+ " ISBN: " + sr[j++] + " Topic: " + sr[j++] + " Author: " + sr[j++] +
               " Price: " + sr[j++] + " Publication: "+sr[j]);
           if(j<65) j++;
            else break;
       }
     }
     else if(m==2) {
       System.out.println("Enter the ISBN:");
       int isbn = s.nextInt();
       int g2=0;
       String isb= Integer.toString(isbn);
       for (int i = 0; i < sr.length; i++) {
           if (sr[i].contains(isb))
           {
               g2=i;
           }
         }

       System.out.println("ISBN: " + sr[g2++] + "\nTopic: " + sr[g2++] + "\nAuthor: " + sr[g2++] +
           "\nPrice: " + sr[g2++] + "\nPublication: "+sr[g2]);
     }
     else if (m==3)
     {
       System.out.println("Enter the range of price:\nEnter First number: ");
       int p1=s.nextInt();
       System.out.println("Enter Second number:");
       int p2=s.nextInt();
       for(int i=0;i<14;i++)
       {
         int v=Integer.parseInt(sr[3+5*i]);
         if(v>=p1&&v<=p2)
         {
           System.out.println("ISBN: " + sr[(3+5*i)-3] + " Topic: " + sr[(3+5*i)-2] + " Author: " + sr[(3+5*i)-1] +
               " Price: " + sr[(3+5*i)] + " Publication: "+sr[(3+5*i)+1]);
         }
       }
     }
     else if (m==4) {
       System.out.println("Enter topic:");
       String top = s.next();
       System.out.println("Enter the range of price-\nEnter First number: ");
       int po = s.nextInt();
       System.out.println("Enter Second number:");
       int pt = s.nextInt();
       for(j=0;j<sr.length;j++)
       if(sr[j].contains(top))
       {
           int q = Integer.parseInt(sr[j+2]);
           if(q>=po&&q<=pt)
           {
             System.out.println("ISBN: " + sr[j-1] + " Topic: " + sr[j] + " Author: " + sr[j+1] +
                 " Price: " + sr[j+2] + " Publication: "+sr[j+3]);
           }
       }
     }
     else
       {
         System.out.println("Wrong Input!");
     }
  }
}
