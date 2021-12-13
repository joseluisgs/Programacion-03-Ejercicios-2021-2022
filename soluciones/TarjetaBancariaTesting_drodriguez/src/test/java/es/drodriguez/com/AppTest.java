package es.drodriguez.com;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest {
    @DisplayName("Test Tamaño Número tarjeta")
    @Test
    public void longTarjeta() {
        String longitudTrue = "0000-0000-0000-0000";
        String longTarjetaFalse1 = "0000-0000-0000-0000-0000";
        String longTarjetaFalse2 = "000-0000";
        String longTarjetaFalse3 = "0000-0000-0000-00000";
        Assertions.assertAll(
                () -> assertTrue(App.longTarjeta(longitudTrue)),
                () -> assertFalse(App.longTarjeta(longTarjetaFalse1)),
                () -> assertFalse(App.longTarjeta(longTarjetaFalse2)),
                () -> assertFalse(App.longTarjeta(longTarjetaFalse3))
        );
    }

    @DisplayName("Comprobar si están separados los bloques")
    @Test
    public void separadoresCard(){
        String separadoresCardTrue = "0000-0000-0000-0000";
        String separadoresCardFalse1 ="-0000-0000";
        String separadoresCardFalse2 ="-0000-0000-0000-0000";
        Assertions.assertAll(
                ()-> assertTrue(App.correctSeparadores(separadoresCardTrue)),
                ()-> assertFalse(App.correctSeparadores(separadoresCardFalse1)),
                ()-> assertFalse(App.correctSeparadores(separadoresCardFalse2))
        );
    }

    @DisplayName("Son números los bloques")
    @Test
    public void isNumber(){
        String numbersCardTrue = "0000-0000-0000-0000";
        String numberCardFalse1 = "000a-0000-0000-0000";
        Assertions.assertAll(
                ()-> assertTrue(App.isNumbersString(numbersCardTrue)),
                ()-> assertFalse(App.isNumbersString(numberCardFalse1))
        );
    }
}
