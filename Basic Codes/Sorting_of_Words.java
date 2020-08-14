import java.util.Scanner;

public class Sorting_of_Words {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int s4 = 0;
    System.out.println("Enter a String: ");
    String str1 = s.nextLine();
    String str2 = " ";
    String[] str3 = str1.split(str2);

    if (str3.length >= 8) {
      // two loops for sorting
      for (int i = 0; i < str3.length; i++) {
        for (int j=i+1;j<str3.length;j++) {
          s4 = str3[i].compareTo(str3[j]);
            if (s4 > 0) {
              // swapping values
              String v = str3[j];
              str3[j] = str3[i];
              str3[i] = v;
            }
        }
      }
      System.out.print("Words in Descending order are: ");
      for (int i =str3.length-1; i >=0; i--)
      {
        System.out.print(str3[i] + " ");
      }
      System.out.print("\nWords in Ascending order are: ");
    for(int i=0;i<str3.length;i++)
    {
      System.out.print(str3[i]+" ");
    }
    }
  }
}