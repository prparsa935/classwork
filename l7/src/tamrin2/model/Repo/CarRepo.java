package tamrin2.model.Repo;

import tamrin2.model.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarRepo implements AutoCloseable{
    //    public class PersonRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CarRepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "system", "University");
        connection.setAutoCommit (false);
    }

//    public void insert(UserEn personEnti) throws Exception{
//        preparedStatement=connection.prepareStatement ("INSERT INTO files.user(id,username,password) VALUES (?,?,?)");
//        preparedStatement.setLong (1,personEnti.getId());
//        preparedStatement.setString (2,personEnti.getUsername());
//        preparedStatement.setString (3,personEnti.getPassword());
//        preparedStatement.executeUpdate ();
//    }

    public void update (CarEn CarEn) throws Exception{
        preparedStatement=connection.prepareStatement ("UPDATE Car SET Name=?,Price=?,Bought=? WHERE id=? ");
        preparedStatement.setString (1,CarEn.getName());
        preparedStatement.setDouble (2,CarEn.getPrice());
        preparedStatement.setBoolean (3,CarEn.isBought());
        preparedStatement.setLong (4,CarEn.getId());
        preparedStatement.executeUpdate ();
    }

//    public void delete(Long id) throws Exception{
//        preparedStatement=connection.prepareStatement ("DELETE FROM files.user WHERE id=?");
//        preparedStatement.setLong (1,id);
//        preparedStatement.executeUpdate ();
//    }

    public List<CarEn> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM Car");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<CarEn> CarentityList=new ArrayList <> ();
        while (resultSet.next ()){
            CarEn personEnti=new CarEn (); // call by reference
            personEnti.setId (resultSet.getLong ("id"));
            personEnti.setName (resultSet.getString ("Name"));
            personEnti.setPrice (resultSet.getDouble ("Price"));
            personEnti.setBought (resultSet.getBoolean ("Bought"));
            CarentityList.add (personEnti);
        }
        return CarentityList;
    }
    public void commit() throws Exception{
        connection.commit ();
    }
    public void rollback() throws Exception{
        connection.rollback ();
    }
    public void close() throws Exception{
        preparedStatement.close ();
        connection.close ();
    }
}
