package org.example;

/**
 * Hello world!
 *
 */
public class Matricula {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String matricula = "1234BBB";
    }

    public static boolean matriculalongitud(String matricula) {
        return matricula.length() == 7;
    }

    public static boolean isPrimerasCuatroNum(String matricula) {
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean ultimosTresLetras(String matricula) {
        return Character.isLetter(matricula.charAt(4));
    }

    public static String getMatriculaLetras(String matricula) {
        String letras = "";
        for (int i = 4; i < matricula.length(); i++) {
            letras += matricula.charAt(i);
        }
        return letras;
    }

    public static boolean letrasCorrectas(String letras) {
        boolean correcto = true;
        String letrasExcluidas = "AEIÑOQU";
        for (int i = 0; i < letras.length(); i++) {
            for (int j = 0; j < letrasExcluidas.length(); j++) {
                if (letras.charAt(i) == letrasExcluidas.charAt(j)) {
                    correcto = false;
                }
            }

        }
        return correcto;
    }
}


