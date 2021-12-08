package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */

@DisplayName("Test DNI")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest {
    //@Test
    //void trueIsTrue(){
    //    assertTrue(true);
    //

    @Test
    @Order(1)
    @DisplayName("Número de valores = 9")
    public void testDniLongitud(){
            String dniTrue="02748649";
            String dniFalse="032";
            String dniFalse2="0274864999B";

        Assertions.assertAll(
                () -> assertTrue(App.dniLongitud(dniTrue)),
                () -> assertFalse(App.dniLongitud(dniFalse)),
                () -> assertFalse(App.dniLongitud(dniFalse2))
        );
    }

    @Test
    @Order(2)
    @DisplayName("Todo son digitos")
    public void testIsANumber(){
        String dniTrue="02748649";
        String dniFalse="holalolo";

        Assertions.assertAll(
                () -> assertTrue(App.isANumber(dniTrue)),
                () -> assertFalse(App.isANumber(dniFalse))
        );
    }

    @Test
    @Order(3)
    @DisplayName("Letra del DNI")
    public void testHasLetter(){
        String letterTrue="02748649";
        String letterCorrect="B";
        String letterFalse="02748644";
        String letterIncorrect ="Y";

        Assertions.assertAll(
                () -> assertEquals(letterCorrect, App.hasLetter(letterTrue), "Letra de DNI es correcta"),
                () -> assertEquals(letterIncorrect, App.hasLetter(letterFalse), "Letra de DNI es incorrecta")
        );
    }

}
