package tamrin3;


import tamrin3.StudentEn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements AutoCloseable{
    //    public class PersonRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public StudentRepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "system", "university");
        connection.setAutoCommit (false);
    }

    public void insert(StudentEn personEnti) throws Exception{
        preparedStatement=connection.prepareStatement ("INSERT INTO Student(id, code, name, year,average) VALUES (?,?,?,?,?)");
        preparedStatement.setLong (1,personEnti.getId());
        preparedStatement.setLong (2,personEnti.getCode());
        preparedStatement.setString (3,personEnti.getName());
        preparedStatement.setInt (4,personEnti.getYear());
        preparedStatement.setFloat (5,personEnti.getAverage());
        preparedStatement.executeUpdate ();
    }

    public void update (StudentEn personEnti) throws Exception{
        preparedStatement=connection.prepareStatement ("UPDATE Student SET code =?, name=?,year=?,average=? WHERE id=? ");
        preparedStatement.setLong (1,personEnti.getCode ());
        preparedStatement.setString (2,personEnti.getName ());
        preparedStatement.setInt (3,personEnti.getYear());
        preparedStatement.setFloat (4,personEnti.getAverage());
        preparedStatement.setLong (4,personEnti.getId ());
        preparedStatement.executeUpdate ();
    }

    public void delete(Long id) throws Exception{
        preparedStatement=connection.prepareStatement ("DELETE FROM Student WHERE id=?");
        preparedStatement.setLong (1,id);
        preparedStatement.executeUpdate ();
    }

    public List<StudentEn> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM Student");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<StudentEn> personEntiList=new ArrayList <> ();
        while (resultSet.next ()){
            StudentEn personEnti=new StudentEn (); // call by reference
            personEnti.setId (resultSet.getLong ("id"));
            personEnti.setCode (resultSet.getLong ("code"));
            personEnti.setName (resultSet.getString ("name"));
            personEnti.setYear (resultSet.getInt ("year"));
            personEnti.setAverage (resultSet.getFloat ("average"));
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
