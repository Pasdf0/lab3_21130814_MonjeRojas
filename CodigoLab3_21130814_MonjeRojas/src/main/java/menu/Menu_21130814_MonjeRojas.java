package menu;

import clases.*;

import java.util.ArrayList;
import java.util.Scanner;

import static clases.UserSystem_21130814_MonjeRojas.*;


public class Menu_21130814_MonjeRojas {
    private MenuSystem_21130814_MonjeRojas myMenu;
    private DemoSystem_21130814_MonjeRojas myDemo;
    private System_21130814_MonjeRojas currentSystem;
    private ArrayList<UserSystem_21130814_MonjeRojas> systems;


    public Menu_21130814_MonjeRojas(){
        this.myMenu = MenuSystem_21130814_MonjeRojas.getMenuSystem();
        this.myDemo = DemoSystem_21130814_MonjeRojas.getSystemDemo();
        this.systems = new ArrayList<>();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        Chatbot_21130814_MonjeRojas CurrentCb = null;
        while(true){
            if (this.myMenu.getCb_code() == 0){
                String respuesta = this.askMenu();
                this.myMenu.systemTalk(respuesta);
            }
            else if (this.myMenu.getCb_code() == 1){
                String respuesta = this.askMenu();
                this.myMenu.systemLogin(respuesta);
                this.myDemo.systemLogin(respuesta);
                if (!this.myMenu.getUser().getName().equalsIgnoreCase("no_user")){
                    this.myMenu.systemTalk("talk");
                }
                else {
                    this.myMenu.resetSystem();
                    System.out.println("\n-No se ha podido ingresar-");
                }
            }
            else if(this.myMenu.getCb_code() == 2){
                this.myMenu.findCb(0).resetFw_code();
                String respuesta = this.askMenu();
                if (this.myMenu.findUser(respuesta) == null) {
                    if (this.myMenu.findCb(this.myMenu.getCb_code()).getFw_code() == 1) {
                        this.myMenu.systemAddCommonUser(respuesta);
                        this.myDemo.systemAddCommonUser(respuesta);
                        System.out.println("\n-Se ha registrado correctamente-");
                    } else {
                        this.myMenu.systemAddAdminUser(respuesta);
                        this.myDemo.systemAddAdminUser(respuesta);
                        System.out.println("\n-Se ha registrado correctamente-");
                    }
                }
                else {
                    System.out.println("\n-Este usuario ya se encuentra en el sistema-");
                }
                this.myMenu.systemTalk("talk");
            }
            else if (this.myMenu.getCb_code() == 3) {
                Integer check = this.myMenu.findCb(3).getFw_code();
                if (check == 1){
                    if (this.myMenu.getUser().getPermission_Id() == 0) {
                        this.myMenu.setCb_code(4);
                    } else {
                        String respuesta = this.askMenu();
                        this.myMenu.systemTalk(respuesta);
                    }
                }
                else if (check == 2){
                    Integer select = this.ChooseSystemCommon();
                    if (select == 0){
                        this.myMenu.setCb_code(6);
                    }
                    this.myMenu.findCb(3).resetFw_code();
                }
                else {
                    Integer select = this.ChooseSystemAdmin();
                    if (select == 1){
                        UserSystem_21130814_MonjeRojas newSys = createSystem((AdminUser_21130814_MonjeRojas) this.myMenu.getUser());
                        this.addSystem(newSys);
                    }
                    else {
                        this.myMenu.setCb_code(5);
                        this.ShowInstructions();
                    }
                    this.myMenu.findCb(3).resetFw_code();
                }
            }
            else if (this.myMenu.getCb_code() == 4){
                Integer check = this.myMenu.findCb(4).getFw_code();
                if (check == 1){
                    String respuesta = this.askMenu();
                    this.myMenu.systemTalk(respuesta);
                }
                else if (check == 2){
                    System.out.print("\n");
                    while(true) {
                        String respuesta = this.askDemo();
                        if (!respuesta.isEmpty()) {
                            this.myDemo.systemTalk(respuesta);
                        }
                        else{
                            break;
                        }
                    }
                    this.myMenu.findCb(4).resetFw_code();
                    System.out.println("-Se ha interactuado con el sistema correctamente-\n");
                }
                else if (check == 3){
                    String name = this.myMenu.getUser().getName();
                    System.out.println("\n");
                    this.myDemo.systemSynthesis(name);
                    System.out.println("-Presione Enter para continuar-");
                    String respuesta = sc.nextLine();
                }
                else if (check == 4){
                    this.myDemo.getUser().deleteHistory();
                    System.out.println("\n");
                    System.out.print("Ingrese un numero de Interacciones para simular: ");
                    Integer maxInt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese una seed: ");
                    Integer seed = sc.nextInt();
                    sc.nextLine();
                    this.myDemo.systemSimulate(maxInt,seed);
                    System.out.println("\n-Simulacion Realizada con Exito-");

                }
                else if (check == 5){
                    this.myDemo.ShowSystem();
                }
                if (check != 1) {
                    this.myMenu.findCb(4).resetFw_code();
                }
            }
            else if (this.myMenu.getCb_code() == 5){
                Integer check = this.myMenu.findCb(5).getFw_code();
                if (check == 1){
                    String respuesta = this.askMenu();
                    this.myMenu.systemTalk(respuesta);
                }
                else if (check == 2){
                    Chatbot_21130814_MonjeRojas Cb = createChatbot();
                    boolean verificador = true;
                    for (Chatbot_21130814_MonjeRojas Chatbot : this.currentSystem.getChatbots()){
                        if (Chatbot.getId().equals(Cb.getId())) {
                            verificador = false;
                            break;
                        }
                    }
                    if (verificador){
                        System.out.println("-Chatbot Añadido Correctamente-");
                    }
                    else{
                        System.out.println("La Id de su Chatbot ya se encuentra en el System");
                    }
                    this.currentSystem.systemAddChatbot(Cb);
                }
                else if (check == 3){
                    System.out.print("\n");
                    CurrentCb = this.currentSystem.ChooseChatbot();
                    if (CurrentCb != null) {
                        this.myMenu.setCb_code(7);
                    }
                }
                else if (check == 4){
                    System.out.print("\n");
                    Chatbot_21130814_MonjeRojas Cb = this.currentSystem.ChooseChatbot();
                    if (Cb != null) {
                        Cb.ShowChatbot();
                    }
                }
                else if (check == 5){
                    System.out.print("\nIngrese la nueva id inicial: ");
                    Integer newId = sc.nextInt();
                    this.currentSystem.setCb_code(newId);
                }
                if (check != 1) {
                    this.myMenu.findCb(5).resetFw_code();
                }
            }
            else if (this.myMenu.getCb_code() == 6){
                Integer check = this.myMenu.findCb(6).getFw_code();
                if (check == 1){
                    String respuesta = this.askMenu();
                    this.myMenu.systemTalk(respuesta);
                }
                else if (check == 2){
                    System.out.print("\n");
                    while (true) {
                        String respuesta = this.askCurrent();
                        if (!respuesta.isEmpty()) {
                            this.currentSystem.systemTalk(respuesta);
                        }
                        else{
                            break;
                        }
                    }
                    this.currentSystem.findCb(6).resetFw_code();
                    System.out.println("-Se ha interactuado con el sistema correctamente-\n");
                }
                else if (check == 3){
                    String name = this.myMenu.getUser().getName();
                    System.out.println("\n");
                    this.currentSystem.systemSynthesis(name);
                    System.out.println("-Presione Enter para continuar-");
                    String respuesta = sc.nextLine();
                }
                else if (check == 4){
                    this.currentSystem.getUser().deleteHistory();
                    System.out.println("\n");
                    System.out.print("Ingrese un numero de Interacciones para simular: ");
                    Integer maxInt = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese una seed: ");
                    Integer seed = sc.nextInt();
                    sc.nextLine();
                    this.currentSystem.systemSimulate(maxInt,seed);
                    System.out.println("\n-Simulacion Realizada con Exito-");
                }
                else if (check == 5){
                    this.currentSystem.ShowSystem();
                }
                if (check != 1 && check != 2) {
                    this.myMenu.findCb(6).resetFw_code();
                }
            }
            else if (this.myMenu.getCb_code() == 7){
                Integer check = this.currentSystem.findCb(7).getFw_code();
                System.out.print("\n");
                System.out.print("\n");
                if (check == 1){
                    String respuesta = this.askMenu();
                    this.myMenu.systemTalk(respuesta);
                }
                else if (check == 2){
                    Flow_21130814_MonjeRojas Fw = createFlow();
                    CurrentCb.chatbotAddFlow(Fw);
                }
                else if (check == 3){
                    Flow_21130814_MonjeRojas Fw = CurrentCb.ChooseFlow();
                    if (Fw != null) {
                        CurrentCb.chatbotAddFlow(Fw);
                    }
                }
                if (check != 1){
                    this.myMenu.findCb(7).resetFw_code();
                }
            }
            else{
                break;
            }
        }
    }

