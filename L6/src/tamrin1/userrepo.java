package tamrin1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class userrepo implements AutoCloseable{
    //    public class PersonRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public userrepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "system", "university");
        connection.setAutoCommit (false);
    }

    public void insert(UserEn personEnti) throws Exception{
        preparedStatement=connection.prepareStatement ("INSERT INTO users(id, email, education, username,password) VALUES (?,?,?,?,?)");
        preparedStatement.setLong (1,personEnti.getId());
        preparedStatement.setString (2,personEnti.getemail());
        preparedStatement.setString (3,personEnti.geteducation());
        preparedStatement.setString (4,personEnti.getUsername());
        preparedStatement.setString (5,personEnti.getPassword());
        preparedStatement.executeUpdate ();
    }

//    public void update (UserEn personEnti) throws Exception{
//        preparedStatement=connection.prepareStatement ("UPDATE users SET email =?, education=?,username=?,password=? WHERE id=? ");
//        preparedStatement.setString (1,personEnti.getemail ());
//        preparedStatement.setString (2,personEnti.geteducation ());
//        preparedStatement.setString (3,personEnti.getUsername());
//        preparedStatement.setString (4,personEnti.getPassword());
//        preparedStatement.setLong (5,personEnti.getId ());
//        preparedStatement.executeUpdate ();
//    }

//    public void delete(Long id) throws Exception{
//        preparedStatement=connection.prepareStatement ("DELETE FROM users WHERE id=?");
//        preparedStatement.setLong (1,id);
//        preparedStatement.executeUpdate ();
//    }

    public List<UserEn> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM users");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<UserEn> personEntiList=new ArrayList <> ();
        while (resultSet.next ()){
            UserEn personEnti=new UserEn (); // call by reference
            personEnti.setId (resultSet.getLong ("id"));
            personEnti.setemail (resultSet.getString ("email"));
            personEnti.seteducation (resultSet.getString ("education"));
            personEnti.setUsername (resultSet.getString ("username"));
            personEnti.setPassword (resultSet.getString ("password"));
            personEntiList.add (personEnti);
        }
        return personEntiList;
    }
    public void commit() throws Exception{
        connection.commit ();
    }
//    public void rollback() throws Exception{
//        connection.rollback ();
//    }
    public void close() throws Exception{
        preparedStatement.close ();
        connection.close ();
    }
}
