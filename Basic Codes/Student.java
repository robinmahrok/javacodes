import java.util.Scanner;

public class Student
{
int roll,std,hindi,eng,phy,chem,maths,total;
float per;
String name,grade,remark;

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Student st=new Student();
    System.out.println("Enter full name: ");
    st.name=sc.nextLine();
    System.out.println("Enter Roll no. ");
    st.roll=sc.nextInt();
    System.out.println("Enter Standard: ");
    st.std=sc.nextInt();
    if(st.std<9 | st.std>12)
    {
      System.out.println("Wrong Standard");
      System.exit(0);
    }
    System.out.println("Enter Marks in Hindi: ");
    st.hindi=sc.nextInt();
    System.out.println("Enter marks in English: ");
    st.eng=sc.nextInt();
    System.out.println("Enter marks in Physics: ");
    st.phy=sc.nextInt();
    System.out.println("Enter marks in Chemistry: ");
    st.chem=sc.nextInt();
    System.out.println("Enter marks in Maths: ");
    st.maths=sc.nextInt();

    if(st.hindi>100 || st.hindi<0)
    {
      st.hindi = 0;
    }
    if(st.eng>100 ||st.eng<0)
    {
      st.eng = 0;
    }
    if(st.phy>100 ||st.phy<0)
    {
      st.phy = 0;
    }
    if(st.chem>100 ||st.chem<0) {
      st.chem = 0;
    }
    if(st.maths>100 ||st.maths<0)
    {
      st.maths=0;
    }
   st.total=st.hindi+st.eng+st.phy+st.chem+st.maths;
    st.per=(st.total/500.0f)*100.0f;
    if(st.per<50)
    {
      st.grade="FAIL";
      st.remark="Be Ready to do your same class again";
    }
    else if(st.per>=50 && st.per<60)
    {
      st.grade="E";
      st.remark="Need to work very hard";
    }
    else if(st.per>=60 && st.per<70)
    {
      st.grade="D";
      st.remark="Need to give more time";
    }
    else if (st.per>=70 && st.per<80)
    {
      st.grade="C";
      st.remark="Keep it up";
    }
    else if (st.per>=80 && st.per<90)
    {
      st.grade="B";
      st.remark="Best efforts";
    }
    else if (st.per>=90 && st.per<=100)
    {
      st.grade="A";
      st.remark="Best of Bests";
    }

    System.out.println("#Student's Report Card#");
    System.out.println("Roll No.: "+st.roll);
    System.out.println("Name: "+st.name);
    System.out.println("Standard: "+st.std);
    System.out.println("Marks in Hindi: "+st.hindi+"/100");
    System.out.println("Marks in English: "+st.eng+"/100");
    System.out.println("Marks in Physics: "+st.phy+"/100");
    System.out.println("Marks in Chemistry: "+st.chem+"/100");
    System.out.println("Marks in Maths: "+st.maths+"/100");
    System.out.println("Total marks: "+st.total+"/500");
    System.out.print("Percentage: "+st.per);
    System.out.println("%");
    System.out.println("Grade: "+st.grade);
    System.out.println("Remarks: "+st.remark);
    System.out.println("#End of the Report Card#");

    }
}
