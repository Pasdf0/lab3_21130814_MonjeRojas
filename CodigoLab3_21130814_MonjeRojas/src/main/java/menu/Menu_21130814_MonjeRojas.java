package menu;

import clases.*;

import java.util.ArrayList;
import java.util.Scanner;

import static clases.UserSystem_21130814_MonjeRojas.*;

/**
 * La Clase Menu es la que permite la interacción por consola, se encarga de coordinar
 * los estados de la clase {@link MenuSystem_21130814_MonjeRojas} para ser mostrados por pantalla.
 */
public class Menu_21130814_MonjeRojas {
    //Atributos
    /**
     * myMenu almacena el system predefinido de MenuSystem {@link MenuSystem_21130814_MonjeRojas}
     */
    private final MenuSystem_21130814_MonjeRojas myMenu;
    /**
     * myDemo almacena el system predefinido de DemoSystem {@link DemoSystem_21130814_MonjeRojas}
     */
    private final DemoSystem_21130814_MonjeRojas myDemo;
    /**
     * currentSystem almacena el sistema que se esté ocupando en el momento
     */
    private System_21130814_MonjeRojas currentSystem;
    /**
     * currentCb almacena el Chatbot que se quiera modificar en el momento
     */
    private Chatbot_21130814_MonjeRojas currentCb;
    /**
     * systems almacena cada system creado por un usuario administrador en el menu.
     */
    private ArrayList<UserSystem_21130814_MonjeRojas> systems;

    //Metodos
    /**
     * Constructor de Menu, inicializa el System usado para menu y el system Demo
     * Además, genera una lista para contener Systems vacia
     */
    public Menu_21130814_MonjeRojas(){
        this.myMenu = MenuSystem_21130814_MonjeRojas.getMenuSystem();
        this.myDemo = DemoSystem_21130814_MonjeRojas.getSystemDemo();
        this.systems = new ArrayList<>();
    }

