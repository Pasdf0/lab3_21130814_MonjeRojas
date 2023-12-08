package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSystem_21130814_MonjeRojas extends System_21130814_MonjeRojas{
    private AdminUser_21130814_MonjeRojas owner;

    public UserSystem_21130814_MonjeRojas(AdminUser_21130814_MonjeRojas Usr){
        super("Sistema de " + Usr.getName(),1000);
        this.owner = Usr;
    }

    public void createSystem(){
        System.out.println("############### Creando Sistema de Chatbots ###############");
        System.out.println("# Instrucciones:                                          #");
        System.out.println("# -No se aceptan errores de Ingreso                       #");
        System.out.println("# -Se pueden dejar elementos como keywords, los option    #");
        System.out.println("#  en un flow o los flows en un chatbot vacios.           #");
        System.out.println("# -Se pueden responder a las preguntas (¿?) ingresando    #");
        System.out.println("#  cualquier cosa, detecta inputs vacios para detener el  #");
        System.out.println("#  proceso.                                               #");
        System.out.println("# -Por favor seguir instrucciones, gracias.               #");
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Ingrese la id del chatbot inicial de su sistema: ");
        Integer cb_code = sc.nextInt();
        sc.nextLine();
        this.setCb_code(cb_code);
        ArrayList<Chatbot_21130814_MonjeRojas> chatbots = new ArrayList<>();
        while(true) {
            System.out.println("¿Desea agregar un Chatbot?\n-En caso negativo presione Enter-");
            String checkSys = sc.nextLine().trim();
            if (!checkSys.isEmpty()) {
                Chatbot_21130814_MonjeRojas Cb = createChatbot();
                this.systemAddChatbot(Cb);
            } else {
                break;
            }
        }
    }

    private static Option_21130814_MonjeRojas createOption(){
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
        System.out.println("Option Creada Correctamente");
        return new Option_21130814_MonjeRojas(id,msg,cb_code,fw_code,keywords.toArray(String[]::new));
    }

    private static Flow_21130814_MonjeRojas createFlow(){
        System.out.println("##### Crear Flow #####");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la id del Flow: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el mensaje: ");
        String msg = sc.nextLine();
        Flow_21130814_MonjeRojas Fw = new Flow_21130814_MonjeRojas(id,msg,(Option_21130814_MonjeRojas[]) null);
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
        System.out.println("\n-Flow creado correctamente-");
        return Fw;
    }

    private static Chatbot_21130814_MonjeRojas createChatbot(){
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
        Chatbot_21130814_MonjeRojas Cb = new Chatbot_21130814_MonjeRojas(id,name,msg,fw_code,(Flow_21130814_MonjeRojas[]) null);
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
        System.out.println("\n-Chatbot creado correctamente-");
        return Cb;
    }
}
