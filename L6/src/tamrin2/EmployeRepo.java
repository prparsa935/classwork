package tamrin2;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeRepo implements AutoCloseable{
    //    public class PersonRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public EmployeRepo() throws Exception{
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "system", "university");
        connection.setAutoCommit (false);
    }

    public void insert(EmployeEn EmployeEn) throws Exception{
        preparedStatement=connection.prepareStatement ("INSERT INTO Employee(id, code, name, nationalـCode,fathers_name,position,salary,workـexperience) VALUES (?,?,?,?,?,?,?,?)");
        preparedStatement.setLong (1,EmployeEn.getId());
        preparedStatement.setString (2,EmployeEn.getCode());
        preparedStatement.setString (3,EmployeEn.getName());
        preparedStatement.setString (4,EmployeEn.getNationalـCode());
        preparedStatement.setString (5,EmployeEn.getFathers_name());
        preparedStatement.setString (6,EmployeEn.getPosition());
        preparedStatement.setString (7,EmployeEn.getSalary());
        preparedStatement.setString (8,EmployeEn.getWorkـexperience());
        preparedStatement.executeUpdate ();
    }

//    public void update (UserEn EmployeEn) throws Exception{
//        preparedStatement=connection.prepareStatement ("UPDATE users SET email =?, education=?,username=?,password=? WHERE id=? ");
//        preparedStatement.setString (1,EmployeEn.getemail ());
//        preparedStatement.setString (2,EmployeEn.geteducation ());
//        preparedStatement.setString (3,EmployeEn.getUsername());
//        preparedStatement.setString (4,EmployeEn.getPassword());
//        preparedStatement.setLong (5,EmployeEn.getId ());
//        preparedStatement.executeUpdate ();
//    }

    public void delete(String code) throws Exception{
        preparedStatement=connection.prepareStatement ("DELETE FROM Employee WHERE code=?");
        preparedStatement.setString (1,code);
        preparedStatement.executeUpdate ();
    }

    public List<EmployeEn> select() throws Exception{
        preparedStatement=connection.prepareStatement ("SELECT * FROM Employee");
        ResultSet resultSet=preparedStatement.executeQuery ();
        List<EmployeEn> EmployeEnList=new ArrayList <> ();
        while (resultSet.next ()){
            EmployeEn EmployeEn=new EmployeEn (); // call by reference
            EmployeEn.setId (resultSet.getLong ("id"));
            EmployeEn.setCode (resultSet.getString ("code"));
            EmployeEn.setName (resultSet.getString ("name"));
            EmployeEn.setNationalـCode (resultSet.getString ("nationalـCode"));
            EmployeEn.setFathers_name (resultSet.getString ("fathers_name"));
            EmployeEn.setPosition (resultSet.getString ("position"));
            EmployeEn.setSalary (resultSet.getString ("salary"));
            EmployeEn.setWorkـexperience (resultSet.getString ("workـexperience"));
            EmployeEnList.add (EmployeEn);
        }
        return EmployeEnList;
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
