package clases;

import interfaz.Duplicidad_21130814_MonjeRojas;

import java.util.ArrayList;
import java.util.Arrays;

public class Flow_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements Duplicidad_21130814_MonjeRojas {
    private ArrayList<Option_21130814_MonjeRojas> options;

    public void Flow(Integer id, String msg, Option_21130814_MonjeRojas... ops){
        this.setId(id);
        this.setMsg(msg);
        ArrayList<Option_21130814_MonjeRojas> options = new ArrayList<> (Arrays.asList(ops));
        this.setOptions(options);
    }

    //Metodos

        //Getters
    public ArrayList<Option_21130814_MonjeRojas> getOptions() {return options;}

        //Setters
    public void setOptions(ArrayList<Option_21130814_MonjeRojas> options) {
        ArrayList<Option_21130814_MonjeRojas> newOptions;
        newOptions = (ArrayList<Option_21130814_MonjeRojas>) remove_duplicates(options);
        this.options = newOptions;
    }

        //Otros
    public void ShowFlow(){
        System.out.println("----------\nFlow");
        System.out.println(this.getId());
        System.out.println(this.getMsg());
        System.out.println("[");
        ArrayList<Option_21130814_MonjeRojas> options = this.getOptions();
        for (Option_21130814_MonjeRojas op : options){
            op.ShowOption();
        }
        System.out.println("]");
        System.out.println("----------\n");
    }
    public void flowAddOption(Option_21130814_MonjeRojas Op){
        this.add_not_dup(Op);
    }

    @Override
    public ArrayList<?> remove_duplicates(ArrayList<?> options){
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        for (Object item : options) {
            Option_21130814_MonjeRojas Op = (Option_21130814_MonjeRojas) item;
            ids.add(Op.getId());
        }
        //conseguir index de ids unicas
        ArrayList<Integer> ids_index = System_21130814_MonjeRojas.getIdsIndex(ids);
        //filtrar options
        ArrayList<Option_21130814_MonjeRojas> newOptions = new ArrayList<>();
        for (Integer number : ids_index){
            if (!number.equals(-1)){
                newOptions.add((Option_21130814_MonjeRojas) options.get(number));
            }
        }
        return newOptions;
    }
    @Override
    public <T> void add_not_dup(T Op1){
        Option_21130814_MonjeRojas Op = (Option_21130814_MonjeRojas) Op1;
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        ArrayList<Option_21130814_MonjeRojas> options = this.getOptions();
        for (Option_21130814_MonjeRojas item : options) {
            ids.add(item.getId());
        }
        if (!ids.contains(Op.getId())){
            this.options.add(Op);
        }
    }
}
