package dam1.segundotrimestre.vectores;


import java.util.Scanner;

public class Menu {

    public static void main(String[] args){
        try {
            Concesionario concesionario = new Concesionario();
            opcion(concesionario);
        } catch (Exception e){
            System.out.println("Hubo un error");
        }
    }

    private static void mostrar(){
        System.out.println("1 - Nuevo vehículo");
        System.out.println("2 - Listar vehículos");
        System.out.println("3 - Buscar vehículo");
        System.out.println("4 - Modificar kms vehículo");
        System.out.println("5 - Salir");
    }

    private static void opcion(Concesionario concesionario){
        int entradaTeclado, nuevosKilometros, resultado;
        String matricula;
        Scanner sc = new Scanner(System.in);
        mostrar();
        System.out.print("Selecciona una opción: ");
        entradaTeclado = sc.nextInt();
        switch(entradaTeclado){
            case 1->{
                resultado = concesionario.insertarVehiculo();
                if(resultado == -1){
                    System.out.println("El concesionario está lleno, no se insertó el vehículo");
                } else if(resultado == -2){
                    System.out.println("La matrícula ya existe, no se insertó el vehículo");
                } else if(resultado == 0){
                    System.out.println("Coche insertado con éxito");
                }
                opcion(concesionario);
            }
            case 2 -> {
                concesionario.listarVehiculos();
                opcion(concesionario);
            }
            case 3 -> {
                Vehiculo coche;
                System.out.println("Escribe la matrícula del coche a buscar");
                matricula = sc.next();
                coche = concesionario.buscarVehiculo(matricula);
                if (coche != null){
                    coche.visualizar();
                } else{
                    System.out.println("No se encontró el coche");
                }
                opcion(concesionario);
            }
            case 4 -> {
                System.out.println("Escribe la matrícula del coche a modificar los KMs");
                matricula = sc.next();
                System.out.println("Escribe el nuevo número de KMs");
                nuevosKilometros = sc.nextInt();

               if(concesionario.actualizarKilometros(matricula,nuevosKilometros)){
                   System.out.println("Se actualizaron los KMs con éxito");
               } else{
                   System.out.println("No se pudieron actualizas lor KMs");
               }
               opcion(concesionario);

            }
            case 5 -> {}
            default -> System.out.println("Introduce un número del 1 al 5");
        }
    }
}
