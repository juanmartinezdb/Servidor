/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package genericos1;

/**
 *
 * @author JMart
 */
public class Genericos1 {

    /**
     * @param args the command line arguments
     */
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
