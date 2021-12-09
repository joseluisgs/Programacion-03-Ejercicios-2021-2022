package es.drodriguez.com;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    @DisplayName("Comprobar la longitud de la IP")
    public void longitudIsCorrect(){
        String longitudTrue1 = "000.000.000.000";
        String longitudTrue3 = "0.0.0.0";
        String longitudFalse1 = "0.0.0.";
        String longitudFalse3 = "000.000.000.000.000";
        Assertions.assertAll(
                ()-> assertTrue(App.longitudIsCorrect(longitudTrue1)),
                ()-> assertTrue(App.longitudIsCorrect(longitudTrue3)),
                ()-> assertFalse(App.longitudIsCorrect(longitudFalse1)),
                ()-> assertFalse(App.longitudIsCorrect(longitudFalse3))
        );
    }

    @Test
    @DisplayName("Seperado por puntos")
    public void puntosIsCorrect(){
        String puntosIpTrue = "0.0.0.0";
        String puntosIpFalse = ".0.0";
        String puntosIpFalse2 = "0.0.0.0.";
        Assertions.assertAll(
                ()-> assertTrue(App.isPuntosCorrect(puntosIpTrue)),
                ()-> assertFalse(App.isPuntosCorrect(puntosIpFalse)),
                ()-> assertFalse(App.isPuntosCorrect(puntosIpFalse2))
        );
    }

    @Test
    @DisplayName("Son números")
    public void isNumber(){
        String isNumberTrue = "000.000.000.000";
        String isNumberFalse = "0a0.000.000.000";
        Assertions.assertAll(
                ()-> assertTrue(App.isNumbersString(isNumberTrue)),
                ()-> assertFalse(App.isNumbersString(isNumberFalse))
        );
    }
}
