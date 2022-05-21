package homework1;

import homework1.UserEn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private Connection connection;
    private PreparedStatement preparedStatement;
    public UserRepo()throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "university");
    }
    public void insert(UserEn person)throws Exception
    {
        preparedStatement = connection.prepareStatement("insert into person (id,name,password,username) values (?,?,?,?)");
        preparedStatement.setInt(1,person.getId());
        preparedStatement.setString(2,person.getName());
        preparedStatement.setString(3,person.getPassword());
        preparedStatement.setString(4,person.getUsername());
        preparedStatement.executeUpdate();
    }
    public void Update(UserEn Us)throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE SET person name=?,password=?,username=? where id=?");
        preparedStatement.setString(1,Us.getName());
        preparedStatement.setString(2,Us.getPassword());
        preparedStatement.setString(3,Us.getUsername());
        preparedStatement.setInt(4,Us.getId());
        preparedStatement.executeUpdate();
    }
    public List<UserEn> select()throws Exception
    {
        preparedStatement = connection.prepareStatement("select * from person");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<UserEn> personList = new ArrayList<>();
        while (resultSet.next())
        {
            UserEn person = new UserEn();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setPassword(resultSet.getString("password"));
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