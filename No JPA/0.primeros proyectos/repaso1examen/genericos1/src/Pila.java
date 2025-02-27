import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pila<T> implements ColeccionSimpleGenerica<T>{
List<T> lista ;
public Pila (){
    lista =  new LinkedList<T>();
}

    @Override
    public boolean estaVacia() {
        return lista.isEmpty();
    }

    @Override
    public T extraer() { //es una pila entonces es LIFO (last in, las out)
        return lista.remove(lista.size()-1);
    }

    @Override
    public T primero() {
        return lista.get(0);
    }

    @Override
    public void aniadir(T e) {
        lista.add((T) e);
    }

    @Override
    public String toString() {
        String cadena ="Pila:\n";
        int contador = 0;
        for(T item : lista){
            cadena+=contador+": "+item.toString()+"\n";
        }
    return cadena;
    }
}
