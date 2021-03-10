package Models.Trabajador;

public abstract class Trabajador {
	protected int id;
	protected String nombre;
	protected double salario;

	public int getId(){
		return this.id;
	}

	public Trabajador(int id, String nombre, double salario) {
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
	}

	public String getTipoTrabajador(){
		return this.getClass().getSimpleName().toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}

	@Override
	public String toString() {
		return "Id trabajador: " + this.id + ", "
				+ "Nombre trabajador: " + this.nombre + ", "
				+ "Salario trabajador: " + this.salario; 
	}
	
}