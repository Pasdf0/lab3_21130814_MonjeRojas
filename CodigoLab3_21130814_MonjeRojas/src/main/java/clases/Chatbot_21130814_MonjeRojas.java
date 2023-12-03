package clases;

import interfaz.Duplicidad_21130814_MonjeRojas;
import java.util.ArrayList;
import java.util.Arrays;

public class Chatbot_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements Duplicidad_21130814_MonjeRojas {
    private ArrayList<Flow_21130814_MonjeRojas> flows;
    private Integer initial_fw_code;

    public void Chatbot(Integer id, String name, String msg, Integer startFwID, Flow_21130814_MonjeRojas... fws){
        this.setId(id);
        this.setName(name);
        this.setMsg(msg);
        this.setFw_code(startFwID);
        this.initial_fw_code = this.fw_code;
        ArrayList<Flow_21130814_MonjeRojas> flows = new ArrayList<> (Arrays.asList(fws));
        this.setFlows(flows);
    }

    //Getters
    public ArrayList<Flow_21130814_MonjeRojas> getFlows() {return flows;}
    public Integer getInitial_fw_code() {return initial_fw_code;}

    //Setters
    public void setFlows(ArrayList<Flow_21130814_MonjeRojas> flows) {
        ArrayList<Flow_21130814_MonjeRojas> newFlows;
        newFlows = (ArrayList<Flow_21130814_MonjeRojas>) remove_duplicates(flows);
        this.flows = newFlows;
    }
    public void resetFw_code(){
        this.fw_code = this.getInitial_fw_code();
    }

    //Otros
    public void ShowChatbot(){
        System.out.println("---------------\nChatbot");
        System.out.println(this.getId());
        System.out.println(this.getName());
        System.out.println(this.getMsg());
        System.out.println(this.getFw_code());
        System.out.println("[");
        ArrayList<Flow_21130814_MonjeRojas> chatbots = this.getFlows();
        for (Flow_21130814_MonjeRojas fw : flows){
            fw.ShowFlow();
        }
        System.out.println("]");
        System.out.println("---------------\n");
    }
    public void chatbotAddFlow(Flow_21130814_MonjeRojas Fw){
        this.add_not_dup(Fw);
    }

    @Override
    public ArrayList<?> remove_duplicates(ArrayList<?> flows){
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        for (Object item : flows) {
            Flow_21130814_MonjeRojas Fw = (Flow_21130814_MonjeRojas) item;
            ids.add(Fw.getId());
        }
        //conseguir index de ids unicas
        ArrayList<Integer> ids_index = System_21130814_MonjeRojas.getIdsIndex(ids);
        //filtrar options
        ArrayList<Flow_21130814_MonjeRojas> newFlows = new ArrayList<>();
        for (Integer number : ids_index){
            if (!number.equals(-1)){
                newFlows.add((Flow_21130814_MonjeRojas) flows.get(number));
            }
        }
        return newFlows;
    }
    @Override
    public <T> void add_not_dup(T Fw1){
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