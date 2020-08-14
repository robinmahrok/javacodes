import java.util.Arrays;

public class Example {
//  private int[] arr = {1, 2, 3, 4, 5, 6, 8, 9};
  private int[] arr = {1, 2, 3, 4};

  public void reverse(int[] arr) {
    // {1, 2, 3, 4, 5, 6, 7}
    // reverse the array
    // swap 1 and 7 -> {7, 2, 3, 4, 5, 6, 1}
    // swap 2 and 6 -> {7, 6, 3, 4, 5, 2, 1}
    // swap 3 and 5 -> {7, 6, 5, 4, 3, 2, 1}

    // for element in arr from 0 to 6
    // swap ith element with length - ith element
    for (int i = 0; i < arr.length / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = temp;
    }
  }

  public static void main(String[] args) {
    Example ex = new Example();
    System.out.println(Arrays.toString(ex.arr));
    ex.reverse(ex.arr);
    System.out.println(Arrays.toString(ex.arr));
  }
}
