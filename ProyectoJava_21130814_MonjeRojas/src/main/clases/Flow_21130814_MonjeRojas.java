package clases;

import Interfaces.Interface_21130814_MonjeRojas;

public class Flow_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements Interface_21130814_MonjeRojas{
    private ArrayList<Option> options;

    public Flow(int id, String msg, ArrayList<Option> options){
        this.setId(id);
        this.setMsg(msg);
        this.setOptions(options);
    }

    //Metodos

        //Getters
    public ArrayList<Option> getOptions() {return options;}

        //Setters
    public void setOptions(ArrayList<Option> options) {this.options = options;}

        //Otros
    public ArrayList<int> getAllIds(ArrayList<Option> options){
        ArrayList<int> ids = new ArrayList<int> ();
        for (Option option : options) {
            ids.add(option.getId());
        }
    }
}