package clases;

import java.util.ArrayList;
import java.util.Arrays;

public class Option_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas{
    //Atributos
    private ArrayList<String> keywords;

    //constructor
    public Option_21130814_MonjeRojas(Integer id, String msg, Integer cb_code, Integer fw_code, String... strings){
        this.setId(id);
        this.setMsg(msg);
        this.setCb_code(cb_code);
        this.setFw_code(fw_code);
        if (strings != null) {
            ArrayList<String> keywords = new ArrayList<>(Arrays.asList(strings));
            this.setKeywords(keywords);
        }
        else{
            this.keywords = new ArrayList<>();
        }
    }

    //Metodos

    //Getters
    public ArrayList<String> getKeywords() {return this.keywords;}

    //Setters
    public void setKeywords(ArrayList<String> keywords) {
        keywords.replaceAll(String::toLowerCase);
        this.keywords = keywords;
    }

    //Otros
    /* Sin uso por el momento
    public void clone(Option_21130814_MonjeRojas Op){
        this.id = Op.getId();
        this.msg = Op.getMsg();
        this.cb_code = Op.getCb_code();
        this.fw_code = Op.getFw_code();
        this.keywords = Op.getKeywords();
    }*/
    public void ShowOption(){
        System.out.println("-----\nOption");
        System.out.println("            " + this.getMsg());
        System.out.println("            " + this.getKeywords());
        System.out.println("-----");
    }
}
