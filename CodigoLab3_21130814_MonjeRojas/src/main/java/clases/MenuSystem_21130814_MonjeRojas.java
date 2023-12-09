package clases;


public class MenuSystem_21130814_MonjeRojas extends System_21130814_MonjeRojas{
    private MenuSystem_21130814_MonjeRojas(Chatbot_21130814_MonjeRojas... cb){
        super("Sistema de Chatbots",0,cb);
    }

    public static MenuSystem_21130814_MonjeRojas getMenuSystem() {
        //C0 Inicial
        Option_21130814_MonjeRojas Op011 = new Option_21130814_MonjeRojas(1, "1) Ingresar", 1, 1, "Ingresar", "Login");
        Option_21130814_MonjeRojas Op012 = new Option_21130814_MonjeRojas(2, "2) Registrarse", 0, 2, "Registrarse", "Sign up");
        Flow_21130814_MonjeRojas F01 = new Flow_21130814_MonjeRojas(1, "¿Qué desea hacer?", Op011, Op012);
        Option_21130814_MonjeRojas Op021 = new Option_21130814_MonjeRojas(1, "1) Usuario Común", 2, 1, "comun", "común", "usuario comun");
        Option_21130814_MonjeRojas Op022 = new Option_21130814_MonjeRojas(2, "2) Usuario Administrador", 2, 2, "admin", "administrador", "usuario administrador");
        Flow_21130814_MonjeRojas F02 = new Flow_21130814_MonjeRojas(2, "¿Que tipo de usuario desea registrar?", Op021, Op022);
        Chatbot_21130814_MonjeRojas C0 = new Chatbot_21130814_MonjeRojas(0, "Menú Interactivo", "Escoger", 1, F01, F02);

        //C1 Ingresar
        Option_21130814_MonjeRojas Op111 = new Option_21130814_MonjeRojas(1, "Ingrese su Nombre de Usuario", 3, 1, "talk");
        Flow_21130814_MonjeRojas F11 = new Flow_21130814_MonjeRojas(1, "-Ingresar-", Op111);
        Chatbot_21130814_MonjeRojas C1 = new Chatbot_21130814_MonjeRojas(1, "Menú Interactivo", "Ingreso", 1, F11);

        //C2 Registrarse
        Option_21130814_MonjeRojas Op211 = new Option_21130814_MonjeRojas(1, "Ingrese un Nombre de Usuario", 0, 1, "talk");
        Flow_21130814_MonjeRojas F21 = new Flow_21130814_MonjeRojas(1, "-Registro- (Comun)", Op211);
        Flow_21130814_MonjeRojas F22 = new Flow_21130814_MonjeRojas(2, "-Registro- (Admin)", Op211);
        Chatbot_21130814_MonjeRojas C2 = new Chatbot_21130814_MonjeRojas(2, "Menú Interactivo", "Registro", 1, F21, F22);

        //C3 De Paso
        Option_21130814_MonjeRojas Op311 = new Option_21130814_MonjeRojas(1, "1) Opciones de Usuario Común (Interactuar)", 3, 2, "comun", "usuario comun");
        Option_21130814_MonjeRojas Op312 = new Option_21130814_MonjeRojas(2, "2) Opciones de Usuario Administrador (Crear/Modificar)", 3, 3, "Admin", "usuario admin", "administrador");
        Option_21130814_MonjeRojas Op313 = new Option_21130814_MonjeRojas(3, "3) Salir", 100, 1, "salir", "volver", "logout");
        Flow_21130814_MonjeRojas F31 = new Flow_21130814_MonjeRojas(1, "Bienvenido\n-En caso de existir un System vacio, no estará disponible para interaccion-\n¿Que desea hacer?", Op311, Op312, Op313);
        Chatbot_21130814_MonjeRojas C3 = new Chatbot_21130814_MonjeRojas(3, "Menu Usuario Administrador", "Chatbot Admin", 1, F31);

        //C4 Opciones Comun
        Option_21130814_MonjeRojas Op411 = new Option_21130814_MonjeRojas(1, "1) System Talk", 4, 2, "hablar", "talk", "System Talk");
        Option_21130814_MonjeRojas Op412 = new Option_21130814_MonjeRojas(2, "2) System Synthesis", 4, 3, "sintesis", "Synthesis", "system Synthesis");
        Option_21130814_MonjeRojas Op413 = new Option_21130814_MonjeRojas(3, "3) System Simulate", 4, 4, "Simular", "System Simulate", "Simulate");
        Option_21130814_MonjeRojas Op414 = new Option_21130814_MonjeRojas(4, "4) Ver System Demo", 4, 5, "ver", "system demo", "demo", "ver system demo");
        Option_21130814_MonjeRojas Op415 = new Option_21130814_MonjeRojas(5, "5) Salir", 100, 1, "salir", "volver", "logout");
        Flow_21130814_MonjeRojas F41 = new Flow_21130814_MonjeRojas(1, "Bienvenido\n¿Qué desea hacer?", Op411, Op412, Op413, Op414, Op415);
        Chatbot_21130814_MonjeRojas C4 = new Chatbot_21130814_MonjeRojas(4, "Menu Usuario Común\n-Los usuarios comunes disponen solamente del Sistema Demo-", "Chatbot Comun", 1, F41);

        //C5 Opciones Admin_Admin
        Option_21130814_MonjeRojas Op511 = new Option_21130814_MonjeRojas(1, "1) Crear un Chatbot", 5, 2, "login", "ingresar", "entrar");
        Option_21130814_MonjeRojas Op512 = new Option_21130814_MonjeRojas(2, "2) Modificar un Chatbot", 5, 3, "hablar", "talk", "System Talk");
        Option_21130814_MonjeRojas Op513 = new Option_21130814_MonjeRojas(3, "3) Visualizar un Chatbot", 5, 4, "sintesis", "Synthesis", "system Synthesis");
        Option_21130814_MonjeRojas Op514 = new Option_21130814_MonjeRojas(4, "4) Cambiar la id del Chatbot Inicial", 5, 5, "id", "cambiar", "inicial");
        Option_21130814_MonjeRojas Op515 = new Option_21130814_MonjeRojas(5, "5) Volver", 3, 1, "salir", "volver", "atras");
        Flow_21130814_MonjeRojas F51 = new Flow_21130814_MonjeRojas(1, "-Aqui puede modificar el system escogido-", Op511, Op512, Op513, Op514, Op515);
        Chatbot_21130814_MonjeRojas C5 = new Chatbot_21130814_MonjeRojas(5, "Menu Usuario Administrador\n-System Personal-", "System Personal", 1, F51);

        //C6 Opciones Admin_Comun
        Option_21130814_MonjeRojas Op611 = new Option_21130814_MonjeRojas(1, "1) System Talk", 6, 2, "hablar", "talk", "System Talk");
        Option_21130814_MonjeRojas Op612 = new Option_21130814_MonjeRojas(2, "2) System Synthesis", 6, 3, "sintesis", "Synthesis", "system Synthesis");
        Option_21130814_MonjeRojas Op613 = new Option_21130814_MonjeRojas(3, "3) System Simulate", 6, 4, "Simular", "System Simulate", "Simulate");
        Option_21130814_MonjeRojas Op614 = new Option_21130814_MonjeRojas(4, "4) Ver System", 6, 5, "ver", "system demo", "demo", "ver system demo");
        Option_21130814_MonjeRojas Op615 = new Option_21130814_MonjeRojas(5, "5) Volver", 3, 1, "salir", "volver", "atras");
        Flow_21130814_MonjeRojas F61 = new Flow_21130814_MonjeRojas(1, "-Aqui puede interactuar con el System escogido-", Op611, Op612, Op613, Op614, Op615);
        Chatbot_21130814_MonjeRojas C6 = new Chatbot_21130814_MonjeRojas(6, "Menu Usuario Administrador\n-Interaccion-", "System Interact", 1, F61);

        //C7 Modificar un Chatbot
        Option_21130814_MonjeRojas Op711 = new Option_21130814_MonjeRojas(1,"1) Agregar un Flow",7,2,"flujo","agregar flujo","agregar flow","flow");
        Option_21130814_MonjeRojas Op712 = new Option_21130814_MonjeRojas(2,"2) Agregar un Option",7,3,"opcion","agregar option","option");
        Flow_21130814_MonjeRojas F71 = new Flow_21130814_MonjeRojas(1,"-Modificar Chatbot-",Op711,Op712);
        Chatbot_21130814_MonjeRojas C7 = new Chatbot_21130814_MonjeRojas(7,"Menu Usuario Adminstrador\n-Interaccion-","Modify Chatbot",1,F71);

        //CFinal
        Option_21130814_MonjeRojas OpFinal = new Option_21130814_MonjeRojas(1, "Final", 0, 1, "Final");
        Flow_21130814_MonjeRojas FwFinal = new Flow_21130814_MonjeRojas(1, "Final", OpFinal);
        Chatbot_21130814_MonjeRojas CFinal = new Chatbot_21130814_MonjeRojas(100, "Final", "Final", 1, FwFinal);


        MenuSystem_21130814_MonjeRojas menu = new MenuSystem_21130814_MonjeRojas(C0,C1,C2,C3,C4,C5,C6,C7,CFinal);
        menu.systemAddAdminUser("Pasdf");
        return menu;
        //return new MenuSystem_21130814_MonjeRojas(C0,C1,C2,C3,C4,C5,C6,C7,CFinal);
    }
}
