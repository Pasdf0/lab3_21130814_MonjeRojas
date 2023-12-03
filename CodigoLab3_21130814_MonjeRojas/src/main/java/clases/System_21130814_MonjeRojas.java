package clases;

import interfaz.Duplicidad_21130814_MonjeRojas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class System_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements Duplicidad_21130814_MonjeRojas {
    private Date date;
    private User_21130814_MonjeRojas user;
    private ArrayList<User_21130814_MonjeRojas> userList;
    private ArrayList<Chatbot_21130814_MonjeRojas> chatbots;
    private Integer initial_cb_code;

    public void System(String name, Integer cb_code, Chatbot_21130814_MonjeRojas... cbs){
        this.setName(name);
        this.date = new Date();
        this.setCb_code(cb_code);
        this.initial_cb_code = this.cb_code;
        this.user = new User_21130814_MonjeRojas();
        user.User();
        this.userList = new ArrayList<User_21130814_MonjeRojas> ();
        ArrayList<Chatbot_21130814_MonjeRojas> chatbots = new ArrayList<> (Arrays.asList(cbs));
        this.setChatbots(chatbots);
    }

    //Metodos

        //Getters
    public Date getDate() {return date;}
    public User_21130814_MonjeRojas getUser() {return user;}
    public ArrayList<User_21130814_MonjeRojas> getUserList() {return userList;}
    public ArrayList<Chatbot_21130814_MonjeRojas> getChatbots() {return chatbots;}

        //Setters
    public void setUser(String name) {this.user.setName(name);}
    public void setChatbots(ArrayList<Chatbot_21130814_MonjeRojas> chatbots) {
        ArrayList<Chatbot_21130814_MonjeRojas> newChatbots;
        newChatbots = (ArrayList<Chatbot_21130814_MonjeRojas>) remove_duplicates(chatbots);
        this.chatbots = newChatbots;
    }
    public void reset_cb_code(){
        this.cb_code = this.initial_cb_code;
    }

        //Otros
    public void ShowSystem(){
        System.out.println("--------------------\nSystem");
        System.out.println(this.getName());
        System.out.println(this.getDate());
        System.out.println(this.getCb_code());
        System.out.println(this.getUser());
        System.out.println(this.getUserList());
        System.out.println("[");
        ArrayList<Chatbot_21130814_MonjeRojas> chatbots = this.getChatbots();
        for (Chatbot_21130814_MonjeRojas cb : chatbots){
            cb.ShowChatbot();
        }
        System.out.println("]");
        System.out.println("--------------------\n");
    }
    public void systemAddChatbot(Chatbot_21130814_MonjeRojas Cb){
        this.add_not_dup(Cb);
    }

    @Override
    public ArrayList<?> remove_duplicates(ArrayList<?> chatbots){
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
    @Override
    public <T> void add_not_dup(T Cb1){
        Chatbot_21130814_MonjeRojas Cb = (Chatbot_21130814_MonjeRojas) Cb1;
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        ArrayList<Chatbot_21130814_MonjeRojas> chatbots = this.getChatbots();
        for (Chatbot_21130814_MonjeRojas item : chatbots) {
            ids.add(item.getId());
        }
        if (!ids.contains(Cb.getId())){
            this.chatbots.add(Cb);
        }
    }
}
