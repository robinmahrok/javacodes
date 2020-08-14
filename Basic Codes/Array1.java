import java.util.Scanner;
public class Array1
{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n, sum = 0, sume = 0, sumo = 0, k = 0, k1 = 0, k2 = 0, k3 = 0, v = -1;

    //no of elements in array
    System.out.println("Enter the no of elements of array: ");
    n = s.nextInt();
    //declare an array
    int[] arr = new int[n];
    int[] e = new int[n];
    System.out.println("Enter " + n + " inputs in array: ");
    for (int i = 0; i < n; i++) {//taking inputs in array
      arr[i] = s.nextInt();
    }
    int count = arr[0];
    int count2 = arr[0];
    int count1 = 0, count3 = arr[0];
    //print array from left to right
    System.out.println("array from left to right: ");
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + "\t");
    }
    System.out.println(" ");
    //print array from right to left
    System.out.println("array from right to left: ");
    for (int i = n - 1; i >= 0; i--) {
      System.out.print(arr[i] + "\t");
    }
    System.out.println(" ");
    //sum of all the elements
    for (int i = 0; i < n; i++) {
      sum = sum + arr[i];
    }
    System.out.println("Sum of all elements of an array: ");
    System.out.println(sum);

    for (int i = 0; i < n; i++) {//sum of even index elements
      if (i % 2 == 0) {
        sume = sume + arr[i];
      }
//sum of all odd index elements
      if (i % 2 != 0) {
        sumo = sumo + arr[i];
      }

    }
    System.out.println("Sum of all elements on even indexes: " + sume);
    System.out.println("Sum of all elements on even indexes: " + sumo);
    //to find max value at index
    for (int i = 0; i < n; i++) {

      if (arr[i] > count) {
        count = arr[i];
        k = i;
      }
    }
    System.out.println(count + " is the max value and present at index " + k);
    //to find min value
    for (int i = 0; i < n; i++) {

      if (arr[i] < count2) {
        count2 = arr[i];
        k2 = i;
      }
    }
    System.out.println(count2 + " is the min value and present at index " + k2);
    //second max value
    for (int i = 0; i < n; i++) {
      if (i != k) {
        if (arr[i] > count1) {
          count1 = arr[i];
          k1 = i;
        }
      }
    }
    System.out.println(count1 + " is the second max value and present at index " + k1);
    //second min value
    for (int i = 0; i < n; i++) {
      if (i != k2) {
        if (arr[i] < count3) {
          count3 = arr[i];
          k3 = i;
        }
      }
    }
    System.out.println(count3 + " is the second min value and present at index " + k3);
    // frequency of elements
    for (int i = 0; i < n; i++) {
      int c = 1;
      for (int j = i + 1; j < n; j++) {
        if (arr[i] == arr[j]) {
          c++;
          e[j] = v;
        }
      }
      if (e[i] != v) {
        e[i] = c;
      }
    }
    System.out.println("Frequency of elements of array : ");
    for (int i = 0; i < n; i++)
    {
      if (e[i] != v)
        System.out.println(arr[i] + " = " + (e[i]));
    }
  }
  }


