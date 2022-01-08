package azahara;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("test de azahara") //para poner nombre a el test
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //para poner un orden a los metodos
public class ejercicio_azaharaTest {    //la clase donde van tosos los test

    @Test   //siempre que iniciamos un test
    @Order(1) //si queremos iniciar los test en orden
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }
    @DisplayName("nombre del test en concreto")
    public void testDniLongitud() {

        //preparacion(los valores que necesitamos para probarlo


        // Actuar (llamar a la funcion que vamos a probar


        //Verificamos que da lo que tiene que dar ya sea false o true


    }

    /**ejemplo
    @Test
    @Order(2)
    @DisplayName("Ultima posición es Letra DNI")
    public void testDniLetra() {
        String dniTrue = "66666666A";
        String dniFalse = "666666669";
        Assertions.assertAll(
                () ->assertTrue(ejercicio_azahara.ultimoIsLetra(dniTrue)),
                () ->assertFalse(ejercicio_azahara.ultimoIsLetra(dniFalse))
        );
    }
     */




}
