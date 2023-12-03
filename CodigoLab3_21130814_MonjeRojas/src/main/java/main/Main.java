package main;

import clases.*;

public class Main {
    public static void main(String[] args){
        Option_21130814_MonjeRojas Op1 = new Option_21130814_MonjeRojas();
        Option_21130814_MonjeRojas Op2 = new Option_21130814_MonjeRojas();
        Op1.Option(1, "1) Viajar", 1, 1,"viajar","turistear","conocer");
        Op2.Option(2, "2) Estudiar", 2, 1,"Estudiar","Aprender","Perfeccionarme");
        Flow_21130814_MonjeRojas F10 = new Flow_21130814_MonjeRojas();
        F10.Flow(1,"Flujo Principal Chatbot 0\nBienvenido\n¿Qué te gustaría hacer?", Op1, Op2, Op2, Op2);
        F10.ShowFlow();
    }
}
