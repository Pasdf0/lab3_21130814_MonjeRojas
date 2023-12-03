package clases;

import java.util.ArrayList;
import java.util.Arrays;

public class Option_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas{
    //Atributos
    private ArrayList<String> keywords;

    //constructor
    public void Option(Integer id, String msg, Integer cb_code, Integer fw_code, String... strings){
        this.setId(id);
        this.setMsg(msg);
        this.setCb_code(cb_code);
        this.setFw_code(fw_code);
        ArrayList<String> keywords = new ArrayList<> (Arrays.asList(strings));
        this.setKeywords(keywords);
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
    public void ShowOption(){
        System.out.println("\n\nOption");
        System.out.println(this.getId());
        System.out.println(this.getMsg());
        System.out.println(this.getCb_code());
        System.out.println(this.getFw_code());
        System.out.println(this.getKeywords());
    }
}