    /**
     * Este Método se utiliza para hacer distintas acciones dependiendo del estado
     * del atributo myMenu, ya que este último es un sistema de chatbots que sirve como menu.
     * Mantiene la operación activa con un while, y revisa cada estado con ifs.
     * Cada pregunta o pantalla es un Chatbot o flow y las respuestas a ellos se diferencian
     * a través del Flow_code actual.
     */
    public void run(){
        Scanner sc = new Scanner(System.in);
        //Estados de myMenu
        while(true){
            //Chatbot 0
            if (this.myMenu.getCbCode() == 0){
                String respuesta = this.askMenu();
                this.myMenu.systemTalk(respuesta);
            }
            //Chatbot 1
            else if (this.myMenu.getCbCode() == 1){
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
            //Chatbot 2
            else if(this.myMenu.getCbCode() == 2){
                this.myMenu.findCb(0).resetFwCode();
                String respuesta = this.askMenu();
                if (this.myMenu.findUser(respuesta) == null) {
                    if (this.myMenu.findCb(this.myMenu.getCbCode()).getFwCode() == 1) {
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
            //Chatbot 3
            else if (this.myMenu.getCbCode() == 3) {
                Integer check = this.myMenu.findCb(3).getFwCode();
                if (check == 1){
                    if (this.myMenu.getUser().getPermissionId() == 0) {
                        this.myMenu.setCbCode(4);
                    } else {
                        String respuesta = this.askMenu();
                        this.myMenu.systemTalk(respuesta);
                    }
                }
                else if (check == 2){
                    this.chooseSystemCommon();
                    this.myMenu.setCbCode(6);
                    this.myMenu.findCb(3).resetFwCode();
                }
                else {
                    Integer select = this.chooseSystemAdmin();
                    if (select == 1){
                        UserSystem_21130814_MonjeRojas newSys = createSystem((AdminUser_21130814_MonjeRojas) this.myMenu.getUser());
                        this.systems.add(newSys);
                    }
                    else {
                        this.myMenu.setCbCode(5);
                        this.showInstructions();
                    }
                    this.myMenu.findCb(3).resetFwCode();
                }
            }
            //Chatbot 4
            else if (this.myMenu.getCbCode() == 4){
                this.currentSystem = myDemo;
                myMenu_4_6(4);
            }
            //Chatbot 5
            else if (this.myMenu.getCbCode() == 5){
                Integer check = this.myMenu.findCb(5).getFwCode();
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
                    this.currentCb = this.currentSystem.chooseChatbot();
                    if (this.currentCb != null) {
                        this.myMenu.setCbCode(7);
                    }
                }
                else if (check == 4){
                    System.out.print("\n");
                    Chatbot_21130814_MonjeRojas Cb = this.currentSystem.chooseChatbot();
                    if (Cb != null) {
                        Cb.showChatbot();
                    }
                }
                else if (check == 5){
                    System.out.print("\nIngrese la nueva id inicial: ");
                    Integer newId = sc.nextInt();
                    this.currentSystem.setCbCode(newId);
                }
                if (check != 1) {
                    this.myMenu.findCb(5).resetFwCode();
                }
            }
            //Chatbot 6
            else if (this.myMenu.getCbCode() == 6){
                myMenu_4_6(6);
            }
            //Chatbot 7
            else if (this.myMenu.getCbCode() == 7){
                Integer check = this.myMenu.findCb(7).getFwCode();
                System.out.print("\n");
                System.out.print("\n");
                if (check == 1){
                    String respuesta = this.askMenu();
                    this.myMenu.systemTalk(respuesta);
                }
                else if (check == 2){
                    Flow_21130814_MonjeRojas Fw = createFlow();
                    this.currentCb.chatbotAddFlow(Fw);
                }
                else if (check == 3){
                    Flow_21130814_MonjeRojas Fw = this.currentCb.chooseFlow();
                    if (Fw != null) {
                        this.currentCb.chatbotAddFlow(Fw);
                    }
                }
                if (check != 1){
                    this.myMenu.findCb(7).resetFwCode();
                }
            }
            //Chatbot 99
            else if (this.myMenu.getCbCode() == 99){
                System.out.println("\n-Se ha cerrado la sesion correctamente-");
                System.out.println("\n##########################################");
                System.out.println("##### Gracias por usar este programa #####");
                System.out.println("##########################################");
                this.myDemo.systemLogout();
                this.myMenu.systemLogout();
                this.myMenu.resetSystem();
            }
            //Chatbot Final
            else{
                break;
            }
        }
    }

    /**
     * Muestra el estado actual del System myMenu y recoge una
     * respuesta por consola
     * @return respuesta ingresada por consola como string
     */
    private String askMenu(){
        System.out.print("\n");
        this.myMenu.systemState();
        Scanner sc = new Scanner(System.in);
        System.out.print("Respuesta: ");
        return sc.nextLine().trim();
    }

    /**
     * Muestra el estado actual del System actual o que se está manipulando
     * y recoge una respuesta por consola
     * @return respuesta ingresada por consola como string
     */
    private String askCurrent(){
        System.out.print("\n");
        this.currentSystem.systemState();
        Scanner sc = new Scanner(System.in);
        System.out.print("Respuesta: ");
        return sc.nextLine().trim();
    }

    /**
     * Muestra las instrucciones a seguir para crear elementos correctamente.
     */
    private void showInstructions(){
        System.out.println("\n\n############### Creando Sistema de Chatbots ###############");
        System.out.println("# Instrucciones:                                          #");
        System.out.println("# -NO SE CONTEMPLAN ERRORES DE INGRESO AL CREAR ELEMENTOS #");
        System.out.println("# -Se pueden dejar elementos como keywords, los option    #");
        System.out.println("#  en un flow o los flows en un chatbot vacios.           #");
        System.out.println("# -Se pueden responder a las preguntas con signo de       #");
        System.out.println("#  interrogacion respondiendo cualquier cosa, detecta     #");
        System.out.println("#  inputs vacios para detener el proceso.                 #");
        System.out.println("# -No es posible modificar el System Demo.                #");
        System.out.println("# -Por favor seguir instrucciones, gracias.               #");
        System.out.println("###########################################################");
    }

    /**
     * Muestra por consola el system Demo además de los systems de los que el usuario
     * administrador actual posea (sea dueño), no existe para usuario comun.
     * Asigna el system escogido al atributo currentSystem para interacciones.
     */
    private void chooseSystemCommon(){
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
    }

    /**
     * Muestra por consola la opción crear System además de los systems de los que el usuario
     * administrador actual posea (sea dueño), no existe para usuario común.
     * @return En caso de escoger crear, retorna 1 para indicar la elección,
     *         si se escogió un system, lo asigna a currentSystem para su uso y
     *         retorna 0.
     */
    private Integer chooseSystemAdmin(){
        System.out.println("\n##### Cual System desea Modificar #####");
        System.out.println("-Para seleccionar ingresar un numero-");
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

    /**
     * Método auxiliar para no repetir código, las opciones comunes para usuarios administradores y
     * comunes son similares, pero con pequeñas diferencias de muestreo.
     * @param cb_code código actual de myMenu, se ingresa en sus respectivos estados.
     */
    private void myMenu_4_6(Integer cb_code){
        Scanner sc = new Scanner(System.in);
        Integer check = this.myMenu.findCb(cb_code).getFwCode();
        if (check == 1){
            String respuesta = this.askMenu();
            this.myMenu.systemTalk(respuesta);
        }
        else if (check == 2){
            System.out.print("\n##### Presione Enter para salir (Respuesta Vacia) #####");
            this.currentSystem.getUser().deleteHistory();
            while (true) {
                String respuesta = this.askCurrent();
                if (!respuesta.isEmpty()) {
                    this.currentSystem.systemTalk(respuesta);
                }
                else{
                    break;
                }
            }
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
            this.currentSystem.showSystem();
        }
        if (check != 1) {
            this.myMenu.findCb(cb_code).resetFwCode();
        }
    }

    /**
     * Crea un option con datos entregados por consola
     * @return option creado
     */
    public static Option_21130814_MonjeRojas createOption(){
        System.out.println("\n##### Crear Option #####");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la id: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el mensaje: ");
        String msg = sc.nextLine();
        System.out.print("Ingrese la id del chatbot al que conecta: ");
        Integer cb_code = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese la id del flujo al que conecta: ");
        Integer fw_code = sc.nextInt();
        sc.nextLine();
        ArrayList<String> keywords= new ArrayList<>();
        System.out.println("### Ingrese las keywords una por una ###\n-Para terminar presione Enter-");
        while(true) {
            System.out.print("Keyword: ");
            String check = sc.nextLine().trim();
            if (!check.isEmpty()) {
                keywords.add(check);
            } else {
                break;
            }
        }
        System.out.println("\n-Option Creada Correctamente-\n");
        return new Option_21130814_MonjeRojas(id,msg,cb_code,fw_code,keywords.toArray(String[]::new));
    }

    /**
     * crea flow usando datos entregados por consola
     * @return flow creado
     */
    public static Flow_21130814_MonjeRojas createFlow(){
        System.out.println("\n##### Crear Flow #####");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la id del Flow: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el mensaje: ");
        String msg = sc.nextLine();
        Flow_21130814_MonjeRojas Fw = new Flow_21130814_MonjeRojas(id,msg);
        while(true) {
            System.out.println("¿Desea agregar un Option?\n-En caso negativo presione Enter-");
            String checkFw = sc.nextLine().trim();
            if (!checkFw.isEmpty()) {
                Option_21130814_MonjeRojas Op = createOption();
                Fw.flowAddOption(Op);
            } else {
                break;
            }
        }
        System.out.println("-Flow creado correctamente-\n");
        return Fw;
    }

    /**
     * crea chatbot usando datos entregados por consola
     * @return chatbot creado
     */
    public static Chatbot_21130814_MonjeRojas createChatbot(){
        System.out.println("\n##### Crear Chatbot #####");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la id del Chatbot: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el nombre del Chatbot: ");
        String name = sc.nextLine();
        System.out.print("Ingrese el mensaje del Chatbot: ");
        String msg = sc.nextLine();
        System.out.print("Ingrese el id del flujo inicial: ");
        Integer fw_code = sc.nextInt();
        sc.nextLine();
        Chatbot_21130814_MonjeRojas Cb = new Chatbot_21130814_MonjeRojas(id,name,msg,fw_code);
        while(true) {
            System.out.println("¿Desea agregar un Flow?\n-En caso negativo presione Enter-");
            String checkCb = sc.nextLine().trim();
            if (!checkCb.isEmpty()) {
                Flow_21130814_MonjeRojas Fw = createFlow();
                Cb.chatbotAddFlow(Fw);
            } else {
                break;
            }
        }
        System.out.println("-Chatbot creado correctamente-\n");
        return Cb;
    }
}
