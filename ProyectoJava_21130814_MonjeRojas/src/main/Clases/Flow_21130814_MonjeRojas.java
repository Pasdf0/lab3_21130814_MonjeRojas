package clases;

public class Flow_21130814_MonjeRojas {
    private int fw_code;
    private String msg;
    private ArrayList<Option> options;

    public Flow_21130814_MonjeRojas(int fw_code, String msg, ArrayList<Option> options){
        this.fw_code = fw_code;
        this.msg = msg;
        this.options = options;
    }

    //Getters
    public int getFw_code() {return fw_code;}
    public String getMsg() {return msg;}
    public ArrayList<Option> getOptions() {return options;}

    //Setters
    public void setFw_code(int fw_code) {this.fw_code = fw_code;}
    public void setMsg(String msg) {this.msg = msg;}
    public void setOptions(ArrayList<Option> options) {this.options = options;}
}