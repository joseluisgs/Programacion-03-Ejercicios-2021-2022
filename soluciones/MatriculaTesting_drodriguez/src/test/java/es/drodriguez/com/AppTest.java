package es.drodriguez.com;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Matriculas Vehículos")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest {

    @Test
    @Order(1)
    @DisplayName("Comprobar que la matricula tiene 7 caracteres")
    public void longitudMatricula() {
        String matriculaTrue = "0000AAA";
        String matriculaFalse1 = "000AAA";
        String matriculaFalse2 = "00000AAA";
        Assertions.assertAll(
                () -> assertTrue(App.matriculaLongitud(matriculaTrue)),
                () -> assertFalse(App.matriculaLongitud(matriculaFalse1)),
                () -> assertFalse(App.matriculaLongitud(matriculaFalse2))
        );
    }

    @Test
    @Order(2)
    @DisplayName("Comprobar que los tres últimos dígitos son letras")
    public void tresLetrasMatricula() {
        String matriculaTrue = "0000AAA";
        String matriculaFalse = "0000000";
        Assertions.assertAll(
                () -> assertTrue(App.letrasMatricula(matriculaTrue)),
                () -> assertFalse(App.letrasMatricula(matriculaFalse))
        );
    }


    @Test
    @Order(3)
    @DisplayName("Comprobar que los 4 primeros dígitos son números")
    public void getLetter() {
        String matriculaTrue = "0000AAA";
        String matriculaFalse1 = "AAAAAAA";
        Assertions.assertAll(
                () -> assertTrue(App.numerosMatricula(matriculaTrue)),
                () -> assertFalse(App.numerosMatricula(matriculaFalse1))
        );
    }


}
