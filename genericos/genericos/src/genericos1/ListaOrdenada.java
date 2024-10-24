/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genericos1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author JMart
 * @param <E>
 */
public class ListaOrdenada <E extends Comparable<E>> {
    List<E> lista;
    public ListaOrdenada() {
        lista = new LinkedList<>();
        
    }
    public void adiciona(E e) {
        lista.add(e);
        lista.sort(null);
    }
    public E remove() {
        return lista.remove(0);
    }
}
