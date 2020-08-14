import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;


public class Fis1
{
  public static void main(String[] args)
      throws Exception
  {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter a path");
    String path = s.nextLine();
 File f2=new File(path);
 int uc=0,lc=0,vc=0;
 if(f2.exists())
    {
      if(f2.isFile()) {
        FileInputStream f1 = new FileInputStream(path);
        byte []arr= new byte[f1.available()];
        f1.read(arr);
        String str=new String(arr,0,arr.length);
        System.out.println(str);
        System.out.println("no. of characters= "+str.length());
        String []str2=str.split("\n");
        System.out.println("no. of lines= "+str2.length);
        for (int i=0;i<str.length();i++)
        {
          if(str.charAt(i)>='A' && str.charAt(i)<='Z')
          {
            uc++;
          }
          else if (str.charAt(i)>='a' && str.charAt(i)<='z')
          {
            lc++;
          }
        }
        System.out.println("Uppercase "+uc+"\nLowercase "+lc+"\nTotal alphabets "+(uc+lc));
       String [] sr=str.split(" ");
        System.out.println("No. of words= "+sr.length);
        for(int i=0;i<str.length();i++)
        {
          if(str.charAt(i)>='0' && str.charAt(i)<='9')
          {
            vc++;
          }
        }
        System.out.println("No. of integers= "+vc);

f1.close();
      }
else System.out.println("not a file");
    }
 else System.out.println("File not found");
  }
}
