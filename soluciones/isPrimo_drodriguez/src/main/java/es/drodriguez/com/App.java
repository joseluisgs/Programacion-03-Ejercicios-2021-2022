package es.drodriguez.com;

/**
 * Hello world!
 *
 */
public class App
{
    public static boolean isPrimo(int numero) {
        if (numero == 2) {
            return true;
        } else {
            if (numero <= 1 || numero % 2 == 0) {
                return false;
            } else {
                for (int i = 3; i <= 3; i++) {
                    if (numero % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
