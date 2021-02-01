package dam1.segundotrimestre.vectores;


public class Concesionario {
    private Vehiculo[] coches;
    private int numeroCoches;
    private final int MAXIMO_COCHES = 50;

    Concesionario(){
        coches = new Vehiculo[MAXIMO_COCHES];
        numeroCoches = 0;
    }

    private Vehiculo buscarVehiculo(String matricula){
        for (int i = 0; i < numeroCoches; i++) {
            if (coches[i].tieneMatricula(matricula)){
                return coches[i];
            }
        }
        return null;
    }

    private int insertarVehiculo() {
        Vehiculo nuevoCoche = new Vehiculo();

        if(this.numeroCoches == 50){
            return -2;
        }else if (buscarVehiculo(nuevoCoche.getMatricula()) != null) {
            return -1;
        }

        coches[numeroCoches] = nuevoCoche;
        numeroCoches++;
        return 0;
    }

    private void listarVehiculos(){
        for (int i = 0; i < numeroCoches ; i++) {
            System.out.println(coches[i].toString());
        }
    }

    private boolean actualizarKilometros(String matricula, int numeroKilometros){
        Vehiculo coche = buscarVehiculo(matricula);

        return coche != null && coche.cambiarKilometros(numeroKilometros);
    }
}
