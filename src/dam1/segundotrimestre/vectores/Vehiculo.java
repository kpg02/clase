package dam1.segundotrimestre.vectores;

import java.time.LocalDate;

public class Vehiculo {
    private int numeroKilometros;
    private float precio;
    private String matricula;
    private String marca;
    private String descripcion;
    private String nombrePropietario;
    private String dni;
    LocalDate fechaMatriculacion;


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
}
