package dam1.segundotrimestre.vectores;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    public static void main(String[] args){
        Concesionario concesionario = new Concesionario();
       mostrar();
    }


   /* private static void crearVehiculo(){
        String descripcion, marca, matricula, nombre, dni, fecha;
        int numeroKilometros, precio;
        boolean error = false; // Flags para comprobar que las variables son válidas

        Scanner sc =  new Scanner(System.in);
        LocalDate fechaMatriculacion;
        Pattern patronMatricula = Pattern.compile("^[0-9]{4}[a-zA-Z]{3}$");
        Pattern patronDNI = Pattern.compile("^[0-9]{8}[A-Z]$");
        Matcher comprobarMatricula;
        Matcher comprobarDNI;



        System.out.println("Introduce la marca del vehículo:");
        marca = sc.next();

        do{
            if(error){
                System.out.println("Introduce bien los datos, la matrícula del vehículo no es válida");
            }
            System.out.println("Introduce el matricula del vehículo:");
            matricula = sc.next();
            comprobarMatricula = patronMatricula.matcher(matricula);
            if (!comprobarMatricula.matches()){
                error = true;
            }
        } while(error);
        error = false;

        do {
            if(error){

            }
            System.out.println("Introduce el número de kilómetros:");
            numeroKilometros = sc.nextInt();
        }while(error);

        do {
            if(error){
                System.out.println("La fecha de matriculación tiene que ser anterior a hoy");
            }
            System.out.println("Introduce la fecha de matriculación (AAAA/MM/DD):");
            fecha = sc.next();

            fechaMatriculacion = LocalDate.of(
                    Integer.parseInt(fecha.split("/")[0]),
                    Integer.parseInt(fecha.split("/")[1]),
                    Integer.parseInt(fecha.split("/")[2])
            );
            if (fechaMatriculacion.isAfter(LocalDate.now()) || fechaMatriculacion.isEqual(LocalDate.now())){
                error = true;
            }

        } while(error);


        System.out.println("Introduce una descripción del vehículo:");
        descripcion = sc.next();

        System.out.println("Introduce el precio del coche");
        precio = sc.nextInt();

        System.out.println("Introduce el nombre del propietario:");
        nombre = sc.next();

        System.out.println("Introduce el DNI del propietario:");
        dni = sc.next();
    } */

    private static void mostrar(){
        System.out.println("1 - Nuevo vehículo");
        System.out.println("2 - Listar vehículos");
        System.out.println("3 - Buscar vehículo");
        System.out.println("4 - Modificar kms vehículo");
        System.out.println("5 - Salir");
    }
}
