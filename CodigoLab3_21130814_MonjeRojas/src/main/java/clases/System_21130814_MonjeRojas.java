package clases;

import interfaz.Interface_21130814_MonjeRojas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class System_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas implements Interface_21130814_MonjeRojas {
    private Date date;
    private User_21130814_MonjeRojas user;
    private ArrayList<User_21130814_MonjeRojas> userList;
    private ArrayList<Chatbot_21130814_MonjeRojas> chatbots;

    public void System(String name, Integer cb_code, Chatbot_21130814_MonjeRojas... cbs){
        this.setName(name);
        this.date = new Date();
        this.setCb_code(cb_code);
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
    public void setUser(String name) {
        this.user.setName(name);
    }
    public void setChatbots(ArrayList<Chatbot_21130814_MonjeRojas> chatbots) {
        ArrayList<Chatbot_21130814_MonjeRojas> newChatbots = new ArrayList<>();
        newChatbots = (ArrayList<Chatbot_21130814_MonjeRojas>) remove_duplicates(chatbots);
        this.chatbots = newChatbots;
    }

        //Otros
    @Override
    public ArrayList<?> remove_duplicates(ArrayList<?> chatbots){
        //Conseguir ids
        ArrayList<Integer> ids = new ArrayList<> ();
        for (Object item : chatbots) {
            Chatbot_21130814_MonjeRojas Fw = (Chatbot_21130814_MonjeRojas) item;
            ids.add(Fw.getId());
        }
        //conseguir indexes de ids unicas
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
        //filtrar chatbots
        ArrayList<Chatbot_21130814_MonjeRojas> newChatbots = new ArrayList<>();
        for (Integer number : ids_index){
            if (!number.equals(-1)){
                newChatbots.add((Chatbot_21130814_MonjeRojas) chatbots.get(number));
            }
        }
        return newChatbots;
    }
}
