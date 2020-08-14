import java.util.Scanner;

public class Watch
{int hour,minute,second;
void inputTime()
{
  Scanner s=new Scanner(System.in);
  System.out.println("Input time in format \thh \tmm \tss:");
  hour=s.nextInt();
  if(hour<=0||hour>=23)
  {
    System.out.println("Wrong Input for Hour!");
    System.exit(0);
  }
  minute=s.nextInt();
  if(minute<=0||minute>=59)
  {
    System.out.println("Wrong Minute!");
    System.exit(0);
  }
  second=s.nextInt();
  if(second<=0||second>=59)
  {
    System.out.println("Wrong second!");
    System.exit(0);
  }
}
void showTime12f()
{

  if(hour>12&&hour<24)
  {
    int g =hour-12;
    System.out.println("Time in 12f: ");
    System.out.println("Time= "+g+":"+minute+":"+second+" P.M");
  }
  else if(hour>=1&&hour<=11)
    { System.out.println("Time in 12f: ");
      System.out.println("Time= "+hour+":"+minute+":"+second+" A.M.");
    }
  else if(hour==0)
  { System.out.println("Time in 12f: ");
    System.out.println("Time= "+hour+":"+minute+":"+second+" Midnight");
  }
  else if(hour==12)

    { System.out.println("Time in 12f: ");
      System.out.println("Time= "+hour+":"+minute+":"+second+" Noon");
    }

}
void showTime24f()
{
  System.out.println("Time in 24f: ");
  System.out.println("Time= "+hour+":"+minute+":"+second);
}

  public static void main(String[] args) {
    Watch w=new Watch();
    w.inputTime();
    int j;
    Scanner C=new Scanner(System.in);

    System.out.println("Press 1 if you want to see time in 12f");
    System.out.println("Press 2 if you want to see time in 24f");
    j=C.nextInt();
    if(j==1) {
      w.showTime12f();
    }
    else if(j==2)
    {
      w.showTime24f();
    }
    else
    {
      System.out.println("Wrong Input!");
      System.exit(0);
    }
  }
}
