import java.util.Scanner;

public class Frequency_of_String {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter two String: ");
    String str1 = s.nextLine();
    String str2 = s.nextLine();
    //storing first index of str2 in v
    int v = str1.indexOf(str2);
    //storing last index of str2 in c
    int c = str1.lastIndexOf(str2);
    int count = 0;
    System.out.println("First index of " + str2 + " in " + str1 + " = " + v);
    System.out.println("Last index of " + str2 + " in " + str1 + " = " + c);
    System.out.println("All the indexes of occurence of "+str2+" are: ");
    while(v>=0)
    {
      System.out.print(v+" ");
      //using string.indexOf(String,From_index)
      v=str1.indexOf(str2,v+1);
      //count++ for frequency
      count++;
    }
    System.out.println("\nFrequency = "+count);
  }
}