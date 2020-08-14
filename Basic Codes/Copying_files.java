import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Copying_files
{
  public static void main(String[] args)
  throws Exception
  {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter Source path: ");
    String source=s.nextLine();
    System.out.println("Enter Destination path: ");
    String destination=s.nextLine();
    System.out.println("#Menu#");
    System.out.println("1. Copy source to destination.\n2. Attach source to destination.");
    int m=s.nextInt();
    if (m==1)
    {  FileInputStream fi=new FileInputStream(source);
      FileOutputStream fd=new FileOutputStream(destination,false);
      byte[] b=new byte[fi.available()];
      fi.read(b);
      String str=new String(b,0,b.length);
      byte []array=str.getBytes();
      fd.write(array);
      System.out.println("Data is written.");
      System.out.println("Size of file after it is written is: "+array.length+"bytes");
    }
    else if (m==2)
    {
      FileInputStream fs=new FileInputStream(source);
      FileInputStream fid=new FileInputStream(destination);
      FileOutputStream fdes=new FileOutputStream(destination,true);
     int v= fs.available();
     int j=fid.available();
      byte[] b=new byte[fs.available()];
      fs.read(b);
      String str=new String(b,0,b.length);
      byte []array=str.getBytes();
      fdes.write(array);
      System.out.println("Data is appended.");
      System.out.println("Size of file after it is appended is: "+(v+j)+"bytes");
    }
    else
    {
      System.out.println("Wrong Selection!");
    }

  }
}
