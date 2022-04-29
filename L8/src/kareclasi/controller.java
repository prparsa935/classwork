package kareclasi;

import kareclasi.model.Entity.UserEn;
import kareclasi.model.service.UserServ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class controller {
    private List<UserEn> users;
    {
        try {
            users = UserServ.getInstance().report();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private LoginView Lview=new LoginView();
    private RegisterView Rview=new RegisterView();
    public controller(){
        Lview.AddListenerLB(new LlAcctionlistener());
        Lview.AddListenerRB(new LRAcctionlistener());
        Lview.setVisible(true);
    }
    class LlAcctionlistener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String username=Lview.GetUsername();
                String Password=Lview.GetPassword();
                for(UserEn UserEn:users){
                    if(UserEn.getUsername().equals(username)){
                        if(UserEn.getPassword().equals(Password)){
                            System.out.println("logged in");
                        }
                        else {
                            System.out.println("username or password is wrong");
                        }
                    }
                }
            }
            catch (Exception Ex){
            }
        }

    }
    class LRAcctionlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Lview.setVisible(false);
            Rview.setVisible(true);
            Rview.AddListenerRB(new RRAcctionlistener());
        }
}
    class RRAcctionlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UserEn newuser=new UserEn().setId(users.size()).setName(Rview.GetName()).setUsername(Rview.GetUsername()).setPassword(Rview.GetPassword()).setEmail(Rview.GetEmail());
            for(UserEn UserEn:users){
                if(UserEn.getUsername().equals(newuser.getUsername())){
                    System.out.println("enter another username");
                }
                else{
                    try {
                        UserServ.getInstance().save(newuser);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
