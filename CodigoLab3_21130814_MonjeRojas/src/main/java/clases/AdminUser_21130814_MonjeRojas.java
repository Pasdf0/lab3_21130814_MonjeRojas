package clases;

import java.util.ArrayList;

public class AdminUser_21130814_MonjeRojas extends User_21130814_MonjeRojas{
    public AdminUser_21130814_MonjeRojas(String name){
        this.permission_Id = 1;
        this.setName(name);
        this.chathis = new ArrayList<>();
    }
}
