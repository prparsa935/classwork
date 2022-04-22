package TAMRIN1.model.Repo;



import TAMRIN1.model.entity.UserEn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements AutoCloseable{
    //    public class PersonRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserRepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "system", "university");
        connection.setAutoCommit (false);
    }

//    public void insert(UserEn personEnti) throws Exception{
//        preparedStatement=connection.prepareStatement ("INSERT INTO files.user(id,username,password) VALUES (?,?,?)");
//        preparedStatement.setLong (1,personEnti.getId());
//        preparedStatement.setString (2,personEnti.getUsername());
//        preparedStatement.setString (3,personEnti.getPassword());
//        preparedStatement.executeUpdate ();
//    }

    public void update (UserEn personEnti) throws Exception{
        preparedStatement=connection.prepareStatement ("UPDATE files.user SET username=?,password=?,RDV=?,Liability=? WHERE id=? ");
        preparedStatement.setString (1,personEnti.getUsername());
        preparedStatement.setString (2,personEnti.getPassword());
        preparedStatement.setDouble (3,personEnti.getRDV());
        preparedStatement.setDouble (4,personEnti.getLiability());
        preparedStatement.setLong (5,personEnti.getId ());
        preparedStatement.executeUpdate ();
    }

//    public void delete(Long id) throws Exception{
//        preparedStatement=connection.prepareStatement ("DELETE FROM files.user WHERE id=?");
//        preparedStatement.setLong (1,id);
//        preparedStatement.executeUpdate ();
//    }

    public List<UserEn> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM files.user");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<UserEn> personEntiList=new ArrayList <> ();
        while (resultSet.next ()){
            UserEn personEnti=new UserEn (); // call by reference
            personEnti.setId (resultSet.getLong ("id"));
            personEnti.setUsername (resultSet.getString ("username"));
            personEnti.setPassword (resultSet.getString ("password"));
            personEnti.setRDV (resultSet.getDouble ("RDV"));
            personEnti.setLiability (resultSet.getDouble ("Liability"));
            personEntiList.add (personEnti);
        }
        return personEntiList;
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
