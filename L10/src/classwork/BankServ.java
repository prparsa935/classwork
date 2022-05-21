package classwork;
import java.rmi.Remote;
import java.util.List;

public interface BankServ extends Remote {
    void save(BankEnt person)throws Exception;
    List<BankEnt> report() throws Exception;
    void Deposit(BankEnt source, BankEnt Destination) throws Exception;
}