import java.util.Scanner;

public class Employee
{
  int id;
  String name,design,dept;
  double basicSalary,hra,ta,da,pf,grossSalary;
  void inputEmployeeDetails()
  {
    Scanner s1=new Scanner(System.in);
    Scanner s2=new Scanner(System.in);
    System.out.println("Enter name of the employee: ");
    name=s2.nextLine();
    System.out.println("Enter Designation of the employee: ");
    design=s2.nextLine();
    System.out.println("Enter Department of the employee: ");
    dept=s2.nextLine();
    System.out.println("Enter Basic Salary of the employee: ");
    basicSalary=s1.nextDouble();
  }
  void calcuateSalary()
  {
    if(basicSalary<=10000)
    {
      hra=basicSalary*10/100;
      ta=basicSalary*8/100;
      da=basicSalary*6/100;
      pf=basicSalary*12/100;
    }
    else if(basicSalary>10000 && basicSalary<=20000)
    {
      hra=basicSalary*12/100;
      ta=basicSalary*10/100;
      da=basicSalary*8/100;
      pf=basicSalary*14/100;
    }
    else if(basicSalary>20000 && basicSalary<=30000)
    {
      hra=basicSalary*14/100;
      ta=basicSalary*12/100;
      da=basicSalary*10/100;
      pf=basicSalary*16/100;
    }
    else if(basicSalary>30000)
    {
      hra=basicSalary*16/100;
      ta=basicSalary*14/100;
      da=basicSalary*12/100;
      pf=basicSalary*18/100;
    }
    grossSalary=basicSalary+hra+ta+da-pf;
  }
  void printEmployeeSalary()
  {
    System.out.println("ID: "+id);
    System.out.println("Name: "+name);
    System.out.println("Department: "+dept);
    System.out.println("Designation: "+design);
    System.out.println("Basic Salary: "+basicSalary);
    System.out.println("HRA: "+hra);
    System.out.println("TA: "+ta);
    System.out.println("DA: "+da);
    System.out.println("PF: "+pf);
    System.out.println("Gross Salary: "+grossSalary+"INR/Month");
    System.out.println("Gross Salary: "+grossSalary*12+"INR/Year");


  }

  public static void main(String[] args) {
    Employee e=new Employee();
    e.inputEmployeeDetails();
    e.calcuateSalary();
    e.printEmployeeSalary();
  }
}
