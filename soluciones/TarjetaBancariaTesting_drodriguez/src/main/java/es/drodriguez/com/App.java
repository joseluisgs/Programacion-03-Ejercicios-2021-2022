package es.drodriguez.com;

public class App
{
    public static void main( String[] args ) {
        String numberCard = "4158-1548-2308-0568";
    }

    public static boolean longTarjeta(String numberCard) {
        return numberCard.length() == 19;
    }

    public static boolean correctSeparadores(String numberCard) {
        int guiones = 0;
        for (int i = 0; i < numberCard.length(); i++){
            String caracteres = numberCard.substring(i,(i+1));
            if(caracteres.equals("-")){
                guiones++;
            }
        }
        return guiones == 3;
    }

    public static boolean isNumbersString(String numberCard) {
        //Localización de los tres guiones separadores del número
        int guion1 = numberCard.indexOf("-");
        int guion2 = numberCard.indexOf("-",(guion1+1));
        int guion3 = numberCard.indexOf("-",(guion2+1));

        //Creamos 4 substrings que están delimitadas por los guiones.
        String unidad1 = numberCard.substring(0,guion1);
        String unidad2 = numberCard.substring(guion1+1,guion2);
        String unidad3 = numberCard.substring(guion2+1,guion3);
        String unidad4 = numberCard.substring(guion3+1);

        //Comprobamos que cada substring está formado solo por números.
        //Necesitamos crear una función que nos compruebe si un string es un número.
        boolean unidad1isNumber = isNumber(unidad1);
        boolean unidad2isNumber = isNumber(unidad2);
        boolean unidad3isNumber = isNumber(unidad3);
        boolean unidad4isNumber = isNumber(unidad4);

        //Comprobamos que las 4 unidades de bloques son números
        if(unidad1isNumber && unidad2isNumber && unidad3isNumber && unidad4isNumber){
            return true;
        }
        return false;
    }

    //Con esta función podemos comprobar sí los valores introducidos en un String son números
    public static boolean isNumber(String unidades){
        for (int i =0; i <unidades.length(); i++){
            if(!Character.isDigit(unidades.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
