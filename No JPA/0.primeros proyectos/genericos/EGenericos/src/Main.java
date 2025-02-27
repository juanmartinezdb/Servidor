//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Matriz matriz = new Matriz(4, 2);
        int contador = 1;
        for (int i = 0; i < matriz.filas(); i++) {
            for (int j = 0; j < matriz.columnas(); j++) {
                matriz.set(i, j, contador++);
            }
        }
        System.out.println("La matriz es:\n"+matriz);
    }
}