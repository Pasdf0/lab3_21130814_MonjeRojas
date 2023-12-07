package clases;


public class MenuSystem_21130814_MonjeRojas extends System_21130814_MonjeRojas{
    private MenuSystem_21130814_MonjeRojas(Chatbot_21130814_MonjeRojas... cb){
        super("Sistema de Chatbots",0,cb);
    }

    public MenuSystem_21130814_MonjeRojas getMenuSystem(){
        //C0
        Option_21130814_MonjeRojas Op011 = new Option_21130814_MonjeRojas(1,"1) Ingresar",1,1,"Ingresar","Login");
        Option_21130814_MonjeRojas Op012 = new Option_21130814_MonjeRojas(2,"2) Registrarse",2,1,"Registrarse","Sign up");
        Flow_21130814_MonjeRojas F01 = new Flow_21130814_MonjeRojas(1,"¿Qué desea hacer?",Op011,Op012);
        Chatbot_21130814_MonjeRojas C0 = new Chatbot_21130814_MonjeRojas(0,"Menú Interactivo","Tipo de Usuario",1,F01);
        //C1
        Option_21130814_MonjeRojas Op111 = new Option_21130814_MonjeRojas(1,"Ingrese su Nombre de Usuario: ",100,100,"");
        Flow_21130814_MonjeRojas F11 = new Flow_21130814_MonjeRojas(1,"-Ingresar-",Op111);
        Chatbot_21130814_MonjeRojas C1 = new Chatbot_21130814_MonjeRojas(1,"Menú Interactivo","Ingreso",1,F11);
        //C2
        Option_21130814_MonjeRojas Op211 = new Option_21130814_MonjeRojas(1,"1) Usuario Común",2,2,"comun","común","usuario comun");
        Option_21130814_MonjeRojas Op212 = new Option_21130814_MonjeRojas(2,"2) Usuario Administrador",2,3,"admin","administrador","usuario administrador");
        Flow_21130814_MonjeRojas F21 = new Flow_21130814_MonjeRojas(1,"¿Que tipo de usuario desea registrar?",Op211,Op212);
        Option_21130814_MonjeRojas Op221 = new Option_21130814_MonjeRojas(1,"Ingrese un Nombre de Usuario: ",100,100,"");
        Flow_21130814_MonjeRojas F22 = new Flow_21130814_MonjeRojas(2, "-Registro- (Comun)",Op221);
        Flow_21130814_MonjeRojas F23 = new Flow_21130814_MonjeRojas(3,"-Registro- (Admin)",Op221);
        Chatbot_21130814_MonjeRojas C2 = new Chatbot_21130814_MonjeRojas(2,"Menú Interactivo","Registro",1,F21,F22,F23);

        return new MenuSystem_21130814_MonjeRojas(C0,C1,C2);
    }
}
