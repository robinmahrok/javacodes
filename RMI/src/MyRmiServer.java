import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRmiServer 
{
	public static void main(String[] args) 
	throws  Exception
	{
	// get object of registry
		
	Registry r = LocateRegistry.createRegistry(56837);
	
	// create object of class that implements
	// baby of remote interface
	BabyOfURO buro = new BabyOfURO();
	
	System.out.println("Server waiting for the clients..");
	// associate object buro with registry
	r.bind("src", buro);
	}
}