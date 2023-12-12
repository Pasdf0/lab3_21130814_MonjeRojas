package clases;

import interfaz.IDuplicidad_21130814_MonjeRojas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import static java.lang.Math.abs;

/**
 * Clase System
 * Contiene los metodos para interactuar con un system
 * además de tener la capacidad de poseer chatbots
 * Hereda de {@link BaseStruct_21130814_MonjeRojas}
 */
public class System_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements IDuplicidad_21130814_MonjeRojas {
    /**
     * Date registra la fecha de creacion de la instancia de un system
     */
    private final Date date;
    /**
     * user almacena el usuario con sesion activa en el momento, se inicializa en estado no_user
     */
    private User_21130814_MonjeRojas user;
    /**
     * userList almacena todos los usuarios registrados en el sistema.
     */
    private ArrayList<User_21130814_MonjeRojas> userList;
    /**
     * chatbots contiene todos los chatbots creados o agregados al system, puede estar vacio.
     */
    private ArrayList<Chatbot_21130814_MonjeRojas> chatbots;
    /**
     * initialCbCode almacena el Chatbot code con el que se creó el system
     * sirve para regresar a este a su estado original y poder volver a ser usado.
     */
    private final Integer initialCbCode;

    //Metodos
    /**
     * Constructor de System
     * @param name corresponde al nombre del system
     * @param cb_code corresponde al id de su chatbot actual
     * @param cbs corresponde a una lista de chatbots que se deban agregar al system
     */
    public System_21130814_MonjeRojas(String name, Integer cb_code, Chatbot_21130814_MonjeRojas... cbs){
        this.setName(name);
        this.date = new Date();
        this.setCbCode(cb_code);
        this.initialCbCode = this.cbCode;
        this.setUser();
        this.userList = new ArrayList<> ();
        if (cbs != null) {
            ArrayList<Chatbot_21130814_MonjeRojas> chatbots = new ArrayList<>(Arrays.asList(cbs));
            this.setChatbots(chatbots);
        }
        else{
            this.chatbots = new ArrayList<>();
        }
    }

        //Getters

    /**
     * Consigue la fecha del system actual
     * @return fecha tipo Date
     */
    public Date getDate() {return date;}

    /**
     * Consigue el usuario activo actual
     * @return usuario tipo User
     */
    public User_21130814_MonjeRojas getUser() {return user;}

    /**
     * Consigue la lista de chatbots del system actual
     * @return lista de chatbots añadidos
     */
    public ArrayList<Chatbot_21130814_MonjeRojas> getChatbots() {return chatbots;}


        //Setters

    /**
     * Establece el usuario actual como no_user
     */
    private void setUser(){
        this.user = new User_21130814_MonjeRojas();
    }

    /**
     * Establece el usuario actual
     * @param usr recibe un usuario ya instanciado
     */
    private void setUser(User_21130814_MonjeRojas usr) {this.user = usr;}

    /**
     * Establece la lista de chatbots eliminando duplicados
     * @param chatbots lista de chatbots, puede tener duplicados
     */
    private void setChatbots(ArrayList<Chatbot_21130814_MonjeRojas> chatbots) {
        if (!chatbots.isEmpty()){
            ArrayList<Chatbot_21130814_MonjeRojas> newChatbots;
            newChatbots = (ArrayList<Chatbot_21130814_MonjeRojas>) removeDuplicates(chatbots);
            this.chatbots = newChatbots;
        }
        else{
            this.chatbots = chatbots;
        }
    }

        //Otros

    /**
     * Permite devolver a un system a su estado original de creación
     */
    public void resetSystem(){
        this.cbCode = this.initialCbCode;
        for (Chatbot_21130814_MonjeRojas Cb: this.chatbots){
            Cb.resetFwCode();
        }
    }

    /**
     * Permite añadir un chatbot a un system verificando que no sea duplicado
     * @param Cb chatbot ya instanciado
     */
    public void systemAddChatbot(Chatbot_21130814_MonjeRojas Cb){
        this.addNotDup(Cb);
    }

