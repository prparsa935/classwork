package com.company;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection Conn;
        PreparedStatement preparedStatement;
        Conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "university");
        preparedStatement=Conn.prepareStatement("create TABLE person(id double ,name VARCHAR(45) ,password VARCHAR(45) ,balance float )");
        preparedStatement.executeUpdate();


	// write your code here
    }
}
