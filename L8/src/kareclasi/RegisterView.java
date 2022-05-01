package kareclasi;

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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