    /**
     * Permite instanciar y añadir un Usuario administrador al sistema
     * @param name nombre de usuario (identificador único)
     */
    public void systemAddAdminUser(String name){
        AdminUser_21130814_MonjeRojas Usr = new AdminUser_21130814_MonjeRojas(name);
        if (this.findUser(name) == null){
            this.userList.add(Usr);
        }
    }

    /**
     * Permite instanciar y añadir un Usuario común al sistema
     * @param name nombre de usuario (identificador único)
     */
    public void systemAddCommonUser(String name){
        CommonUser_21130814_MonjeRojas Usr = new CommonUser_21130814_MonjeRojas(name);
        if (this.findUser(name) == null){
            this.userList.add(Usr);
        }
    }

    /**
     * Busca un usuario en el system y la asigna como sesión activa
     * @param name nombre de usuario
     */
    public void systemLogin(String name){
        User_21130814_MonjeRojas Usr = this.findUser(name);
        if (Usr != null){
            this.setUser(Usr);
        }
    }

    /**
     * Actualiza la sesión activa a no_user para cerrar sesión
     */
    public void systemLogout(){
        if (!this.user.getName().equals("no_user")){
            this.setUser();
            this.resetSystem();
        }
    }

    /**
     * Permite interactuar con el system, con un mensaje, modifica al siguiente estado
     * dependiendo de la respuesta entregada.
     * @param msg mensaje de interacción, puede ser un número o palabras
     */
    public void systemTalk(String msg){
        Chatbot_21130814_MonjeRojas Cb = this.findCb(this.cbCode);
        Flow_21130814_MonjeRojas Fw = Cb.findFw(Cb.getFwCode());
        Option_21130814_MonjeRojas Op = Fw.validMsg(msg);
        this.user.storeHistory(this.getName(),this.getUser().getName(),this.getDate(),Cb,Fw,msg);
        if (Op != null){
            Chatbot_21130814_MonjeRojas Cb2 = this.findCb(Op.getCbCode());
            Cb2.setFwCode(Op.getFwCode());
            this.setCbCode(Op.getCbCode());
        }
    }

    /**
     * Realiza una síntesis del historial almacenado en el usuario deseado
     * @param user nombre del usuario del que se requiera la síntesis
     */
    public void systemSynthesis(String user){
        User_21130814_MonjeRojas Usr= this.findUser(user);
        System.out.println("Synthesis para Usuario " + user + ": \n\n");
        for (String str : Usr.getChathis()){
            System.out.println(str + "\n\n");
        }
    }

    /**
     * simula una cantidad de interacciones a través de números pseudo-aleatorios
     * @param maxInt cantidad de interacciones solicitadas
     * @param seed semilla de la que se generan las respuestas
     */
    public void systemSimulate(Integer maxInt, Integer seed){
        Random random = new Random(seed);
        while (maxInt > 0){
            Integer newSeed = abs(random.nextInt());
            Chatbot_21130814_MonjeRojas Cb = this.findCb(this.getCbCode());
            Integer length = Cb.findFw(Cb.getFwCode()).getOptions().size();
            int answer = (newSeed % length) + 1;
            String res = Integer.toString(answer);
            this.systemTalk(res);
            maxInt--;
        }
        this.resetSystem();
    }

    /**
     * Muestra el system completo, mostrando cada chatbot, flow y option
     */
    public void showSystem(){
        System.out.println("\n");
        System.out.println("## " + this.getName());
        if (this.getChatbots().isEmpty()){
            System.out.println("## [No_Chatbots]");
        }
        else {
            for (Chatbot_21130814_MonjeRojas Cb : this.getChatbots()) {
                Cb.showChatbot();
            }
        }
    }

