import java.util.Scanner;

public class MatrixQues {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int [][]arr= new int[n][n];
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			arr[i][j]=s.nextInt();
		}
	}
	
	int [][]ar2=new int[n][n];
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			ar2[i][j]=s.nextInt();
		}
	}
	  for(int k=0;k<n;k++)
	  {
		  for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{  
				System.out.print(arr[k][j]*ar2[j][i]+" ");
			}
			
		}
		  System.out.println();
	  }
	  for(int k=0;k<n;k++)
	  {
		  for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{  
				System.out.print(ar2[k][j]*arr[j][i]+" ");
			}
			
		}
		  System.out.println();
	  }
}
}
