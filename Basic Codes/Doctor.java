import javax.print.Doc;

public class Doctor
{
  String name,spec,clinic;
  float exp;
  int fee=0;
  Doctor()
  {
    name="Default";
    spec="Eye";
    clinic="Default";
    exp=5.0f;
  }
  Doctor(String D_name,String D_spec,String D_clinic,float D_exp)
  {
    name=D_name;
    spec=D_spec;
    clinic=D_clinic;
    exp=D_exp;

    if(exp<3.0f)
    {
      fee=200;
    }
    else if(exp>=3.0f &&exp<5.0f)
    {
      fee=500;
    }
    else if(exp>=5.0f &&exp<10.0f)
    {
      fee=700;
    }
    else if(exp>=10.0f)
    {
      fee=1000;
    }
  }
  void showData()
  {
    System.out.println("name "+name);
    System.out.println("spec "+spec);
    System.out.println("clinic "+clinic);
    System.out.println("experiance "+exp);
    System.out.println("fee "+fee);
  }

  public static void main(String[] args) {
    Doctor d1=new Doctor();
    d1.showData();
    Doctor d2=new Doctor("aman","Ear","Faizabad",5);
    d2.showData();
  }
}
