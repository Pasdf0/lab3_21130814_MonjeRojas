package clases;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase User
 * Se define como un usuario cualquiera
 * es instanciable como usuario vacío
 */
public class User_21130814_MonjeRojas{
    /**
     * Id de permiso, para User es null
     */
    protected Integer permissionId;
    /**
     * Nombre de Usuario
     */
    protected String name;
    /**
     * Lista de Chat History
     */
    protected ArrayList<String> chathis;

    /**
     * Constructor de User
     */
    public User_21130814_MonjeRojas(){
        this.name = "no_user";
        this.chathis = new ArrayList<> ();
    }

        //Getters

    /**
     * Consigue el Id de permiso
     * @return atributo id de permiso
     */
    public Integer getPermissionId() {return permissionId;}

    /**
     * Consigue el nombre del User
     * @return nombre de usuario
     */
    public String getName() {return name;}

    /**
     * Consigue el historial de Chat del User
     * @return historial de chat
     */
    public ArrayList<String> getChathis() {return chathis;}

    //Setters

    /**
     * Asigna el nombre de usuario
     * @param name nombre de usuario
     */
    public void setName(String name) {
        if (!name.equals("")){
            this.name = name;
        }
    }

    /**
     * Permite borrar el historial
     * Se utiliza principalmente para no mezclar registros diferentes
     */
    public void deleteHistory(){
        this.chathis = new ArrayList<>();
    }

    /**
     * Método que permite crear un String formateado para print que contenga una interacción
     * @param name nombre del system interactuado
     * @param user nombre del usuario
     * @param date fecha del system
     * @param Cb Chatbot con el que se interactuó
     * @param Fw Flow con el que se interactuó
     * @param msg mensaje de interacción
     */
    public void storeHistory(String name, String user, Date date, Chatbot_21130814_MonjeRojas Cb, Flow_21130814_MonjeRojas Fw, String msg){
        String FormattedChat = name + " - " + user + "\n" + date + "\n" + Cb.getName() + "\n" + Fw.getMsg() + "\n";
        String ChatTemp = "";
        for (Option_21130814_MonjeRojas Op : Fw.getOptions()){
            ChatTemp = ChatTemp + Op.getMsg() + "\n";
        }
        FormattedChat = FormattedChat + ChatTemp + "\nRespuesta: " + msg;
        this.chathis.add(FormattedChat);
    }
}
