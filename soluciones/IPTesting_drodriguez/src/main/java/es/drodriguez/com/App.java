package es.drodriguez.com;


public class App {
    /**
     *
     * @param args
     * @author Daniel Rodriguez
     */
    public static void main( String[] args ) {

        String ipNumber = "192.169.1.1";
    }

    /**
     *
     * @param ipNumber dirección IP que comprobamos
     * @return verdadero/ falso
     */
    public static boolean longitudIsCorrect(String ipNumber) {
         if (ipNumber.length()>=7 && ipNumber.length()<= 15){
             return true;
        }
         return false;
    }


    public static boolean isPuntosCorrect(String ipNumber) {
        int puntos = 0;
        for (int i=0; i<ipNumber.length(); i++){
            String caracteres = ipNumber.substring(i,(i+1));
            if (caracteres.equals(".")){
                puntos++;
            }
        }
        return puntos == 3;
    }

    /**
     *
     * @param unidades comparamos sí el conjunto de bloques están formados por números
     * @return verdadero / falso
     */

    public static boolean isNumber(String unidades) {
        for (int i=0; i<unidades.length(); i++){
            if (!Character.isDigit(unidades.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumbersString( String ipNumber){
        int punto1 = ipNumber.indexOf(".");
        int punto2 = ipNumber.indexOf(".",(punto1+1));
        int punto3 = ipNumber.indexOf(".",(punto2+1));

        String unidad1 = ipNumber.substring(0,punto1);
        String unidad2 = ipNumber.substring(punto1+1, punto2);
        String unidad3 = ipNumber.substring(punto2+1, punto3);
        String unidad4 = ipNumber.substring(punto3+1);

        boolean unidad1isNumber = isNumber(unidad1);
        boolean unidad2isNumber = isNumber(unidad2);
        boolean unidad3isNumber = isNumber(unidad3);
        boolean unidad4isNumber = isNumber(unidad4);

        if (unidad1isNumber && unidad2isNumber && unidad3isNumber && unidad4isNumber){
            return true;
        }
        return false;
    }
}
