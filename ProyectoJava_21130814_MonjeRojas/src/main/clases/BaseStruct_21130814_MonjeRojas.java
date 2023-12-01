package clases;

public abstract class BaseStruct_21130814_MonjeRojas{
    protected int id;
    protected String name;
    protected String msg;
    protected int cb_code;
    protected int fw_code;

    //Getters
    public int getId() {return id;}
    public String getName() {return name;}
    public String getMsg() {return msg;}
    public int getCb_code() {return cb_code;}
    public int getFw_code() {return fw_code;}

    //Setters
    public void setId(int id) {
        if (id >= 0)
            this.id = id;
    }
    public void setName(String name) {
        if (!name.equals(""))
            this.name = name;
    }
    public void setMsg(String msg) {
        if (!msg.equals(""))
            this.msg = msg;
    }
    public void setCb_code(int cb_code) {
        if (cb_code >= 0)
            this.cb_code = cb_code;
    }
    public void setFw_code(int fw_code) {
        if (fw_code >= 0)
            this.fw_code = fw_code;
    }
}