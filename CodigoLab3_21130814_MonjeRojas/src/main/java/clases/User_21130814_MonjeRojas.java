package clases;

import java.util.ArrayList;
import java.util.Date;

public class User_21130814_MonjeRojas{
    protected Integer permission_Id;
    protected String name;
    protected ArrayList<String> chathis;

    public User_21130814_MonjeRojas(){
        this.name = "no_user";
        this.chathis = new ArrayList<> ();
    }

    //Getters
    public Integer getPermission_Id() {return permission_Id;}
    public String getName() {return name;}
    public ArrayList<String> getChathis() {return chathis;}

    //Setters
    public void setName(String name) {
        if (!name.equals("")){
            this.name = name;
        }
    }

    public void deleteHistory(){
        this.chathis = new ArrayList<>();
    }

    public void storeHistory(String name, String user, Date date, Chatbot_21130814_MonjeRojas Cb, Flow_21130814_MonjeRojas Fw, String msg){
        String FormattedChat = name + " - " + user + "\n" + date + "\n" + Cb.getName() + "\n" + Fw.getMsg() + "\n";
        String ChatTemp = "";
        for (Option_21130814_MonjeRojas Op : Fw.getOptions()){
            ChatTemp = ChatTemp + Op.getMsg() + "\n";
        }
        FormattedChat = FormattedChat + ChatTemp + "\nRespuesta: " + msg;
        this.chathis.add(FormattedChat);
    }
}
