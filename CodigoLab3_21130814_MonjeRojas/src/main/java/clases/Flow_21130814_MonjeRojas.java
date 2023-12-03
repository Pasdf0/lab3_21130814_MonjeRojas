package clases;

import interfaz.Interface_21130814_MonjeRojas;
import java.util.ArrayList;
import java.util.Arrays;

public class Flow_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements Interface_21130814_MonjeRojas{
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
        ArrayList<Option_21130814_MonjeRojas> newOptions = new ArrayList<>();
        newOptions = (ArrayList<Option_21130814_MonjeRojas>) remove_duplicates(options);
        this.options = newOptions;
    }

    //Otros
    public void ShowFlow(){
        System.out.println("\n\nFlow");
        System.out.println(this.getId());
        System.out.println(this.getMsg());
        System.out.println(this.getOptions());
    }
    @Override
    public ArrayList<?> remove_duplicates(ArrayList<?> options){
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        for (Object item : options) {
            Option_21130814_MonjeRojas Op = (Option_21130814_MonjeRojas) item;
            ids.add(Op.getId());
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
        ArrayList<Option_21130814_MonjeRojas> newOptions = new ArrayList<>();
        for (Integer number : ids_index){
            if (!number.equals(-1)){
                newOptions.add((Option_21130814_MonjeRojas) options.get(number));
            }
        }
        return newOptions;
    }
}
