package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSystem_21130814_MonjeRojas extends System_21130814_MonjeRojas{
    private AdminUser_21130814_MonjeRojas owner;

    public UserSystem_21130814_MonjeRojas(String name, Integer cb_code) {
        super(name, cb_code);
    }

    public static UserSystem_21130814_MonjeRojas createSystem(AdminUser_21130814_MonjeRojas Usr){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n###### Creacion de System ######");
        System.out.print("\n# Ingrese el nombre de su sistema: ");
        String name = sc.nextLine();
        System.out.print("# Ingrese la id del chatbot inicial de su sistema: ");
        Integer cb_code = sc.nextInt();
        sc.nextLine();
        /*
        while(true) {
            System.out.println("¿Desea agregar un Chatbot?\n-En caso negativo presione Enter-");
            String checkSys = sc.nextLine().trim();
            if (!checkSys.isEmpty()) {
                Chatbot_21130814_MonjeRojas Cb = createChatbot();
                this.systemAddChatbot(Cb);
            } else {
                break;
            }
        }*/
        UserSystem_21130814_MonjeRojas newSys = new UserSystem_21130814_MonjeRojas(name,cb_code);
        newSys.owner = Usr;
        newSys.systemAddAdminUser(Usr.getName());
        newSys.systemLogin(Usr.getName());
        System.out.println("\n##### Gracias por crear tu System #####");
        return newSys;
    }

    public static Option_21130814_MonjeRojas createOption(){
        System.out.println("##### Crear Option #####");
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

    public static Flow_21130814_MonjeRojas createFlow(){
        System.out.println("##### Crear Flow #####");
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

    public static Chatbot_21130814_MonjeRojas createChatbot(){
        System.out.println("##### Crear Chatbot #####");
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

    public AdminUser_21130814_MonjeRojas getOwner() {
        return owner;
    }
}
