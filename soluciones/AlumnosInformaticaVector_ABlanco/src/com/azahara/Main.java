package com.azahara;

import java.util.Scanner;

/**
 * @author Azahara Blanco Rodriguez
 * @date 11-01-2022
 * @Description programa que realiza un vector de (objetos pojo) alumnos informaticas,
 * pide sus caracterirticas por teclado y las imprime.
 */
public class Main {

    public static void main(String[] args) {
	    //Crear vector
        AlumnosInformatica [] vectorAlumnos = new AlumnosInformatica[3];

        //introducir alumnos en el vector
        rellenarVectorDeAlumnos(vectorAlumnos);

        imprimirVectorAlumnos(vectorAlumnos);


        }

    private static void imprimirVectorAlumnos(AlumnosInformatica[] vectorAlumnos) {
        for (int i = 0; i < vectorAlumnos.length; i++) {
            imprimirAlumno(vectorAlumnos[i]);
        }
    }

    private static void rellenarVectorDeAlumnos(AlumnosInformatica[] vectorAlumnos) {
        //recorremos el vector
        for (int i = 0; i < vectorAlumnos.length; i++) {
            vectorAlumnos[i]=crearPersona();
        }
    }

    private static AlumnosInformatica crearPersona() {
        AlumnosInformatica a = new AlumnosInformatica();
        System.out.println(" intoduccamos los datos del alumno ");
        Scanner sc = new Scanner(System.in);
        System.out.println("el nombre: ");
        a.nombre = sc.next();
        System.out.println("los apellidos");
        a.apellidos=sc.next();
        System.out.println("Dime el curso que puede ser 1 o 2: ");
        a.curso = getCurso();
        System.out.println("Dime el grupo que puede ser daw o dam ");
        a.grupo =getGrupo();
        System.out.println("Dime el año de nacimiento: ");
        a.yearBorn=getInt();
        return a;
    }

    private static String getGrupo() {
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        String curso="a";
        do {
            try {
                System.out.println("un curso valido entre las opciones");
                curso = sc.next();
                if (curso.equals("dam") || curso.equals("daw")){
                    ok=true;
                }

            }catch (Exception e){
                System.err.println("el curso no es valido");
                sc.next();
            }
        }while (!ok);
        return curso;
    }

    private static int getCurso() {
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        int numero=-1;
        do {
            try {
                System.out.println("Dime un numero mayor o igual a 0: ");
                numero = sc.nextInt();
                if (numero==1 || numero==2){
                    ok=true;
                }
            }catch (Exception e){
                System.err.println("el curso no es valido");
                sc.next();
            }
        }while (!ok);
        return numero;
    }

    private static int getInt() {
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        int numero=-1;
        do {
            try {
                System.out.println("Dime un anio entre o y 2022: ");
                numero = sc.nextInt();
                if (numero>0 &&numero<2023){
                    ok=true;
                }
            }catch (Exception e){
                System.err.println("el anio  no es valido");
                sc.next();
            }
        }while (!ok);
        return numero;
    }

    private static void imprimirAlumno(AlumnosInformatica a1) {
        System.out.println(" El aluno es el numero : "+ a1);
        System.out.println(" su nombre y apellidos son :" + a1.nombre +", "+ a1.apellidos);
        System.out.println(" esta en el curso : "+ a1.curso +" del grupo "+ a1.grupo);
        System.out.println(" su fecha de nacimiento es :"+ a1.yearBorn);
    }
}

