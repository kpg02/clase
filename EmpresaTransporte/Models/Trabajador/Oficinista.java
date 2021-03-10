package Models.Trabajador;


public class Oficinista extends Trabajador {
	private String nombreDepartamento;

	public Oficinista(String nombreDepartamento, int id, String nombre, double salario) {
		super(id, nombre, salario);
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getDepartamento(){
		return this.nombreDepartamento;
	}

	public boolean setDepartamento(String departamento){
		if (this.nombreDepartamento.equals(departamento)){
			return false;
		}
		this.nombreDepartamento = departamento;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", "
		+ "Departamento: " + this.nombreDepartamento;
	}

	
}

