package clases;

import java.util.ArrayList;

/**
 * Clase AdminUser
 * Se define como User con permisos de alto nivel
 * Hereda de {@link User_21130814_MonjeRojas}
 */
public class AdminUser_21130814_MonjeRojas extends User_21130814_MonjeRojas{
    /**
     * Constructor de AdminUser
     * Establece el permissionId a 1
     * @param name nombre de usuario
     */
    public AdminUser_21130814_MonjeRojas(String name){
        this.permissionId = 1;
        this.setName(name);
        this.chathis = new ArrayList<>();
    }
}
