package clases;

public class option_21130814_MonjeRojas {
    //Atributos
    private int code;
    private String msg;
    private int cb_code;
    private int fw_code;
    private StringList keywords;

    //constructor
    public option_21130814_MonjeRojas(int code, String msg, int cb_code, int fw_code, keywords)){
        this.code = code;
        this.msg = msg;
        this.cb_code = cb_code;
        this.fw_code = fw_code;
        this.keywords = keywords;
    }

    //Getters
    public int getCode() {return this.code;}
    public String getMsg() {return this.msg;}
    public int getCb_code() {return this.cb_code;}
    public int getFw_code() {return this.fw_code;}
    public ArrayList getKeywords() {return this.keywords;}

    //Setters
    public void setCode(int code) {

    }
}