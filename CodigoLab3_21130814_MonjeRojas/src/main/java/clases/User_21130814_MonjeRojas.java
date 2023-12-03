package clases;

import java.util.ArrayList;

public class User_21130814_MonjeRojas{
    private String name;
    private ArrayList<String> chathis;

    public void User(){
        this.name = "no_user";
        this.chathis = new ArrayList<String> ();
    }
    //Sobrecarga
    public void User(String name){
        if (!name.equals("")) {
            this.setName(name);
        }
        this.chathis = new ArrayList<String> ();
    }

    //Getters
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
