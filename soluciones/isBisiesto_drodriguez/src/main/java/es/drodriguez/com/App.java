package es.drodriguez.com;

/**
 * Hello world!
 *
 */
public class App 
{
    public static boolean isBisiesto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }
}
