package classwork;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class BankServiceImplementor  extends UnicastRemoteObject implements BankServ {
    public BankServiceImplementor()throws Exception{}
    @Override
    public void save(BankEnt person) throws Exception {
        // System.out.println ("The client IP is:"+RemoteServer.getClientHost ());
        BankRepo personDA = new BankRepo ();
        personDA.insert(person);
        personDA.close();

    }

    @Override
    public List<BankEnt> report() throws Exception {
        //System.out.println ("The client IP is:"+RemoteServer.getClientHost ());
        BankRepo personDA = new BankRepo();
        List<BankEnt> personList =personDA.select();
        personDA.close();
        return personList;
    }

    @Override
    public void Deposit(BankEnt source, BankEnt Destination) throws Exception {
        BankRepo personDA = new BankRepo();
        personDA.Deposit(source,Destination);
        personDA.close();
    }
}
