package clases;

public class DemoSystem_21130814_MonjeRojas extends System_21130814_MonjeRojas{
    private DemoSystem_21130814_MonjeRojas(Chatbot_21130814_MonjeRojas... cb){
        super("Chatbot Paradigmas",0,cb);
    }

    public static DemoSystem_21130814_MonjeRojas getSystemDemo(){
        //Chatbot 0
        Option_21130814_MonjeRojas Op1 = new Option_21130814_MonjeRojas(1, "1) Viajar", 1, 1,"viajar","turistear","conocer");
        Option_21130814_MonjeRojas Op2 = new Option_21130814_MonjeRojas(2, "2) Estudiar", 2, 1,"Estudiar","Aprender","Perfeccionarme");
        Flow_21130814_MonjeRojas F10 = new Flow_21130814_MonjeRojas(1,"Flujo Principal Chatbot 0\nBienvenido\n¿Que te gustaria hacer?", Op1, Op2, Op2, Op2, Op1, Op1);
        F10.flowAddOption(Op1);
        Chatbot_21130814_MonjeRojas Cb0 = new Chatbot_21130814_MonjeRojas(0,"Inicial","Bienvenido\n¿Qué te gustaría hacer?",1,F10,F10);
        //Chatbot 1
        Option_21130814_MonjeRojas Op3 = new Option_21130814_MonjeRojas(1, "1) New York, USA", 1, 2,"USA","Estados Unidos", "New York");
        Option_21130814_MonjeRojas Op4 = new Option_21130814_MonjeRojas(2, "2) París, Francia", 1, 1,"Paris","Eiffel");
        Option_21130814_MonjeRojas Op5 = new Option_21130814_MonjeRojas(3, "3) Torres del Paine, Chile", 1, 1,"Chile","Torres","Paine","Torres Paine","Torres del Paine");
        Option_21130814_MonjeRojas Op6 = new Option_21130814_MonjeRojas(4, "4) Volver", 0, 1,"Regresar","Salir","Volver");
        Option_21130814_MonjeRojas Op7 = new Option_21130814_MonjeRojas(1, "1) Central Park", 1, 2,"Central","Park","Central Park");
        Option_21130814_MonjeRojas Op8 = new Option_21130814_MonjeRojas(2, "2) Museos", 1, 2,"Museo");
        Option_21130814_MonjeRojas Op9 = new Option_21130814_MonjeRojas(3, "3) Ningún otro atractivo", 1, 3,"Museo");
        Option_21130814_MonjeRojas Op10 = new Option_21130814_MonjeRojas(4, "4) Cambiar destino", 1, 1,"Cambiar","Volver","Salir");
        Option_21130814_MonjeRojas Op11 = new Option_21130814_MonjeRojas(1, "1) Solo", 1, 3,"Solo");
        Option_21130814_MonjeRojas Op12 = new Option_21130814_MonjeRojas(2, "2) En pareja", 1, 3,"Pareja");
        Option_21130814_MonjeRojas Op13 = new Option_21130814_MonjeRojas(3, "3) En familia", 1, 3,"Familia");
        Option_21130814_MonjeRojas Op14 = new Option_21130814_MonjeRojas(4, "4) Agregar más atractivos", 1, 2,"Volver","Atractivos");
        Option_21130814_MonjeRojas Op15 = new Option_21130814_MonjeRojas(5, "5) En realidad quiero otro destino", 1, 1,"Cambiar destino");
        Flow_21130814_MonjeRojas F20 = new Flow_21130814_MonjeRojas(1,"Flujo 1 Chatbot1\n¿Donde te gustaría ir?",Op3,Op4,Op5);
        Flow_21130814_MonjeRojas F21 = new Flow_21130814_MonjeRojas(2,"Flujo 2 Chatbot1\n¿Qué atractivos te gustaría visitar?",Op7,Op8,Op8,Op9,Op10);
        Flow_21130814_MonjeRojas F22 = new Flow_21130814_MonjeRojas(3,"Flujo 3 Chatbot1\n¿Vas solo o acompañado?",Op11,Op12,Op13,Op14,Op15);
        F20.flowAddOption(Op6);
        Chatbot_21130814_MonjeRojas Cb1 = new Chatbot_21130814_MonjeRojas(1,"Agencia Viajes","Bienvenido\n¿Donde quieres viajar",1,F20,F21,F21);
        Cb1.chatbotAddFlow(F22);
        //Chatbot 2
        Option_21130814_MonjeRojas Op16 = new Option_21130814_MonjeRojas(1,"1) Carrera Técnica",2,1,"Técnica");
        Option_21130814_MonjeRojas Op17 = new Option_21130814_MonjeRojas(2,"2) Postgrado",2,1,"Doctorado","Magister","Postgrado");
        Option_21130814_MonjeRojas Op18 = new Option_21130814_MonjeRojas(3,"3) Volver",0,1,"Volver","Salir","Regresar");
        Flow_21130814_MonjeRojas F30 = new Flow_21130814_MonjeRojas(1,"Flujo 1 Chatbot2\n¿Qué te gustaría estudiar?",Op16,Op17,Op18,Op18);
        Chatbot_21130814_MonjeRojas Cb2 = new Chatbot_21130814_MonjeRojas(2,"Orientador Académico","Bienvenido\n¿Qué te gustaría estudiar?",1,F30);

        //System
        return new DemoSystem_21130814_MonjeRojas(Cb0,Cb1,Cb2);
    }
}
