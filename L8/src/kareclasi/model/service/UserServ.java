package kareclasi.model.service;

import kareclasi.model.Entity.UserEn;
import kareclasi.model.Repo.UserRepo;

import java.util.List;


public class UserServ {
    private UserServ () {
    }

    private static UserServ personServ = new UserServ ();

    public static UserServ getInstance () {
        return personServ;
    }

    public void save (UserEn personEnti) throws Exception {
        try (UserRepo personRepo = new UserRepo ()) {
//            personEnti.setSalary (personEnti.getSalary () - (personEnti.getSalary () * 10 / 100));
            personRepo.insert (personEnti);
            personRepo.commit ();
        }
    }
    public void edit (UserEn personEnti) throws Exception{
        try (UserRepo personRepo=new UserRepo ()){
//            personEnti.setSalary (personEnti.getSalary ()-(personEnti.getSalary ()*10/100));
            personRepo.update (personEnti);
            personRepo.commit ();
        }
    }
    public void remove(Long id) throws Exception{
        try (UserRepo personRepo=new UserRepo ()){
            personRepo.delete(id);
            personRepo.commit ();
        }
    }
    public List<UserEn> report() throws Exception{
        List<UserEn> personEntis;
        try (UserRepo personRepo=new UserRepo ()){
            personEntis=personRepo.select ();
        }
        return personEntis;
    }

}

