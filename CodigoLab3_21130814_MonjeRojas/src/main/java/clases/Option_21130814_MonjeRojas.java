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
    public void ShowOption(){
        System.out.println("##          Option (id: " + this.getId() + ")");
        System.out.println("##          Mensaje: " + this.getMsg());
        if (this.getKeywords().isEmpty()){
            System.out.println("##          Keywords: []");
        }
        else {
            System.out.println("##          Keywords: " + this.getKeywords());
        }
    }
}
