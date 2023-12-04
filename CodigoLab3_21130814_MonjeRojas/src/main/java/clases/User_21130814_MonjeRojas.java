package clases;

import java.util.ArrayList;

public class User_21130814_MonjeRojas{
    protected Integer permission_Id;
    protected String name;
    protected ArrayList<String> chathis;

    public void User(){
        this.name = "no_user";
        this.chathis = new ArrayList<String> ();
    }

    //Getters
    public Integer getPermission_Id() {return permission_Id;}
    public String getName() {return name;}
    public ArrayList<String> getChathis() {return chathis;}

    //Setters
    public void setName(String name) {
        if (!name.equals("")){
            name.toLowerCase();
            this.name = name;
        }
    }
}
