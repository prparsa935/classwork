import java.sql.*;

class emtehani{
    public static void main(String args[]){
        try{

//step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("ss");
//step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","system","yecgaa48255");


//step3 create the statement object
            PreparedStatement stmt=con.prepareStatement("create table if not exists user('name' varchar(30))");
            stmt.executeQuery();
            System.out.println("ok");
            stmt=con.prepareStatement("select * from user");

//step4 execute query
            ResultSet rs=stmt.executeQuery();
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

//step5 close the connection object
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}