import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BabyOfRemote extends Remote
{
	public abstract String getMessage
	(String message) throws RemoteException;
}