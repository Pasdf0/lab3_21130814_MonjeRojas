package menu;

import clases.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu_21130814_MonjeRojas {
    private MenuSystem_21130814_MonjeRojas myMenu;
    private ArrayList<System_21130814_MonjeRojas> systems;


    public Menu_21130814_MonjeRojas(){
        this.systems = new ArrayList<>();
        MenuSystem_21130814_MonjeRojas sys1 = MenuSystem_21130814_MonjeRojas.getMenuSystem();
        System_21130814_MonjeRojas sys2 = DemoSystem_21130814_MonjeRojas.getSystemDemo();
        this.myMenu = sys1;
        this.addSystem(sys2);
    }

    public void run(){
        while(true){
            if (this.myMenu.getCb_code() == 0){
                String respuesta = this.ask();
                this.myMenu.systemTalk(respuesta);
            }
            else if (this.myMenu.getCb_code() == 1){
                String respuesta = this.ask();
                this.myMenu.systemLogin(respuesta);
                if (!this.myMenu.getUser().getName().equalsIgnoreCase("no_user")){
                    this.myMenu.systemTalk("talk");
                }
                else {
                    this.myMenu.resetSystem();
                    System.out.println("\n-No se ha podido ingresar-");
                }
            }
            else if(this.myMenu.getCb_code() == 2){
                String respuesta = this.ask();
                if (this.myMenu.findUser(respuesta) == null) {
                    if (this.myMenu.findCb(this.myMenu.getCb_code()).getFw_code() == 1) {
                        this.myMenu.systemAddCommonUser(respuesta);
                        System.out.println("\n-Se ha registrado correctamente-");
                    } else {
                        this.myMenu.systemAddAdminUser(respuesta);
                        System.out.println("\n-Se ha registrado correctamente-");
                    }
                }
                else {
                    System.out.println("\n-Este usuario ya se encuentra en el sistema-");
                }
                this.myMenu.systemTalk("talk");
            }
            //else if (this.myMenu.getCb_code() == 3){

            //}
            else{
                break;
            }
        }
    }

    public String ask(){
        System.out.print("\n");
        this.myMenu.systemState();
        Scanner sc = new Scanner(System.in);
        System.out.print("Respuesta: ");
        return sc.next();
    }

    public void addSystem(System_21130814_MonjeRojas sys){this.systems.add(sys);}


    /*
    public void Inicial{
        System.out.println("########## Menu Interactivo ##########");
        System.out.println("######################################");
        System.out.println("#####     Sistema de Chatbots    #####");
        System.out.println("# ¿Que desea hacer?                  #");
        System.out.println("# 1. Ingresar                        #");
        System.out.println("# 2. Registrarse                     #");
        System.out.println()
    }*/

}
