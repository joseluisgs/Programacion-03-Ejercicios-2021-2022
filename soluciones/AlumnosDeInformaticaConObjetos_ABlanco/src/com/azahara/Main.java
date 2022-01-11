package com.azahara;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//tenemos 3 alumnos

        System.out.println(" intoduccamos los datos del alumno ");
        AlumnosInformatica a1= leerAlumno();
        System.out.println(" intoduccamos los datos del alumno ");
        AlumnosInformatica a2= leerAlumno();
        System.out.println(" intoduccamos los datos del alumno ");
        AlumnosInformatica a3= leerAlumno();

        //imprimimos los datos del alumno
        imprimirAlumno(a1);
        imprimirAlumno(a2);
        imprimirAlumno(a3);

    }

    private static void imprimirAlumno(AlumnosInformatica a1) {
        System.out.println(" El aluno es el numero : "+ a1);
        System.out.println(" su nombre y apellidos son :" + a1.nombre +", "+ a1.apellidos);
        System.out.println(" esta en el curso : "+ a1.curso +" del grupo "+ a1.grupo);
        System.out.println(" su fecha de nacimiento es :"+ a1.yearBorn);
    }

    private static AlumnosInformatica leerAlumno() {
        Scanner sc = new Scanner(System.in);
        AlumnosInformatica a = new AlumnosInformatica();
        System.out.println("el nombre: ");
        a.nombre=sc.next();
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
}