    public String askMenu(){
        System.out.print("\n");
        this.myMenu.systemState();
        Scanner sc = new Scanner(System.in);
        System.out.print("Respuesta: ");
        return sc.nextLine().trim();
    }

    public String askDemo(){
        System.out.print("\n");
        this.myDemo.systemState();
        Scanner sc = new Scanner(System.in);
        System.out.print("Respuesta: ");
        return sc.nextLine().trim();
    }

    public String askCurrent(){
        System.out.print("\n");
        this.currentSystem.systemState();
        Scanner sc = new Scanner(System.in);
        System.out.print("Respuesta: ");
        return sc.nextLine().trim();
    }

    public void ShowInstructions(){
        System.out.println("\n\n############### Creando Sistema de Chatbots ###############");
        System.out.println("# Instrucciones:                                          #");
        System.out.println("# -NO SE CONTEMPLAN ERRORES DE INGRESO AL CREAR ELEMENTOS #");
        System.out.println("# -Se pueden dejar elementos como keywords, los option    #");
        System.out.println("#  en un flow o los flows en un chatbot vacios.           #");
        System.out.println("# -Se pueden responder a las preguntas (¿?) ingresando    #");
        System.out.println("#  cualquier cosa, detecta inputs vacios para detener el  #");
        System.out.println("#  proceso.                                               #");
        System.out.println("# -No es posible modificar el System Demo.                #");
        System.out.println("# -Por favor seguir instrucciones, gracias.               #");
        System.out.println("###########################################################");
    }

