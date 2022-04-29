package tamrin1;

import tamrin1.model.service.UserServ;
import tamrin1.model.Entity.UserEn;

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
    private RegisterView Rview=new RegisterView();
    public controller(){
        Rview.AddListenerRB(new RRAcctionlistener());
        Rview.setVisible(true);
    }

    class RRAcctionlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e)  {
            UserEn newuser=new UserEn().setId(users.size()).setName(Rview.GetName()).setAddress(Rview.GetUsername()).setEducation(Rview.GetPassword()).setEmail(Rview.GetEmail());
            try {
                UserServ.getInstance().save(newuser);
                System.out.println("done");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
