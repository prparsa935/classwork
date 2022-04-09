package kareclasi;

public class calcFactory {
    public calculate calculateFactory(String channel) {
        if(channel.equals("+")){
            return new calcPlus();
        }
        else{
            return new calcMinus();
        }
    }
}
