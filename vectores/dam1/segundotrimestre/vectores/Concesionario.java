package dam1.segundotrimestre.vectores;


public class Concesionario {
    private Vehiculo[] coches;
    private int numeroCoches;
    private final int MAXIMO_COCHES = 50;

    Concesionario(){
        coches = new Vehiculo[MAXIMO_COCHES];
        numeroCoches = 0;
    }

    public Vehiculo buscarVehiculo(String matricula){
        for (int i = 0; i < numeroCoches; i++) {
            if (coches[i].tieneMatricula(matricula)){
                return coches[i];
            }
        }
        return null;
    }

    public int insertarVehiculo() {
        Vehiculo nuevoCoche = new Vehiculo();

        if(this.numeroCoches == 50){
            return -1;
        }else if (buscarVehiculo(nuevoCoche.getMatricula()) != null) {
            return -2;
        }

        coches[numeroCoches] = nuevoCoche;
        numeroCoches++;
        return 0;
    }

    public void listarVehiculos(){
        for (int i = 0; i < numeroCoches ; i++) {
            System.out.println(coches[i].toString());
        }
    }

    public boolean actualizarKilometros(String matricula, int numeroKilometros){
        Vehiculo coche = buscarVehiculo(matricula);

        return coche != null && coche.cambiarKilometros(numeroKilometros);
    }
}
