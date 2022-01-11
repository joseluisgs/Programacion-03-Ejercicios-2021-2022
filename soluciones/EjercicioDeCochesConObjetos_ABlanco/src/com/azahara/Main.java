package com.azahara;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//nuestro programa va a crear 3 coches y los va a rellenar con datos pedidos por consola
        Vehiculo v1 = crearVehiculo();
        //Vehiculo v2 = crearVehiculo();
       // Vehiculo v3 = crearVehiculo();

        imprimirVehiculo(v1);
        //imprimirVehiculo(v2);
        //imprimirVehiculo(v3);

    }

    private static void imprimirVehiculo(Vehiculo v) {
        System.out.println("la descripcion del veiculo con nombre: "+v);
        System.out.print(" su matricula es: " +v.matricula+ ", su marca: "
                +v.marca+", su cilindrada : "+ v.cilindrada+", su motor: "
                + v.motor + ",su año fabricacion: "+v.yearDeFabricacion);
        System.out.println(", la antiguedad en años: "+ (2022-v.yearDeFabricacion));
    }

    private static Vehiculo crearVehiculo() {
        //para escanear
        Scanner sc = new Scanner(System.in);
        //creamos vehiculo
        Vehiculo v = new Vehiculo();
        //Las distintas propiedades
        System.out.println("Dime la matricula : ");
        v.matricula= sc.nextLine();
        System.out.println("Dime la marca : ");
        v.marca= sc.nextLine();
        System.out.println("Dime la Cilindrada : ");
        v.cilindrada= sc.nextLine();
        System.out.println("Dime el tipo de Motor : ");
        v.motor= sc.nextLine();
        System.out.println("Dime el año de fabricacion : ");
        v.yearDeFabricacion= readInt();
       return v;

    }

    private static int readInt() {
        //para escanear
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        int anio=-1;
        do {
            try {
                System.out.println("Dime un año real: ");
                anio = sc.nextInt();
                if (anio<2023 && anio>0){ok=true;}
            }catch (Exception e){
                System.err.println("el año no es valido");
                sc.next();
            }
        }while (!ok);
        return anio;
    }
}
