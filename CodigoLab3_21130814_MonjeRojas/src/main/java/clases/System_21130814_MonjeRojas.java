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

    public System_21130814_MonjeRojas(String name, Integer cb_code, Chatbot_21130814_MonjeRojas... cbs){
        this.setName(name);
        this.date = new Date();
        this.setCb_code(cb_code);
        this.initial_cb_code = this.cb_code;
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

    //Metodos

        //Getters
    public Date getDate() {return date;}
    public User_21130814_MonjeRojas getUser() {return user;}
    public ArrayList<User_21130814_MonjeRojas> getUserList() {return userList;}
    public ArrayList<Chatbot_21130814_MonjeRojas> getChatbots() {return chatbots;}


        //Setters
    public void setUser(){
        this.user = new User_21130814_MonjeRojas();
    }
    public void setUser(User_21130814_MonjeRojas usr) {this.user = usr;}
    public void setChatbots(ArrayList<Chatbot_21130814_MonjeRojas> chatbots) {
        ArrayList<Chatbot_21130814_MonjeRojas> newChatbots;
        newChatbots = (ArrayList<Chatbot_21130814_MonjeRojas>) remove_duplicates(chatbots);
        this.chatbots = newChatbots;
    }
    public void resetSystem(){
        this.cb_code = this.initial_cb_code;
        for (Chatbot_21130814_MonjeRojas Cb: this.chatbots){
            Cb.resetFw_code();
        }
    }


        //Otros
    public void systemAddChatbot(Chatbot_21130814_MonjeRojas Cb){
        this.add_not_dup(Cb);
    }
    public void systemAddAdminUser(String name){
        AdminUser_21130814_MonjeRojas Usr = new AdminUser_21130814_MonjeRojas(name);
        if (this.findUser(name) == null){
            this.userList.add(Usr);
        }
    }
    public void systemAddCommonUser(String name){
        CommonUser_21130814_MonjeRojas Usr = new CommonUser_21130814_MonjeRojas(name);
        if (this.findUser(name) == null){
            this.userList.add(Usr);
        }
    }
    public void systemLogin(String name){
        User_21130814_MonjeRojas Usr = this.findUser(name);
        if (Usr != null){
            this.setUser(Usr);
        }
    }
    public void systemLogout(){
        if (!this.user.getName().equals("no_user")){
            this.setUser();
            this.resetSystem();
        }
    }

    public void systemTalk(String msg){
        Chatbot_21130814_MonjeRojas Cb = this.findCb(this.cb_code);
        Flow_21130814_MonjeRojas Fw = Cb.findFw(Cb.getFw_code());
        Option_21130814_MonjeRojas Op = Fw.validMsg(msg);
        this.user.storeHistory(this.getName(),this.getUser().getName(),this.getDate(),Cb,Fw,msg);
        if (Op != null){
            Chatbot_21130814_MonjeRojas Cb2 = this.findCb(Op.getCb_code());
            Flow_21130814_MonjeRojas Fw2 = Cb2.findFw(Op.getFw_code());
            Cb2.setFw_code(Op.getFw_code());
            this.setCb_code(Op.getCb_code());
        }
    }

    public void systemSynthesis(String user){
        User_21130814_MonjeRojas Usr= this.findUser(user);
        System.out.println("Synthesis para Usuario " + user + ": \n\n");
        for (String str : Usr.getChathis()){
            System.out.println(str + "\n\n");
        }
    }

    public void ShowSystem(){
        System.out.println(this.getName());
        for (Chatbot_21130814_MonjeRojas Cb : this.getChatbots()){
            Cb.ShowChatbot();
        }
    }

    public void systemState(){
        Chatbot_21130814_MonjeRojas Cb = this.findCb(this.getCb_code());
        Flow_21130814_MonjeRojas Fw = Cb.findFw(Cb.getFw_code());
        String FormattedChat = this.name + " - " + this.user.getName() + "\n" + this.date + "\n" + Cb.getName() + "\n" + Fw.getMsg() + "\n";
        String ChatTemp = "";
        for (Option_21130814_MonjeRojas Op : Fw.getOptions()){
            ChatTemp = ChatTemp + Op.getMsg() + "\n";
        }
        System.out.println(FormattedChat + ChatTemp);
    }


    public Chatbot_21130814_MonjeRojas findCb(Integer cb_code){
        for (Chatbot_21130814_MonjeRojas Cb : this.chatbots){
            if (cb_code.equals(Cb.getId())){
                return Cb;
            }
        }
        return null;
    }
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
