import java.util.Scanner;

public class Medicine
{
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    int c=0;
    //database containing name of medicines
    String[] med={"Abatacept","Aslocera","Baclofen","Bayer","Calan","Corex","Dapso","Darvon","Etocox","Ecotrin"
    ,"Fabuxtat","Gudflam","Gudpress","Ibuprofin","Keflex","Lactulose","Lasix","Nafralin","Nadulol","Omeprazole","Omega-3","Paciron","Paclitaxel"
    ,"Rabeprazole","Raloxifin","Taclonex","Tacrine","Uabano","Ulleric","Xofluzole","Zolo","Zeleplazon"};
    System.out.println("Enter some Characters: ");
    String ch=s.nextLine();
    System.out.println("Your medicine could be:");
    for(int i=0;i<med.length;i++)
    {   // index of ch in ELEMENTS of given array
      c=med[i].indexOf(ch);

          if(c==0)
        System.out.println(med[i]);
  }
  }
}
