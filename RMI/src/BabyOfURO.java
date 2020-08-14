import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BabyOfURO extends UnicastRemoteObject
implements BabyOfRemote
{
	public String getMessage(String message)
	throws RemoteException
	{
		System.out.println("Data from the client "
				+ "is "+message);
		return "Hello: "+message;
	}
	
	public BabyOfURO() throws RemoteException
	{
		
	}
}
