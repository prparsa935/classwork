package homework2;

import homework1.UserServiceIm;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ServerNotActiveException;

public class ServerMain {
    public static void main(String[] args)  {
        try {
            LocateRegistry.createRegistry(1099);
            UserServiceIm service = new UserServiceIm ();
            Naming.rebind("DBService",service);
            System.out.println ("Server is wait for request...");
        } catch (RemoteException e) {
            e.printStackTrace ();
        } catch (ServerNotActiveException e) {
            e.printStackTrace ();
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}
