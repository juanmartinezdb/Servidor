public class Matriz<T> {

    private T[][] matriz;

    public Matriz(int fila, int col) {
        this.matriz = (T[][])new Object[fila][col];
    }

    public void set(int fila, int col, T e){
        matriz[fila][col]= e;
    }
    public T get(int fila, int col){
        return matriz[fila][col];
    }
    public int columnas(){
        return matriz[0].length;
    }
    public int filas(){
        return matriz.length;
    }

    @Override
    public String toString() {
        String cadena = "";
        for( T[] fila :matriz){
            for (T item : fila){
                cadena+=item.toString()+", ";
            }
            cadena+="\n";
        }
        return cadena;
    }



}