class Identity
{
  String name="Robin";
  int age=20;
  void show()
  {
    System.out.println("Player name : "+name);
    System.out.println("Age : "+age);
  }
}
class criket_player extends Identity
{
  String type="Cricket Player";
  public void show()
  {
    super.show();
    System.out.println("Player type : "+type);
  }
}
class football_player extends Identity
{
  String type="Footbal Player";
  public void show()
  {
    super.show();
    System.out.println("Player type : "+type);
  }
}
class hockey_player extends Identity
{
  String type="Hockey Player";
  public void show()
  {
    super.show();
    System.out.println("Player type : "+type);
  }
}

class Football
{
  public static void main(String args[])
  {
    criket_player c=new criket_player();
    football_player f=new football_player();
    hockey_player h=new hockey_player();
    c.show();
    f.show();
    h.show();
  }
}