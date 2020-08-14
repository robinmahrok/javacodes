import java.io.File;
import java.util.Scanner;

public class Directories
{
  public static void main(String[] args)
  { String path;
  int file1=0,dir1=0;
    System.out.println("Enter path: ");
    Scanner s=new Scanner(System.in);
    path=s.nextLine();
    File f=new File(path);
    if(f.exists())
    {
      System.out.println("Path is valid.. ");
      // to get all files at path.
     File[] files= f.listFiles();
     for(int i=0;i<files.length;i++)
     {
           if(files[i].isFile())
           {  String l=files[i].getName();
             System.out.print(l+"--------");
             System.out.println("It is a file: ");
             file1++;
           }
           else{ String m=files[i].getName();
             System.out.print(m+"--------");
             System.out.println("It is a Directory: ");
           dir1++;
           }

        }
      System.out.println("\nNo. of files= "+file1+"\nNo. of Directories= "+dir1);
      System.out.println("Total Elements= "+(file1+dir1));
    }
    else System.out.println("Path is invalid!");
  }
}
