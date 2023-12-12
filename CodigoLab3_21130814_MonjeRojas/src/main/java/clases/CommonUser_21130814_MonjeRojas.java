package clases;

import java.util.ArrayList;

/**
 * Clase CommonUser
 * Se define como un usuario con permisos limitados
 * Hereda de {@link User_21130814_MonjeRojas}
 */
public class CommonUser_21130814_MonjeRojas extends User_21130814_MonjeRojas{
    /**
     * Constructor de CommonUser
     * Establece permissionID como 0
     * @param name nombre de usuario
     */
    public CommonUser_21130814_MonjeRojas(String name){
        this.permissionId = 0;
        this.setName(name);
        this.chathis = new ArrayList<>();
    }
}