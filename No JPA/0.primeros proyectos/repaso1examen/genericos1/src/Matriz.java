import java.util.Arrays;

public class Matriz<T> {
    private T[][] matriz;
    public Matriz(int rows, int cols) {
        matriz = (T[][]) new Object[rows][cols];
    }
    public void set(int row, int col, T value) {
        matriz[row][col] = value;
    }
    public T get(int row, int col) {
        return matriz[row][col];
    }
    public int columnas() {
        return matriz.length;
    }
    public int filas() {
        return matriz[0].length;
    }

    @Override
    public String toString() {
        String cadena = "";
            for (int i = 0; i < filas(); i++) {
                for (int j = 0; j < columnas(); j++) {
                    cadena += get(j, i) + " ";
                }
                cadena += "\n";
            }
            return cadena;
    }
}
