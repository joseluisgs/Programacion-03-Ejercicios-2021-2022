package es.drodriguez.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @DisplayName("Año bisiesto")
    @Test
    public void isBisiesto() {
        Assertions.assertAll(
                () -> assertTrue(App.isBisiesto(2020), "BISIESTO"),
                () -> assertTrue(App.isBisiesto(2000), "BISIESTO"),
                () -> assertFalse(App.isBisiesto(2019), "NO ES BISIESTO"),
                () -> assertFalse(App.isBisiesto(2003), "NO ES BISIESTO")
                );

        }
}
