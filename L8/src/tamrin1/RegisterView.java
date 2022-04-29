package tamrin1;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RegisterView extends JDialog{

    private JPanel Main;
    private JPanel leftside;
    private JTextField Namef;
    private JTextField Emailf;
    private JPasswordField Passwordf;
    private JTextField Addressf;
    private JPanel RightP;
    private JButton registerButton;
    private JTextField textField1;

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
        return Addressf.getText();
    }
    String GetPassword(){
        return Passwordf.getText();
    }
    String GetEmail(){
        return Emailf.getText();
    }

    public static void main(String[] args) {
        RegisterView r=new RegisterView();
        r.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