    public Integer ChooseSystemCommon(){
        System.out.println("\n##### Con cual System desea Interactuar #####");
        System.out.println("-Para seleccionar ingresar un número-");
        String username = this.myMenu.getUser().getName();
        ArrayList<System_21130814_MonjeRojas> systemList = new ArrayList<>();
        systemList.add(this.myDemo);
        for (UserSystem_21130814_MonjeRojas sys : this.systems){
            if (sys.getOwner().getName().equalsIgnoreCase(username) && !sys.getChatbots().isEmpty()){
                systemList.add(sys);
            }
        }
        Scanner sc = new Scanner(System.in);
        int i = 1;
        for (System_21130814_MonjeRojas sys : systemList){
            System.out.println(i + ") " + sys.getName());
            i++;
        }
        System.out.print("\nRespuesta: ");
        int respuesta = sc.nextInt();
        sc.nextLine();
        this.currentSystem = systemList.get(respuesta - 1);
        return 0;
    }

    public Integer ChooseSystemAdmin(){
        System.out.println("\n##### Cual System desea Modificar #####");
        System.out.println("-Para seleccionar ingresar un número-");
        String username = this.myMenu.getUser().getName();
        ArrayList<System_21130814_MonjeRojas> systemList = new ArrayList<>();
        for (UserSystem_21130814_MonjeRojas sys : this.systems){
            if (sys.getOwner().getName().equalsIgnoreCase(username)){
                systemList.add(sys);
            }
        }
        System.out.println("1) Crear System");
        Scanner sc = new Scanner(System.in);
        int i = 2;
        for (System_21130814_MonjeRojas sys : systemList){
            System.out.println(i + ") " + sys.getName());
            i++;
        }
        System.out.print("\nRespuesta: ");
        int respuesta = sc.nextInt();
        sc.nextLine();
        if (respuesta == 1){
            return 1;
        }
        else {
            this.currentSystem = systemList.get(respuesta - 2);
            return 0;
        }
    }

    public void addSystem(UserSystem_21130814_MonjeRojas sys){
        this.systems.add(sys);
    }
}
