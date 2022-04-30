package tamrin2;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JDialog {
    private JPanel panel1;
    private JTextField Usernamef;
    private JPasswordField Passwordf;
    private JButton LOGINButton;

    public LoginView() {
        setTitle("Login");
        setContentPane(panel1);
        setModal(true);
//        setMinimumSize(new Dimension(450,250));
//        setPreferredSize(new Dimension(450,250));
//
//        setMaximumSize(getPreferredSize());
        setResizable(false);
        setSize(450,250);
//        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
    void AddListenerLB(ActionListener AL){
        LOGINButton.addActionListener(AL);

    }

    String GetUsername(){
        return Usernamef.getText();


    }
    String GetPassword(){
        return Passwordf.getText();


    }

    public static void main(String[] args) {
        LoginView b=new LoginView();
        b.setVisible(true);
    }


}

