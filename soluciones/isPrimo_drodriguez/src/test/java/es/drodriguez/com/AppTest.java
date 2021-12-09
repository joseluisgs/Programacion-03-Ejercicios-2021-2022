package es.drodriguez.com;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @DisplayName("Comprobar sí es primo o no")
    @Test
    @Order(1)
    public void isPrimo() {
        Assertions.assertAll(
                () -> assertTrue(App.isPrimo(2), "2"),
                () -> assertFalse(App.isPrimo(-1), "-1"),
                () -> assertTrue(App.isPrimo(11), "11"),
                () -> assertTrue(App.isPrimo(17), "17"),
                () -> assertFalse(App.isPrimo(18), "18"),
                () -> assertFalse(App.isPrimo(15), "15")
        );
    }
}
