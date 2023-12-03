package clases;

public class BaseStruct_21130814_MonjeRojas {
    protected Integer id;
    protected String name;
    protected String msg;
    protected Integer cb_code;
    protected Integer fw_code;

    //Getters
    public Integer getId() {return id;}
    public String getName() {return name;}
    public String getMsg() {return msg;}
    public Integer getCb_code() {return cb_code;}
    public Integer getFw_code() {return fw_code;}

    //Setters
    public void setId(Integer id) {
        if (id >= 0) {
            this.id = id;
        }
    }
    public void setName(String name) {
        if (!name.equals("")) {
            this.name = name;
        }
    }
    public void setMsg(String msg) {
        if (!msg.equals("")) {
            this.msg = msg;
        }
    }
    public void setCb_code(Integer cb_code) {
        if (cb_code >= 0) {
            this.cb_code = cb_code;
        }
    }
    public void setFw_code(Integer fw_code) {
        if (fw_code >= 0) {
            this.fw_code = fw_code;
        }
    }
}
