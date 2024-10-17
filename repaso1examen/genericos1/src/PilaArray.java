import java.util.Arrays;

public class PilaArray<T> implements ColeccionSimpleGenerica<T> {
    private T[] array;
    private int tam;

    public PilaArray() {
       array = (T[]) new Object[0];
       tam = 0;
    }

    @Override
    public String toString() {
        return "PilaArray{" +
                "array=" + Arrays.toString(array) +
                ", tamaño=" + tam +
                '}';
    }

    @Override
    public boolean estaVacia() {
        return tam==0;
    }

    @Override
    public T extraer() {
        if (estaVacia()) {
            return null;
        } else {
            T salida = array[--tam];
            array[tam] = null;
            array = Arrays.copyOf(array, tam);
            return salida;
        }
    }

    @Override
    public T primero() {
        if (estaVacia()) {
            return null;
        } else {
            return array[tam-1];
        }
    }

    @Override
    public void aniadir(T e) {
            array = Arrays.copyOf(array, ++tam);
            array[tam-1] = e;
    }
}
