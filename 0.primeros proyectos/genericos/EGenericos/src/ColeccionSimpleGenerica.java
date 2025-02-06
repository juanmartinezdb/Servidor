public interface ColeccionSimpleGenerica<T> {
    boolean estaVacia();
    T extraer();
    T primer();
    void aniadir (T e);
}
