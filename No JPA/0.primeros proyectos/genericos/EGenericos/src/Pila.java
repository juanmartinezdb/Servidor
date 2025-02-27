import java.util.LinkedList;
import java.util.List;

public class Pila<T> implements ColeccionSimpleGenerica<T> {

    List<T> Lista;

    public Pila() {
        this.Lista = new LinkedList<T>();
    }

    @Override
    public String toString() {
        return "La coleccion contiene: "+ Lista.size()+
                "Elementos\n Sus elementos son: "+Lista.toString();
    }




    @Override
    public boolean estaVacia() {
        return Lista.isEmpty();
    }

    @Override
    public T extraer() {
        return Lista.remove(0);
    }

    @Override
    public T primer() {
        return Lista.get(0);
    }

    @Override
    public void aniadir(T e) {
        Lista.add(e);
    }



}