package tamrin2.model.service;


import tamrin2.model.Entity.CarEn;
import tamrin2.model.Repo.CarRepo;

import java.util.List;

public class CarSer {
    private CarSer () {
    }

    private static CarSer CarSer = new CarSer();

    public static CarSer getInstance () {
        return CarSer;
    }

    //    public void save (UserEn personEnti) throws Exception {
//        try (UserRepo personRepo = new UserRepo ()) {
////            personEnti.setSalary (personEnti.getSalary () - (personEnti.getSalary () * 10 / 100));
//            personRepo.insert (personEnti);
//            personRepo.commit ();
//        }
//    }
    public void edit (CarEn carEn) throws Exception{
        try (CarRepo Carrepo=new CarRepo ()){
//            personEnti.setSalary (personEnti.getSalary ()-(personEnti.getSalary ()*10/100));
            Carrepo.update (carEn);
            Carrepo.commit ();
        }
    }
    //    public void remove(Long id) throws Exception{
//        try (UserRepo personRepo=new UserRepo ()){
//            personRepo.delete(id);
//            personRepo.commit ();
//        }
//    }
    public List<CarEn> report() throws Exception{
        List<CarEn> Caren;
        try (CarRepo carRepo=new CarRepo ()){
            Caren=carRepo.select ();
        }
        return Caren;
    }

}