package homework2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public CustomerRepo()throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "university");
    }
    public void insert(CustomerEn person)throws Exception
    {
        preparedStatement = connection.prepareStatement("insert into person (id,name,password,balance,username) values (?,?,?,?,?)");
        preparedStatement.setInt(1,person.getId());
        preparedStatement.setString(2,person.getName());
        preparedStatement.setString(3,person.getPassword());
        preparedStatement.setFloat(4,person.getBalance());
        preparedStatement.setString(5,person.getUsername());
        preparedStatement.executeUpdate();
    }
    public void Update(CustomerEn Cs )throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE SET person name=?,password=?,balance=?,username=? where id=?");
        preparedStatement.setString(1,Cs.getName());
        preparedStatement.setString(2,Cs.getPassword());
        preparedStatement.setFloat(3,Cs.getBalance());
        preparedStatement.setString(4,Cs.getUsername());
        preparedStatement.setInt(5,Cs.getId());
        preparedStatement.executeUpdate();
    }
    public List<CustomerEn> select()throws Exception
    {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CustomerEn> personList = new ArrayList<>();
        while (resultSet.next())
        {
            CustomerEn person = new CustomerEn();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setPassword(resultSet.getString("password"));
            person.setBalance(resultSet.getFloat("balance"));
            person.setUsername(resultSet.getString("username"));
            personList.add(person);
        }
        return personList;
    }
    public void close()throws Exception
    {
        preparedStatement.close();
        connection.close();
    }
}