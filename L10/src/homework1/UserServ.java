package homework1;
import java.rmi.Remote;
import java.util.List;

public interface UserServ extends Remote {
    void save(UserEn person)throws Exception;
    List<UserEn> report() throws Exception;
    void Update(UserEn Us) throws Exception;
}