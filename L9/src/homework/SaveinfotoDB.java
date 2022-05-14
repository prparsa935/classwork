import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SaveinfotoDB implements Runnable {
    public static JLabel plable;
    public static JLabel nlable;
    public static JLabel uslable;
    public static JLabel elable;

    public static JTextField usertext1;
    public static JTextField usertext2;
    public static JTextField usertext3;
    public static JPasswordField passwordtext;


    public static JButton button;
    public static JPanel panel;
    public static JFrame frame;



    @Override
    public void run() {


            panel =new JPanel();
            frame = new JFrame();
            frame.setSize(400,250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(panel);
            panel.setLayout(null);
            nlable =new JLabel("Name:");
            nlable.setBounds(10,20,80,25);
            panel.add(nlable);
            usertext1 = new JTextField(20);
            usertext1.setBounds(100,20,165,25);
            panel.add(usertext1);

            uslable =new JLabel("Family:");
            uslable.setBounds(10,50,80,25);
            panel.add(uslable);
            usertext2 = new JTextField(20);
            usertext2.setBounds(100,50,165,25);
            panel.add(usertext2);

            plable =new JLabel("Age:");
            plable.setBounds(10,80,80,25);
            panel.add(plable);
            usertext3 =new JTextField();
            usertext3.setBounds(100,80,165,25);
            panel.add(usertext3);

            button = new JButton("Signup");
            button.setBounds(140,115,80,25);
            button.setBackground(Color.GREEN);
            button.setForeground(Color.BLACK);
            panel.add(button);
            button.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Connection connection = null;
                    try {
                        connection = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "amir", "myjava123");
                        String SQL="INSERT INTO hw1l10(name ,family ,age) VALUES ('"+usertext1.getText()+"','"+usertext2.getText()+"','"+usertext3.getText()+"')";
                        Statement st = connection.createStatement();
                        ResultSet rs=st.executeQuery(SQL);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            });

            frame.setVisible(true);

        }

    }

