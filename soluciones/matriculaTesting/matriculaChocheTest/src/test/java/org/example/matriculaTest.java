package org.example;

import org.junit.jupiter.api.*;

import static org.example.Matricula.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
@DisplayName("Suit Test matricula coche")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class matriculaTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    private void assertTrue() {
        assertTrue();
    }

    private void assertTrue(boolean b) {
    }


    
    @Test
    @DisplayName("Comprobar la longitud de la matricula")
    @Order(1)
    public void testMatriculaLongitud(){
        String matriculaTrue= "0616CND";
        String matriculaFalse1= "061CND";
        String matriculaFalse2= "0616CNDG";
        Assertions.assertAll(
                ()->assertTrue(matriculaLongitud(matriculaTrue)),
                ()->assertFalse(matriculaLongitud(matriculaFalse1)),
                ()->assertFalse(matriculaLongitud(matriculaFalse2))
        );
    }

    @Test
    @DisplayName("Los cuatro primeros son números")
    @Order(2)
    public void testPrimeroNumbers(){
        String matriculaTrue= "0616CND";
        assertTrue(primerosNumbers(matriculaTrue));
    }


    @Test
    @DisplayName("Las tres ultimas son letras")
    @Order(3)
    public void testUltimasLetras(){
        String matriculaTrue= "0616CND";
        assertTrue(ultimasLetras(matriculaTrue));
    }

    @Test
    @DisplayName("Pais de la matricula")
    @Order(4)
    public void testPaisMatricula() {
        String pais= "E";
        assertTrue(Matricula.paisMatricula(pais));
    }


    @Test
    @DisplayName("Comprobar que las letras son correctas")
    @Order(5)
    public void testIsValid(){
        String matriculaTrue= "0616CND";
        String matriculaFalse= "0616ÑND";
        Assertions.assertAll(
                ()->Assertions.assertTrue(Matricula.isValid(matriculaTrue)),
                ()->Assertions.assertFalse(Matricula.isValid(matriculaFalse))
        );
    }






}
