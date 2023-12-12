package clases;

import interfaz.IDuplicidad_21130814_MonjeRojas;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase Flow
 * Un flow contiene un mensaje y un conjunto de opciones
 * Hereda de {@link BaseStruct_21130814_MonjeRojas}
 */
public class Flow_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements IDuplicidad_21130814_MonjeRojas {
    /**
     * Lista de Options
     */
    private ArrayList<Option_21130814_MonjeRojas> options;

    /**
     * Constructor de Flow
     * @param id identificador único de un Flow
     * @param msg mensaje del Flow
     * @param ops Lista de Options
     */
    public Flow_21130814_MonjeRojas(Integer id, String msg, Option_21130814_MonjeRojas... ops){
        this.setId(id);
        this.setMsg(msg);
        if (ops != null) {
            ArrayList<Option_21130814_MonjeRojas> options = new ArrayList<>(Arrays.asList(ops));
            this.setOptions(options);
        }
        else{
            this.options = new ArrayList<>();
        }
    }

        //Getters

    /**
     * Consigue las Options de un Flow
     * @return Lista de Options
     */
    public ArrayList<Option_21130814_MonjeRojas> getOptions() {return options;}

        //Setters

    /**
     * Establece las Options de un flow eliminando duplicados por id
     * @param options Lista de Options
     */
    public void setOptions(ArrayList<Option_21130814_MonjeRojas> options) {
        ArrayList<Option_21130814_MonjeRojas> newOptions;
        newOptions = (ArrayList<Option_21130814_MonjeRojas>) removeDuplicates(options);
        this.options = newOptions;
    }

        //Otros

    /**
     * Muestra un Flow por consola
     */
    public void showFlow(){
        System.out.println("##        Flow (id: " + this.getId() + ")");
        System.out.println("##        Mensaje: " + this.getMsg());
        if (this.getOptions().isEmpty()) {
            System.out.println("##        [No_Options]");
        }
        else {
            for (Option_21130814_MonjeRojas op : this.getOptions()) {
                op.showOption();
            }
        }
    }

    /**
     * Añade un Option al Flow si no se encuentra dentro
     * @param Op Option a añadir
     */
    public void flowAddOption(Option_21130814_MonjeRojas Op){
        this.addNotDup(Op);
    }

    /**
     * Confirma si un mensaje es aceptable como respuesta al Flow
     * @param msg mensaje de interacción
     * @return Option que acepta la respuesta, null en caso de que no haya
     */
    public Option_21130814_MonjeRojas validMsg(String msg){
        Integer msgInt;
        String msgStr = msg.toLowerCase();
        try {
            msgInt = Integer.parseInt(msg);
        } catch (NumberFormatException e){
            msgInt = null;
        }
        if (msgInt != null){
            for (Option_21130814_MonjeRojas Op : this.options){
                if (msgInt.equals(Op.getId())){
                    return Op;
                }
            }
        }
        else {
            for (Option_21130814_MonjeRojas Op : this.options){
                ArrayList<String> keywords = Op.getKeywords();
                if (keywords.contains(msgStr)){
                    return Op;
                }
            }
        }
        return null;
    }

    /**
     * Implementación de {@link IDuplicidad_21130814_MonjeRojas}
     * elimina duplicados en una lista de Options
     * @param options lista de Options
     * @return Lista de Options sin duplicados
     */
    @Override
    public ArrayList<?> removeDuplicates(ArrayList<?> options){
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        for (Object item : options) {
            Option_21130814_MonjeRojas Op = (Option_21130814_MonjeRojas) item;
            ids.add(Op.getId());
        }
        //conseguir index de ids unicas
        ArrayList<Integer> ids_index = getIdsIndex(ids);
        //filtrar options
        ArrayList<Option_21130814_MonjeRojas> newOptions = new ArrayList<>();
        for (Integer number : ids_index){
            if (!number.equals(-1)){
                newOptions.add((Option_21130814_MonjeRojas) options.get(number));
            }
        }
        return newOptions;
    }

    /**
     * Implementación de {@link IDuplicidad_21130814_MonjeRojas}
     * Añade un Option al flow en caso de no estar su id en él
     * @param Op1 elemento a añadir
     * @param <T> parametrización para realizar implementación correctamente
     */
    @Override
    public <T> void addNotDup(T Op1){
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
