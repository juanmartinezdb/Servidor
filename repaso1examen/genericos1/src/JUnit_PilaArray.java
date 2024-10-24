import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit_PilaArray {
    PilaArray<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new PilaArray<>();
    }

    @Test
    @DisplayName("Añadir")
    void testAñadirPila() {
        pila.aniadir(3);
        Assertions.assertEquals(3,pila.primero());

    }

    @Test
    @DisplayName("Pila Vacia")
    void testPilaVacia() {
        // verificar que comprueba que está vacia
        Assertions.assertTrue(pila.estaVacia());
    }

    @Test
    @DisplayName("Extraer Pila")
    void testExtraerPila() {
        // añado dos y verifico si extrae el ultimo
        pila.aniadir(8);
        pila.aniadir(7);
        Assertions.assertEquals(7, pila.extraer());
        /*
         assertEquals es una declaracion de afirmacion
         que valida que el valor esperado
         y real es el mismo, si no, se muestra un mensaje al final del metodo
         */
    }

    @Test
    @DisplayName("PrimeroPila")
    void testPrimeroPila() {
        pila.aniadir(10);
        Assertions.assertEquals(10, pila.primero());
    }
}