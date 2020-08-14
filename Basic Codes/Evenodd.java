class Even extends Thread {
  public void run() {
    for (int i = 0; i < 50; i++) {
      if (i % 2 == 0)
        System.out.println(i);
    }
  }
}
class Odd extends Thread {
    public void run() {
      for (int i = 0; i < 50; i++) {
        if (i % 2 != 0)
          System.out.println(i);
      }
    }

  }
class Evenodd {
      public static void main(String[] args)
      {
        Even e = new Even();
        Odd o = new Odd();
        e.start();
        o.start();
      }
    }
