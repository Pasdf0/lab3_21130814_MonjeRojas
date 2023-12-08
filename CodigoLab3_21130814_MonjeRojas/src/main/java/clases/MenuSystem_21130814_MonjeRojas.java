package clases;


import java.util.ArrayList;

public class MenuSystem_21130814_MonjeRojas extends System_21130814_MonjeRojas{
    private MenuSystem_21130814_MonjeRojas(Chatbot_21130814_MonjeRojas... cb){
        super("Sistema de Chatbots",0,cb);
    }

    public static MenuSystem_21130814_MonjeRojas getMenuSystem(){
        //C0
        Option_21130814_MonjeRojas Op011 = new Option_21130814_MonjeRojas(1,"1) Ingresar",1,1,"Ingresar","Login");
        Option_21130814_MonjeRojas Op012 = new Option_21130814_MonjeRojas(2,"2) Registrarse",0,2,"Registrarse","Sign up");
        Flow_21130814_MonjeRojas F01 = new Flow_21130814_MonjeRojas(1,"¿Qué desea hacer?",Op011,Op012);
        Option_21130814_MonjeRojas Op021 = new Option_21130814_MonjeRojas(1,"1) Usuario Común",2,1,"comun","común","usuario comun");
        Option_21130814_MonjeRojas Op022 = new Option_21130814_MonjeRojas(2,"2) Usuario Administrador",2,2,"admin","administrador","usuario administrador");
        Flow_21130814_MonjeRojas F02 = new Flow_21130814_MonjeRojas(2,"¿Que tipo de usuario desea registrar?",Op021,Op022);
        Chatbot_21130814_MonjeRojas C0 = new Chatbot_21130814_MonjeRojas(0,"Menú Interactivo","Escoger",1,F01,F02);
        //C1
        Option_21130814_MonjeRojas Op111 = new Option_21130814_MonjeRojas(1,"Ingrese su Nombre de Usuario",100,1,"talk");
        Flow_21130814_MonjeRojas F11 = new Flow_21130814_MonjeRojas(1,"-Ingresar-",Op111);
        Chatbot_21130814_MonjeRojas C1 = new Chatbot_21130814_MonjeRojas(1,"Menú Interactivo","Ingreso",1,F11);
        //C2
        Option_21130814_MonjeRojas Op211 = new Option_21130814_MonjeRojas(1,"Ingrese un Nombre de Usuario",0,1,"talk");
        Flow_21130814_MonjeRojas F21 = new Flow_21130814_MonjeRojas(1, "-Registro- (Comun)",Op211);
        Flow_21130814_MonjeRojas F22 = new Flow_21130814_MonjeRojas(2,"-Registro- (Admin)",Op211);
        Chatbot_21130814_MonjeRojas C2 = new Chatbot_21130814_MonjeRojas(2,"Menú Interactivo","Registro",1,F21,F22);

        //C3

        //CFinal
        Option_21130814_MonjeRojas OpFinal = new Option_21130814_MonjeRojas(1, "Final",0,1,"Final");
        Flow_21130814_MonjeRojas FwFinal = new Flow_21130814_MonjeRojas(1,"Final", OpFinal);
        Chatbot_21130814_MonjeRojas CFinal = new Chatbot_21130814_MonjeRojas(100,"Final","Final",1, FwFinal);

        return new MenuSystem_21130814_MonjeRojas(C0,C1,C2,CFinal);
        //menu.systemAddAdminUser("Sin sesion activa");
        //menu.systemLogin("Sin sesion activa");
    }

}
