import javax.swing.*;
import java.sql.*;

public class Showinfo implements Runnable{


    @Override
    public void run() {
        JPanel panel =new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);

        JLabel label=new JLabel();
        label.setBounds(10,20,400,50);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "amir", "myjava123");
            String SQL="select * from hw1l10 ";
            Statement st = connection.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs.next()){
                label.setText("name:  "+rs.getString(1)+"   Family: "+rs.getString(2)+"   Age: "+rs.getString(3) );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        panel.add(label);
        frame.setVisible(true);

    }
}

