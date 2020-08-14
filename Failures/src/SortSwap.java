import java.util.Scanner;

public class SortSwap 
{
	public static void main(String[] args) 
	{
		String [][]arr=new String[8][8];
	  arr[0][0]="Emp no";
	  arr[0][1]="Emp Name";
	  arr[0][2]="Join date";
	  arr[0][3]="Designation Code";
	  arr[0][4]="Department";
	  arr[0][5]="Basic";
	  arr[0][6]="HRA";
	  arr[0][7]="IT";
	  
	  arr[1][0]="1001";
	  arr[1][1]="Ashish";
	  arr[1][2]="01/04/2009";
	  arr[1][3]="e";
	  arr[1][4]="R&D";
	  arr[1][5]="2000";
	  arr[1][6]="8000";
	  arr[1][7]="3000";
	  
	  arr[2][0]="1002";
	  arr[2][1]="Sushma";
	  arr[2][2]="23/08/2012";
	  arr[2][3]="c";
	  arr[2][4]="PM";
	  arr[2][5]="30000";
	  arr[2][6]="12000";
	  arr[2][7]="9000";
	  
	  arr[3][0]="1003";
	  arr[3][1]="Rahul";
	  arr[3][2]="12/11/2008";
	  arr[3][3]="k";
	  arr[3][4]="Acct";
	  arr[3][5]="10000";
	  arr[3][6]="8000";
	  arr[3][7]="1000";
	  
	  arr[4][0]="1004";
	  arr[4][1]="Chahat";
	  arr[4][2]="29/01/2013";
	  arr[4][3]="r";
	  arr[4][4]="Front Desk";
	  arr[4][5]="12000";
	  arr[4][6]="6000";
	  arr[4][7]="2000";
	  
	  arr[5][0]="1005";
	  arr[5][1]="Ranjan";
	  arr[5][2]="16/07/2005";
	  arr[5][3]="m";
	  arr[5][4]="Engg";
	  arr[5][5]="50000";
	  arr[5][6]="20000";
	  arr[5][7]="20000";
	  
	  arr[6][0]="1006";
	  arr[6][1]="Suman";
	  arr[6][2]="1/1/2000";
	  arr[6][3]="e";
	  arr[6][4]="Manufacturing";
	  arr[6][5]="23000";
	  arr[6][6]="9000";
	  arr[6][7]="4400";
	  
	  arr[7][0]="1007";
	  arr[7][1]="Tanmay";
	  arr[7][2]="12/06/2006";
	  arr[7][3]="c";
	  arr[7][4]="PM";
	  arr[7][5]="29000";
	  arr[7][6]="12000";
	  arr[7][7]="10000";
	  
	  String [][]arr2=new String[6][3];
	  arr2[0][0]="Designation Code";
	  arr2[0][1]="Designation";
	  arr2[0][2]="DA";
	  
	  arr2[1][0]="e";
	  arr2[1][1]="Engineer";
	  arr2[1][2]="20000";
	  
	  arr2[2][0]="c";
	  arr2[2][1]="Consultant";
	  arr2[2][2]="32000";
	  
	  arr2[3][0]="k";
	  arr2[3][1]="Clerk";
	  arr2[3][2]="12000";
	  
	  arr2[4][0]="r";
	  arr2[4][1]="Receptionist";
	  arr2[4][2]="15000";
	  
	  arr2[5][0]="m";
	  arr2[5][1]="Manager";
	  arr2[5][2]="40000";
	  
	  
	  

Scanner s=new Scanner(System.in);
int name=s.nextInt();

		String dc="",sal="",dep="", err="";
		int d=-1,v=0;
		
		for(int i=1;i<8;i++)
		{ //check if the input matches any emp id from array arr
			
			if(Integer.parseInt(arr[i][0])==name)
			{
				dc=arr[i][3];
				// if present, index is noted
				d=i;
			}
			
		}
		if(d==-1)
		{ //if not present
			System.out.print("There is no employee with empid: "+Integer.toString(name));
			System.exit(0);
		}
		for(int i=0;i<5;i++)
		{
			if(arr2[i][0].equals(dc))
			{ // department and salary value id
				dep=arr2[i][1];
				sal=arr2[i][2];
				v=i;
			}
		}
		int salary=Integer.parseInt(arr[d][5])+Integer.parseInt(arr[d][6])+Integer.parseInt(arr2[v][2])-Integer.parseInt(arr[d][7]);
		System.out.println(arr[0][0]+"\t"+arr[0][1]+"\t"+arr[0][4]+"\t"+arr2[0][1]+"\tSalary");
		System.out.println(name+" \t"+arr[d][1]+"   \t"+arr[d][4]+"\t\t"+arr2[v][1]+"\t\t"+salary);
	}

}
