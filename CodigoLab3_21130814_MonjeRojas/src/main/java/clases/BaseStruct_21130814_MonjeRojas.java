package clases;

import java.util.ArrayList;

/**
 * Clase abstracta BaseStruct
 * Otorga atributos básicos para Option, Flow, Chatbot y System
 * permite que las clases mencionadas sean principalmente de implementación y control
 */
public abstract class BaseStruct_21130814_MonjeRojas {
    /**
     * identificador único para chatbot, flow y option
     */
    protected Integer id;
    /**
     * nombre para chatbot y system
     */
    protected String name;
    /**
     * msg para option, flow y chatbot
     */
    protected String msg;
    /**
     * id direccional de un Chatbot, lo utilizan system y option
     */
    protected Integer cbCode;
    /**
     * id direccional de un flow, lo utilizan chatbot y option
     */
    protected Integer fwCode;

    //Getters

    /**
     * Consigue la id de un objeto
     * @return id
     */
    public Integer getId() {return id;}

    /**
     * Consigue el nombre de un objeto
     * @return nombre
     */
    public String getName() {return name;}

    /**
     * Consigue el mensaje de un objeto
     * @return mensaje
     */
    public String getMsg() {return msg;}

    /**
     * Consigue el CbCode de un objeto
     * @return id de un Chatbot
     */
    public Integer getCbCode() {return cbCode;}

    /**
     * Consigue el FwCode de un objeto
     * @return id de un Flow
     */
    public Integer getFwCode() {return fwCode;}

    //Setters

    /**
     * Establece la id de un objeto
     * verifica que sea mayor o igual a 0
     * @param id identificador
     */
    public void setId(Integer id) {
        if (id >= 0) {
            this.id = id;
        }
    }

    /**
     * Establece el nombre de un objeto
     * verificando que no esté vacío
     * @param name nombre
     */
    public void setName(String name) {
        if (!name.equals("")) {
            this.name = name;
        }
    }

    /**
     * Establece el mensaje de un objeto
     * verificando que no esté vacío
     * @param msg mensaje
     */
    public void setMsg(String msg) {
        if (!msg.equals("")) {
            this.msg = msg;
        }
    }

    /**
     * Establece el CbCode de un objeto
     * verifica que sea mayor o igual a 0
     * @param cbCode id de un Chatbot
     */
    public void setCbCode(Integer cbCode) {
        if (cbCode >= 0) {
            this.cbCode = cbCode;
        }
    }

    /**
     * Establece el FwCode de un objeto
     * verifica que sea mayor o igual a 0
     * @param fwCode id de un Flow
     */
    public void setFwCode(Integer fwCode) {
        if (fwCode >= 0) {
            this.fwCode = fwCode;
        }
    }

    /**
     * Método que en base a una lista de ids crea una lista que deja la id
     * sin modificar en caso de ser la primera aparición o deja un -1 en su posición
     * en caso contrario.
     * Se dejó de esta forma por comodidad
     * @param ids Lista de ids
     * @return Lista de ids con identificador para duplicidad
     */
    public static ArrayList<Integer> getIdsIndex(ArrayList<Integer> ids) {
        var ids_aux = new ArrayList<Integer>();
        ArrayList<Integer> ids_index = new ArrayList<>();
        Integer i = 0;
        for (Integer number : ids){
            if (!ids_aux.contains(number)){
                ids_index.add(i);
                ids_aux.add(number);
            }
            else{
                ids_index.add(-1);
            }
            i++;
        }
        return ids_index;
    }
}
