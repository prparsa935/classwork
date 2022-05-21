package classwork;

import classwork.BankEnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public BankRepo()throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "university");
    }
    public void insert(BankEnt person)throws Exception
    {
        preparedStatement = connection.prepareStatement("insert into person (id,name,password,balance) values (?,?,?,?)");
        preparedStatement.setInt(1,person.getId());
        preparedStatement.setString(2,person.getName());
        preparedStatement.setString(3,person.getPassword());
        preparedStatement.setFloat(4,person.getBalance());
        preparedStatement.executeUpdate();
    }
    public void Deposit(BankEnt source,BankEnt Destination)throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE SET person name=?,password=?,balance=? where id=?");
        preparedStatement.setString(1,source.getName());
        preparedStatement.setString(2,source.getPassword());
        preparedStatement.setFloat(3,source.getBalance());
        preparedStatement.setInt(4,source.getId());
        preparedStatement.executeUpdate();
        preparedStatement = connection.prepareStatement("UPDATE SET person name=?,password=?,balance=? where id=?");
        preparedStatement.setString(1,Destination.getName());
        preparedStatement.setString(2,Destination.getPassword());
        preparedStatement.setFloat(3,Destination.getBalance());
        preparedStatement.setInt(4,Destination.getId());
        preparedStatement.executeUpdate();
    }
    public List<BankEnt> select()throws Exception
    {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<BankEnt> personList = new ArrayList<>();
        while (resultSet.next())
        {
            BankEnt person = new BankEnt();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setPassword(resultSet.getString("password"));
            person.setBalance(resultSet.getFloat("balance"));
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
