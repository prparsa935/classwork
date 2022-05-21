package homework2;

import homework2.CustomerEn;
import homework2.CustomerRepo;
import homework1.UserServ;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CustomerServIm extends UnicastRemoteObject implements customerServ {
    public CustomerServIm()throws Exception{}
    @Override
    public void save(CustomerEn person) throws Exception {
        // System.out.println ("The client IP is:"+RemoteServer.getClientHost ());
        CustomerRepo personDA = new CustomerRepo ();
        personDA.insert(person);
        personDA.close();

    }

    @Override
    public List<CustomerEn> report() throws Exception {
        //System.out.println ("The client IP is:"+RemoteServer.getClientHost ());
        CustomerRepo personDA = new CustomerRepo();
        List<CustomerEn> personList =personDA.select();
        personDA.close();
        return personList;
    }

    @Override
    public void Update(CustomerEn Us) throws Exception {
        CustomerRepo personDA = new CustomerRepo();
        personDA.Update(Us);
        personDA.close();
    }
}
