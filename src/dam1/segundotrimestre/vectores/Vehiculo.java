package dam1.segundotrimestre.vectores;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vehiculo {
    private int numeroKilometros;
    private float precio;
    private  String matricula;
    private final String marca;
    private final String descripcion;
    private String nombrePropietario;
    private String dni;
    LocalDate fechaMatriculacion;

    public Vehiculo(){
        String fecha;
        boolean error = false; // Flag para comprobar que las variables son válidas

        Scanner sc =  new Scanner(System.in);
        Pattern patronMatricula = Pattern.compile("^[0-9]{4}[a-zA-Z]{3}$");
        Pattern patronDNI = Pattern.compile("^[0-9]{8}[A-Z]$");
        Matcher comprobarMatricula;
        Matcher comprobarDNI;

        System.out.println("Introduce la marca del vehículo:");
        this.marca = sc.nextLine();

        do{
            if(error){
                System.out.println("Introduce bien los datos, la matrícula del vehículo no es válida");
            }
            System.out.println("Introduce el matricula del vehículo:");
            this.matricula = sc.nextLine();
            comprobarMatricula = patronMatricula.matcher(this.matricula);
            error = !comprobarMatricula.matches();
        } while(error);
        error = false;

        do {
            if(error){
                System.out.println("El número de Kilómetros es incorrecto");
            }
            System.out.println("Introduce el número de kilómetros:");
            this.numeroKilometros = sc.nextInt();
            sc.nextLine();
            error = this.numeroKilometros < 0;

        }while(error);
        error = false;

        do {
            if(error){
                System.out.println("La fecha de matriculación tiene que ser anterior a hoy");
            }
            System.out.println("Introduce la fecha de matriculación (AAAA/MM/DD):");
            fecha = sc.nextLine();

            this.fechaMatriculacion = LocalDate.of(
                    Integer.parseInt(fecha.split("/")[0]),
                    Integer.parseInt(fecha.split("/")[1]),
                    Integer.parseInt(fecha.split("/")[2])
            );
            error = this.fechaMatriculacion.isAfter(LocalDate.now()) || this.fechaMatriculacion.isEqual(LocalDate.now());

        } while(error);
        error = false;


        System.out.println("Introduce una descripción del vehículo:");
        this.descripcion = sc.nextLine();

        do{
            if(error){
                System.out.println("El precio del coche tiene que ser mayor que 0");
            }

            System.out.println("Introduce el precio del coche");
            this.precio = sc.nextInt();
            sc.nextLine();
            error = this.precio <= 0;

        } while(error);
       error = false;

        do {
            if (error){
                System.out.println("Introduce un nombre correcto");
            }
            System.out.println("Introduce el nombre del propietario:");
            this.nombrePropietario = sc.nextLine();
            error = this.nombrePropietario.length() > 40 || this.nombrePropietario.split(" ").length != 3;
        }while(error);
        error = false;


        do{
            if(error){
                System.out.println("Introduce el DNI correctamente");
            }
            System.out.println("Introduce el DNI del propietario:");
            this.dni = sc.nextLine();
            comprobarDNI = patronDNI.matcher(this.dni);
            error = !comprobarDNI.matches();
        }while(error);
    }

    public boolean tieneMatricula(String matricula) {
        return this.matricula.equals(matricula);
    }

    public String getMatricula() {
        return this.matricula;
    }

    public boolean cambiarKilometros(int numeroKilometros)  {
        if (numeroKilometros > this.numeroKilometros){
            this.numeroKilometros = numeroKilometros;
            return true;
        }
        return false;
    }

    public void visualizar() {
        System.out.println("Marca: " + this.marca + "\nMatrícula: " + this.matricula
                + "\nPrecio: " + this.precio +"€" );
    }

    @Override
    public String toString(){
        return "Marca: " + this.marca + "\nMatrícula: " + this.matricula
                + "\nPrecio: " + this.precio +"€\nKMs: " + this.numeroKilometros
                + "\nDescripción: " + this.descripcion;

    }
}
