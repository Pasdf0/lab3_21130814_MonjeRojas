package main;

import clases.*;
import menu.Menu_21130814_MonjeRojas;



public class Main {
    public static void main(String[] args) {
        Menu_21130814_MonjeRojas menu = new Menu_21130814_MonjeRojas();
        AdminUser_21130814_MonjeRojas UsrAd = new AdminUser_21130814_MonjeRojas("User0");
        UserSystem_21130814_MonjeRojas test = new UserSystem_21130814_MonjeRojas(UsrAd);
        test.createSystem();
        test.ShowSystem();
    }
}
