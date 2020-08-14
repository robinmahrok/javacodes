import java.util.HashMap;
import java.util.Scanner;

public class Scratch {
  Scanner scanner = new Scanner(System.in);
  HashMap<Integer, Integer> map;
  int length;

  public Scratch() {
    length = 0;
  }

  public void readArrayLength() {
    System.out.print("Enter length on array: ");
    length = scanner.nextInt();

    map = new HashMap<>(length);

    readNumbers();
  }

  public void readNumbers() {
    System.out.print("Enter " + length + " numbers: ");

    for (int i = 0; i < length; i++) {
      int key = scanner.nextInt();

      if (map.containsKey(key)) map.put(key, map.get(key) + 1);
      else map.put(key, 1);
    }

    printMap();
  }

  private void printMap() {
    map.forEach((key, value) -> System.out.println(key + ": " + map.get(key)));
  }

  public static void main(String[] args) {
    Scratch scratch = new Scratch();
    scratch.readArrayLength();
  }

}