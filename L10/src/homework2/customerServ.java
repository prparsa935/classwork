package homework2;

import homework1.UserEn;

import java.rmi.Remote;
import java.util.List;

public interface customerServ extends Remote {
    void save(CustomerEn person)throws Exception;
    List<CustomerEn> report() throws Exception;
    void Update(CustomerEn Us) throws Exception;
}