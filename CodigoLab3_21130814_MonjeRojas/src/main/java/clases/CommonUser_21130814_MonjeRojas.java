package clases;

import java.util.ArrayList;

public class CommonUser_21130814_MonjeRojas extends User_21130814_MonjeRojas{
    public CommonUser_21130814_MonjeRojas(String name){
        this.permission_Id = 0;
        this.setName(name);
        this.chathis = new ArrayList<String>();
    }
}
