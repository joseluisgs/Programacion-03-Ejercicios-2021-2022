package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */

@DisplayName("Test Cuenta Bancaria")
public class AppTest {
    //@Test
    //void trueIsTrue(){
    //    assertTrue(true);
    //
    
    static String account;
    
    @BeforeAll
    public static void setupAll(){
        account = "12345678061234567890";
    }

    @Test
    @DisplayName("Longitud cuenta bancaria")
    public void testLengthAccount(){
        String accountF ="1233566575";
        String accountF2 ="123456780612345678901";

        Assertions.assertAll(
                () -> assertTrue(App.isLenght(account)),
                () -> assertFalse(App.isLenght(accountF)),
                () -> assertFalse(App.isLenght(accountF2))
        );
    }

    @Test
    @DisplayName("Todos son números")
    public void testAllAreNumbers(){
        String accountF ="Holacaracolaestoeguo";

        Assertions.assertAll(
                () -> assertTrue(App.isNumber(account)),
                () -> assertFalse(App.isNumber(accountF))
        );

    }

    @Test
    @DisplayName("Primer dígito de control correcto")
    public void testFirstControlCorrect(){
        int primerDigit = 0;
        int primerDigitF = 1;
        int primerDigitF2 = 2;
        assertAll(
                () -> assertEquals(primerDigit,App.firstControlCorrect(account)),
                () -> assertNotEquals(primerDigitF,App.firstControlCorrect(account)),
                () -> assertNotEquals(primerDigitF2,App.firstControlCorrect(account))
        );
    }

    @Test
    @DisplayName("Segundo dígito de control correcto")
    public void testSecondControlCorrect(){
        int secondDigit = 6;
        int secondDigitF = 1;
        int secondDigitF2 = 3;

        assertAll(
                () -> assertEquals(secondDigit,App.secondControlCorrect(account)),
                () -> assertNotEquals(secondDigitF,App.secondControlCorrect(account)),
                () -> assertNotEquals(secondDigitF2,App.secondControlCorrect(account))
        );
    }


}
