package org.example;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test de Matricula de Coche")
public class MatriculaTest
{

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    @DisplayName("Longitud de la Matricula")
    @Order(1)
    public void longitudMatriculaCorrecta(){
    String matriculaTrue = "1234BBB";
    String matriculaFalse = "12341234BBBBBBBB";
    String matriculaFalse2 = "12BB";
    Assertions.assertAll(
            ()-> assertTrue(Matricula.matriculalongitud(matriculaTrue)),
            ()-> assertFalse(Matricula.matriculalongitud(matriculaFalse)),
            ()-> assertFalse(Matricula.matriculalongitud(matriculaFalse2))
    );
        }
    @Test
    @DisplayName("Primeras Cuatro Posiciones Son Números")
    @Order(2)
    public void primerasCuatroPosNum(){
    String matricula = "1234BBB";
    assertTrue(Matricula.isPrimerasCuatroNum(matricula));
    }
    @Test
    @DisplayName("Últimas Tres Posiciones Son Letras")
    @Order(3)
    public void ultimasTresPosLetras() {
        String matriculaTrue = "1234BBB";
        String matriculaFalse = "12341234";
        Assertions.assertAll(
                () -> assertTrue(Matricula.ultimosTresLetras(matriculaTrue)),
                () -> assertFalse(Matricula.ultimosTresLetras(matriculaFalse))
        );
    }
    @Test
    @Order(4)
    @DisplayName("Obtención de las Letras")
    public void testGetMatriculaLetras(){
    String matriculaTrue = "1234BBB";
    String letrasTrue = "BBB";
    String matriculaFalse = "1234BBA";
    String letrasFalse = "BBA";
    Assertions.assertAll(
            ()-> assertEquals(letrasTrue,Matricula.getMatriculaLetras(matriculaTrue)),
            ()-> assertEquals(letrasFalse,Matricula.getMatriculaLetras(matriculaFalse))
    );
        }
    @Test
    @Order(5)
    @DisplayName("Letras Correctas")
    public void testLetrasMatriculaCorrecta(){
        String matriculaCorrecta = "1234BBB";
        String matriculaIncorrecta = "1234AAA";
        Assertions.assertAll(
                ()-> assertTrue(Matricula.letrasCorrectas(Matricula.getMatriculaLetras(matriculaCorrecta))),
                ()-> assertFalse(Matricula.letrasCorrectas(Matricula.getMatriculaLetras(matriculaIncorrecta)))
        );
    }
    }

