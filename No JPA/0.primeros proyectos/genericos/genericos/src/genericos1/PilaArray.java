/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package genericos1;

/**
 *
 * @author JMart
 * @param <T>
 */
public class PilaArray<T> implements ColeccionSimpleGenerica<T> {

    private T[] pila;
    private static int cont=0;

    public PilaArray() {
        this.pila = (T[]) new Object[0];
    }

        @Override
    public String toString() {
        return "La coleccion contiene: "+ pila.length+
                "Elementos\n Sus elementos son: "+pila.toString();
    }
    
    @Override
    public boolean estaVacia() {
        boolean vacio;
        if (pila.length > 0) {
            vacio = false;
        } else {
            vacio = true;
        }
        return vacio;
    }

    @Override
    public T extraer() {
        T extraido;
        
        if (cont==0){ 
            extraido = null;
        
        }
        else {
        extraido = pila[0];        
        T[] cPila = (T[]) new Object[pila.length-1];
        System.arraycopy(pila, 1, cPila, 0, pila.length-1);
        pila = cPila;
        cont--;
        }
        return extraido;
    }

    @Override
    public T primer() {
        return pila[0];
    }

    @Override
    public void aniadir(T e) {
        T[] cPila = (T[]) new Object[pila.length+1];
        System.arraycopy(pila, 0, cPila, 0, pila.length);
        pila = cPila;
        pila[cont++]=e;
    }

}
