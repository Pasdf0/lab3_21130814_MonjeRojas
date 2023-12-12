package clases;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase Option
 * es una opcion que puede ser elegida con palabras clave
 * Hereda de {@link BaseStruct_21130814_MonjeRojas}
 */
public class Option_21130814_MonjeRojas extends BaseStruct_21130814_MonjeRojas{
    //Atributos
    /**
     * Lista que almacena las palabras claves que son aceptadas como respuesta
     */
    private ArrayList<String> keywords;

    //Metodos

    /**
     * Constructor de Option
     * @param id identificados único de un Option
     * @param msg mensaje del Option
     * @param cb_code id del Chatbot al que dirige el Option
     * @param fw_code id del flow perteneciente al chatbot al que dirige el Option
     * @param strings conjunto de palabras claves
     */
    public Option_21130814_MonjeRojas(Integer id, String msg, Integer cb_code, Integer fw_code, String... strings){
        this.setId(id);
        this.setMsg(msg);
        this.setCbCode(cb_code);
        this.setFwCode(fw_code);
        if (strings != null) {
            ArrayList<String> keywords = new ArrayList<>(Arrays.asList(strings));
            this.setKeywords(keywords);
        }
        else{
            this.keywords = new ArrayList<>();
        }
    }

    //Getters

    /**
     * Consigue la lista de palabras clave
     * @return Lista de keywords
     */
    public ArrayList<String> getKeywords() {return this.keywords;}

    //Setters

    /**
     * Establece las keywords cambiandolas a lowerCase
     * @param keywords Lista de palabras claves
     */
    public void setKeywords(ArrayList<String> keywords) {
        keywords.replaceAll(String::toLowerCase);
        this.keywords = keywords;
    }

    /**
     * Muestra un Option por consola
     */
    public void showOption(){
        System.out.println("##        Option (id: " + this.getId() + ")");
        System.out.println("##            Mensaje: " + this.getMsg());
        if (this.getKeywords().isEmpty()){
            System.out.println("##            Keywords: []");
        }
        else {
            System.out.println("##            Keywords: " + this.getKeywords());
        }
    }
}
