package clases;

public class Chatbot_21130814_MonjeRojas{
    private int id;
    private String name;
    private String msg;
    private int startFwID;
    private ArrayList<Flow> flows;

    public Chatbot(int id, String name, String msg, int startFwID, ArrayList<Flow> flows){
        this.id = id;
        this.name = name;
        this.msg = msg;
        this.startFwID = startFwID;
        this.flows = flows;
    }

    //Getters
    public int getId() {return id;}
    public String getName() {return name;}
    public String getMsg() {return msg;}
    public int getStartFwID() {return startFwID;}
    public ArrayList<Flow> getFlows() {return flows;}

    //Setters
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setMsg(String msg) {this.msg = msg;}
    public void setStartFwID(int startFwID) {this.startFwID = startFwID;}
    public void setFlows(ArrayList<Flow> flows) {this.flows = flows;}
}