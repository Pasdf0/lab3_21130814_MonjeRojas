package clases;

import interfaz.Interface_21130814_MonjeRojas;
import java.util.ArrayList;
import java.util.Arrays;

public class Chatbot_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements Interface_21130814_MonjeRojas{
    private ArrayList<Flow_21130814_MonjeRojas> flows;

    public void Chatbot(Integer id, String name, String msg, Integer startFwID, Flow_21130814_MonjeRojas... fws){
        this.setId(id);
        this.setName(name);
        this.setMsg(msg);
        this.setFw_code(startFwID);
        ArrayList<Flow_21130814_MonjeRojas> flows = new ArrayList<> (Arrays.asList(fws));
        this.setFlows(flows);
    }

    //Getters
    public ArrayList<Flow_21130814_MonjeRojas> getFlows() {return flows;}

    //Setters
    public void setFlows(ArrayList<Flow_21130814_MonjeRojas> flows) {
        ArrayList<Flow_21130814_MonjeRojas> newFlows = new ArrayList<>();
        newFlows = (ArrayList<Flow_21130814_MonjeRojas>) remove_duplicates(flows);
        this.flows = flows;
    }

    //Otros
    @Override
    public ArrayList<?> remove_duplicates(ArrayList<?> flows){
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        for (Object item : flows) {
            Flow_21130814_MonjeRojas Fw = (Flow_21130814_MonjeRojas) item; //Posible Problema
            ids.add(Fw.getId());
        }
        //conseguir ids unicas
        ArrayList<Integer> ids_index = new ArrayList<>();
        Integer i = 0;
        for (Integer number : ids){
            if (!ids_index.contains(number)){
                ids_index.add(i);
            }
            else{
                ids_index.add(-1);
            }
        }
        //filtrar options
        ArrayList<Flow_21130814_MonjeRojas> newFlows = new ArrayList<>();
        for (Integer number : ids_index){
            if (!number.equals(-1)){
                newFlows.add((Flow_21130814_MonjeRojas) flows.get(number));
            }
        }
        return newFlows;
    }
}