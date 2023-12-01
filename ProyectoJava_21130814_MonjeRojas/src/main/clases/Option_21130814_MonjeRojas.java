package clases;

public class Option_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas{
    //Atributos
    private ArrayList<String> keywords;

    //constructor
    public Option(int id, String msg, int cb_code, int fw_code, ArrayList<String> keywords){
        this.setId(id);
        this.setMsg(msg);
        this.setCb_code(cb_code);
        this.setFw_code(fw_code);
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
}