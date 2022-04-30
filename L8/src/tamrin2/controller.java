package tamrin2;

import tamrin2.model.Entity.UserEn;
import tamrin2.model.service.UserServ;

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
        Lview.setVisible(true);
        RegisterView Rview=new RegisterView();
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
                            Rview.AddListenerRB(new RRAcctionlistener(UserEn));
                            Rview.SetName(UserEn.getName()).SetEmail(UserEn.getEmail()).SetUsername(UserEn.getUsername()).SetPassword(UserEn.getPassword());
                            Rview.setVisible(true);
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
    class RRAcctionlistener implements ActionListener{
        UserEn UserEn;
        public RRAcctionlistener(UserEn UserEn){
            this.UserEn=UserEn;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            UserEn newuser=new UserEn().setId(this.UserEn.getId()).setName(Rview.GetName()).setUsername(Rview.GetUsername()).setPassword(Rview.GetPassword()).setEmail(Rview.GetEmail());
            try {
                UserServ.getInstance().edit(newuser);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
    }

}
