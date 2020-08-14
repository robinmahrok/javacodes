import java.util.Scanner;
class Threading extends Thread {
  public void run() {
    System.out.println("thread is running");
  }

  public static void main(String[] args) {
    Threading T1=new Threading();
    T1.start();
  }
}

