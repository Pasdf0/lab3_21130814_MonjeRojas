package interfaz;

import clases.Flow_21130814_MonjeRojas;
import clases.Chatbot_21130814_MonjeRojas;
import clases.System_21130814_MonjeRojas;

import java.util.ArrayList;

/**
 * Interfaz que define metodos para eliminar duplicados
 * se usa en:
 * {@link System_21130814_MonjeRojas},
 * {@link Chatbot_21130814_MonjeRojas} y
 * {@link Flow_21130814_MonjeRojas}
 */
public interface IDuplicidad_21130814_MonjeRojas {
    /**
     * elimina duplicados en una lista
     * @param list lista de elementos
     * @return lista sin duplicados
     */
    ArrayList<?> removeDuplicates(ArrayList<?> list);

    /**
     * añade elemento no duplicado
     * @param elem elemento a añadir
     * @param <T> Tipo de dato a añadir
     */
    <T> void addNotDup(T elem);
}