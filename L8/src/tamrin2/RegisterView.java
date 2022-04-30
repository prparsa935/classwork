package tamrin2;

import tamrin2.model.Entity.UserEn;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegisterView extends JDialog{

    private JPanel Main;
    private JPanel leftside;
    private JTextField Namef;
    private JTextField Emailf;
    private JPasswordField Passwordf;
    private JTextField Usernamef;
    private JPanel RightP;
    private JButton registerButton;

    public RegisterView(){
        setContentPane(Main);
        setModal(true);
        setSize(500,300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    void AddListenerRB(ActionListener Al){
        registerButton.addActionListener(Al);

    }
    String GetName(){
        return Namef.getText();
    }
    String GetUsername(){
        return Usernamef.getText();
    }
    String GetPassword(){
        return Passwordf.getText();
    }
    String GetEmail(){
        return Emailf.getText();
    }
    RegisterView SetName(String Name){Namef.setText(Name);
        return this;}
    RegisterView SetUsername(String Username){Usernamef.setText(Username);
        return this;}
    RegisterView SetPassword(String Password){Passwordf.setText(Password);
        return this;}
    RegisterView SetEmail(String Email){Emailf.setText(Email);
        return this;}

    public static void main(String[] args) {
        RegisterView r=new RegisterView();
        r.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
