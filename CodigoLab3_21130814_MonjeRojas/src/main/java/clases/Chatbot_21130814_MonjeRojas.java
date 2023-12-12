package clases;

import interfaz.IDuplicidad_21130814_MonjeRojas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase Chatbot
 * Contiene Flows
 * Hereda de {@link BaseStruct_21130814_MonjeRojas}
 */
public class Chatbot_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements IDuplicidad_21130814_MonjeRojas {
    /**
     * Lista que contiene los Flows agregados al Chatbot
     */
    private ArrayList<Flow_21130814_MonjeRojas> flows;
    /**
     * Almacena el primer FwCode asignado, se utiliza para volver al estado original
     */
    private final Integer initialFwCode;

    /**
     * Constructor de Chatbot
     * @param id identificador único de un Chatbot
     * @param name nombre del Chatbot
     * @param msg mensaje del Chatbot
     * @param startFwID id del Flow inicial
     * @param fws Lista de Flows almacenados
     */
    public Chatbot_21130814_MonjeRojas(Integer id, String name, String msg, Integer startFwID, Flow_21130814_MonjeRojas... fws){
        this.setId(id);
        this.setName(name);
        this.setMsg(msg);
        this.setFwCode(startFwID);
        this.initialFwCode = this.fwCode;
        if (fws != null) {
            ArrayList<Flow_21130814_MonjeRojas> flows = new ArrayList<>(Arrays.asList(fws));
            this.setFlows(flows);
        }
        else{
            this.flows = new ArrayList<>();
        }
    }

    //Getters

    /**
     * Consigue la lista de Flows
     * @return Lista de Flows
     */
    public ArrayList<Flow_21130814_MonjeRojas> getFlows() {return flows;}

    /**
     * Consigue el id del Flow original
     * @return id del primer Flow asignado
     */
    public Integer getInitialFwCode() {return initialFwCode;}

    //Setters

    /**
     * Establece la lista de Flows eliminando duplicados
     * @param flows Lista de Flows
     */
    public void setFlows(ArrayList<Flow_21130814_MonjeRojas> flows) {
        ArrayList<Flow_21130814_MonjeRojas> newFlows;
        newFlows = (ArrayList<Flow_21130814_MonjeRojas>) removeDuplicates(flows);
        this.flows = newFlows;
    }

    /**
     * Restablece el Chatbot a su estado original
     */
    public void resetFwCode(){
        this.fwCode = this.getInitialFwCode();
    }

    //Otros

    /**
     * Muestra el Chatbot por consola
     */
    public void showChatbot(){
        System.out.println("##    Chatbot (id: " + this.getId() + ")");
        System.out.println("##        Nombre: " + this.getName());
        System.out.println("##        Mensaje: " + this.getMsg());
        if (this.getFlows().isEmpty()){
            System.out.println("##        [No_Flows]");
        }
        else {
            for (Flow_21130814_MonjeRojas fw : this.getFlows()) {
                fw.showFlow();
            }
        }
    }

    /**
     * Permite escoger un flow para ser modificado
     * @return Flow elegido
     */
    public Flow_21130814_MonjeRojas chooseFlow(){
        if (this.getFlows().isEmpty()){
            System.out.println("\n-Este Chatbot no posee Flows-");
            return null;
        }
        else{
            System.out.println("Lista de Flows: ");
            System.out.println("-Para seleccionar ingresar la id-");
            Scanner sc = new Scanner(System.in);
            for (Flow_21130814_MonjeRojas Fw : this.getFlows()) {
                System.out.println("(id: " + Fw.getId() + ") " + Fw.getMsg());
            }
            System.out.print("\nRespuesta: ");
            Integer index = sc.nextInt();
            sc.nextLine();
            return this.findFw(index);
        }
    }

    /**
     * Permite añadir un Flow al Chatbot
     * solo en caso de que su id no esté ya dentro
     * @param Fw Flow a añadir
     */
    public void chatbotAddFlow(Flow_21130814_MonjeRojas Fw){
        this.addNotDup(Fw);
    }

    /**
     * Permite encontrar un Flow dentro de un Chatbot a partir de su id
     * @param fw_code id del Flujo a encontrar
     * @return null si no lo encuentra, el propio flow en caso contrario
     */
    public Flow_21130814_MonjeRojas findFw(Integer fw_code){
        for (Flow_21130814_MonjeRojas Fw : this.flows){
            if (fw_code.equals(Fw.getId())){
                return Fw;
            }
        }
        return null;
    }

    /**
     * Implementación de {@link IDuplicidad_21130814_MonjeRojas}
     * elimina flows duplicados por id
     * @param flows lista de flows
     * @return Lista de Flows sin duplicados
     */
    @Override
    public ArrayList<?> removeDuplicates(ArrayList<?> flows){
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        for (Object item : flows) {
            Flow_21130814_MonjeRojas Fw = (Flow_21130814_MonjeRojas) item;
            ids.add(Fw.getId());
        }
        //conseguir index de ids unicas
        ArrayList<Integer> ids_index = getIdsIndex(ids);
        //filtrar options
        ArrayList<Flow_21130814_MonjeRojas> newFlows = new ArrayList<>();
        for (Integer number : ids_index){
            if (!number.equals(-1)){
                newFlows.add((Flow_21130814_MonjeRojas) flows.get(number));
            }
        }
        return newFlows;
    }

    /**
     * Implementación de {@link IDuplicidad_21130814_MonjeRojas}
     * permite añadir un flow verificando duplicidad
     * @param Fw1 elemento a añadir
     * @param <T> parametrización para realizar implementación correctamente
     */
    @Override
    public <T> void addNotDup(T Fw1){
        Flow_21130814_MonjeRojas Fw = (Flow_21130814_MonjeRojas) Fw1;
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        ArrayList<Flow_21130814_MonjeRojas> flows = this.getFlows();
        for (Flow_21130814_MonjeRojas item : flows) {
            ids.add(item.getId());
        }
        if (!ids.contains(Fw.getId())){
            this.flows.add(Fw);
        }
    }
}