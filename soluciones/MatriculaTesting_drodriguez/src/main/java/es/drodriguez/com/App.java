package es.drodriguez.com;

public class App {
    public static void main(String[] args) {
        String matricula = "0000AAA";
    }

    public static boolean matriculaLongitud(String matricula) {
        return matricula.length() == 7;
    }

    public static boolean letrasMatricula(String matricula) {
        boolean isTrue = false;
        for(int i = 4; i < matricula.length(); i++) {
            if(Character.isLetter(matricula.charAt(i))){
                isTrue = true;
            }
        }
        return isTrue;
    }

    public static boolean numerosMatricula(String matricula) {
        for(int i = 0; i < 3; i++){
            if (!Character.isDigit(matricula.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}