package homework1;

import homework1.UserEn;
import homework1.UserRepo;
import classwork.BankServ;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class UserServiceIm  extends UnicastRemoteObject implements UserServ {
    public UserServiceIm()throws Exception{}
    @Override
    public void save(UserEn person) throws Exception {
        // System.out.println ("The client IP is:"+RemoteServer.getClientHost ());
        UserRepo personDA = new UserRepo ();
        personDA.insert(person);
        personDA.close();

    }

    @Override
    public List<UserEn> report() throws Exception {
        //System.out.println ("The client IP is:"+RemoteServer.getClientHost ());
        UserRepo personDA = new UserRepo();
        List<UserEn> personList =personDA.select();
        personDA.close();
        return personList;
    }

    @Override
    public void Update(UserEn Us) throws Exception {
        UserRepo personDA = new UserRepo();
        personDA.Update(Us);
        personDA.close();
    }
}