    /**
     * Muestra el estado actual del system
     */
    public void systemState(){
        Chatbot_21130814_MonjeRojas Cb = this.findCb(this.getCbCode());
        Flow_21130814_MonjeRojas Fw = Cb.findFw(Cb.getFwCode());
        String FormattedChat = this.name + " - " + this.user.getName() + "\n" + this.date + "\n" + Cb.getName() + "\n" + Fw.getMsg() + "\n";
        String ChatTemp = "";
        for (Option_21130814_MonjeRojas Op : Fw.getOptions()){
            ChatTemp = ChatTemp + Op.getMsg() + "\n";
        }
        System.out.println(FormattedChat + ChatTemp);
    }

    /**
     * Permite encontrar un Chatbot almacenado en el system a partir de su id
     * @param cb_code id del chatbot que se desea encontrar
     * @return null si no se encuentra, caso contrario el propio chatbot
     */
    public Chatbot_21130814_MonjeRojas findCb(Integer cb_code){
        for (Chatbot_21130814_MonjeRojas Cb : this.chatbots){
            if (cb_code.equals(Cb.getId())){
                return Cb;
            }
        }
        return null;
    }

    /**
     * Permite encontrar un User almacenado en el system a partir de su nombre
     * @param name nombre de usuario
     * @return null si no se encuentra, caso contrario el propio User
     */
    public User_21130814_MonjeRojas findUser(String name){
        if (this.user.getName().equalsIgnoreCase(name)){
            return this.getUser();
        }
        for (User_21130814_MonjeRojas userTemp : this.userList){
            if (name.equalsIgnoreCase(userTemp.getName())){
                return userTemp;
            }
        }
        return null;
    }

    /**
     * Permite escoger un chatbot de los que posee un system,
     * se pregunta por consola
     * @return chatbot seleccionado o null si hubo error en el ingreso
     */
    public Chatbot_21130814_MonjeRojas chooseChatbot(){
        if (this.getChatbots().isEmpty()){
            System.out.println("\n-Este System no posee Chatbots-");
            return null;
        }
        else {
            System.out.println("Lista de sus Chatbots: ");
            System.out.println("-Para seleccionar ingresar la id-");
            Scanner sc = new Scanner(System.in);
            for (Chatbot_21130814_MonjeRojas Cb : this.getChatbots()) {
                System.out.println("(id: " + Cb.getId() + ") " + Cb.getName());
            }
            System.out.print("\nRespuesta: ");
            Integer index = sc.nextInt();
            sc.nextLine();
            return this.findCb(index);
        }
    }

    /**
     * Implementación de {@link IDuplicidad_21130814_MonjeRojas}
     * elimina chatbots duplicados por Id
     * @param chatbots lista de chatbots
     * @return lista de entrada sin elementos duplicados
     */
    @Override
    public ArrayList<?> removeDuplicates(ArrayList<?> chatbots){
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        for (Object item : chatbots) {
            Chatbot_21130814_MonjeRojas Fw = (Chatbot_21130814_MonjeRojas) item;
            ids.add(Fw.getId());
        }
        //conseguir indexes de ids unicas
        ArrayList<Integer> ids_index = getIdsIndex(ids);
        //filtrar chatbots
        ArrayList<Chatbot_21130814_MonjeRojas> newChatbots = new ArrayList<>();
        for (Integer number : ids_index){
            if (!number.equals(-1)){
                newChatbots.add((Chatbot_21130814_MonjeRojas) chatbots.get(number));
            }
        }
        return newChatbots;
    }

    /**
     * Implementación de {@link IDuplicidad_21130814_MonjeRojas}
     * permite añadir un chatbot verificando duplicidad
     * @param Cb1 Chatbot de entrada, sobre el que se opera
     * @param <T> parametrización para realizar implementación correctamente
     */
    @Override
    public <T> void addNotDup(T Cb1){
        Chatbot_21130814_MonjeRojas Cb = (Chatbot_21130814_MonjeRojas) Cb1;
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        for (Chatbot_21130814_MonjeRojas item : this.getChatbots()) {
            ids.add(item.getId());
        }
        if (!ids.contains(Cb.getId())){
            this.chatbots.add(Cb);
        }
    }
}