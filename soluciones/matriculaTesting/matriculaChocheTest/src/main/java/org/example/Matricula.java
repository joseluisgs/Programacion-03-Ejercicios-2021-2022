package org.example;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class Matricula {

    public static void main( String[] args ) {
        Scanner sc =new Scanner(System.in);

        System.out.println("Introduce la letra del pais al que pertenece la matricula..");
        String pais= sc.nextLine().toUpperCase();

        System.out.println("Introduce la matricula..");
        String matricula= sc.nextLine().toUpperCase();
        System.out.println("Matricula introducida: "+pais+" "+matricula);



        /*paisMatricula(pais);
        matriculaLongitud(matricula);
        primerosNumbers(matricula);
        ultimasLetras(matricula);*/
        if (paisMatricula(pais) && matriculaLongitud(matricula) &&primerosNumbers(matricula) && ultimasLetras(matricula)){
            System.out.println("La matricula es correcta ");
            System.out.println(pais+" "+matricula);
        }else {
            System.out.println("Matricula erronea..");
        }


    }

    /**
     * longitud de la matricula
     * @param matricula
     * @return
     */
    public static boolean matriculaLongitud(String matricula) {
        return matricula.length()==7;
    }

    /**
     * los primeros cutro son números.
     * @param matricula
     * @return
     */
    public static boolean primerosNumbers(String matricula) {
        for (int i = 0; i < 4 ; i++) {
            if (!Character.isDigit(matricula.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * comprueba si las últimas letras de la matricula son letras
     * @param matricula
     * @return
     */
    public static boolean ultimasLetras(String matricula) {
        boolean isOk= false;
        for (int i = 4; i < matricula.length(); i++) {
            if (Character.isLetter(matricula.charAt(i))){
                isOk=true;
            }
        }
        return isOk;
    }

    /**
     * comprueba que el pais al que pertenece
     * @param paisMatricula
     * @return
     */
    public static boolean paisMatricula(String paisMatricula) {
        String pais= "E";
        return pais.equals(paisMatricula);
    }


    /**
     *
     * @param letter
     * @return
     */
    public static boolean isValid (String letter){
        boolean correcto=true;
        String incorrectas ="AEIOUÑQ";
        for (int i = 4; i < letter.length(); i++) {
            for (int j = 0; j < incorrectas.length(); j++) {
                if (letter.charAt(i)==incorrectas.charAt(j)){
                    correcto=false;
                }
            }
        }
        return correcto;
    }




}
