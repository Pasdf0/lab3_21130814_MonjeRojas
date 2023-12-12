package clases;

import java.util.Scanner;

/**
 * Clase UserSystem
 * consiste en un system normal que posee un dueño,
 * se utiliza como especialización de system en contexto de menu.
 * Hereda de {@link System_21130814_MonjeRojas}
 */
public class UserSystem_21130814_MonjeRojas extends System_21130814_MonjeRojas {
    //Atributos
    /**
     * Dueño del system creado, limita el acceso a otras personas
     */
    private AdminUser_21130814_MonjeRojas owner;

    /**
     * Constructor de UserSystem
     * Llama al constructor de System
     * @param name nombre del system
     * @param cb_code Id de Chatbot inicial
     */
    public UserSystem_21130814_MonjeRojas(String name, Integer cb_code) {
        super(name, cb_code);
    }

    /**
     * Permite acceder al owner de un UserSystem
     * @return Usuario dueño del UserSystem
     */
    public AdminUser_21130814_MonjeRojas getOwner() {return owner;}

    /**
     * Crea un UserSystem preguntando datos por consola
     * @param Usr Usuario dueño del nuevo system
     * @return UserSystem construido y con dueño asignado
     */
    public static UserSystem_21130814_MonjeRojas createSystem(AdminUser_21130814_MonjeRojas Usr){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n###### Creacion de System ######");
        System.out.print("\n# Ingrese el nombre de su sistema: ");
        String name = sc.nextLine();
        System.out.print("# Ingrese la id del chatbot inicial de su sistema: ");
        Integer cb_code = sc.nextInt();
        sc.nextLine();
        UserSystem_21130814_MonjeRojas newSys = new UserSystem_21130814_MonjeRojas(name,cb_code);
        newSys.owner = Usr;
        newSys.systemAddAdminUser(Usr.getName());
        newSys.systemLogin(Usr.getName());
        System.out.println("\n##### Gracias por crear tu System #####");
        return newSys;
    }
}
