/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package genericos1;

/**
 *
 * @author JMart
 * @param <T>
 */
public interface ColeccionSimpleGenerica <T> {
    boolean estaVacia();
    T extraer();
    T primer();
    void aniadir (T e);
}
